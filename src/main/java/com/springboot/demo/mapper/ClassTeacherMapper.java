package com.springboot.demo.mapper;

import com.springboot.demo.bean.ClassTeacher;
import com.springboot.demo.bean.ClassTeacherExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
public interface ClassTeacherMapper {
    @SelectProvider(type=ClassTeacherSqlProvider.class, method="countByExample")
    long countByExample(ClassTeacherExample example);

    @DeleteProvider(type=ClassTeacherSqlProvider.class, method="deleteByExample")
    int deleteByExample(ClassTeacherExample example);

    @Delete({
        "delete from class_teacher",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into class_teacher (class_name, teacher_id)",
        "values (#{className,jdbcType=VARCHAR}, #{teacherId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(ClassTeacher record);

    @InsertProvider(type=ClassTeacherSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(ClassTeacher record);

    @SelectProvider(type=ClassTeacherSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER)
    })
    List<ClassTeacher> selectByExample(ClassTeacherExample example);

    @Select({
        "select",
        "id, class_name, teacher_id",
        "from class_teacher",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="teacher_id", property="teacherId", jdbcType=JdbcType.INTEGER)
    })
    ClassTeacher selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ClassTeacherSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ClassTeacher record, @Param("example") ClassTeacherExample example);

    @UpdateProvider(type=ClassTeacherSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ClassTeacher record, @Param("example") ClassTeacherExample example);

    @UpdateProvider(type=ClassTeacherSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ClassTeacher record);

    @Update({
        "update class_teacher",
        "set class_name = #{className,jdbcType=VARCHAR},",
          "teacher_id = #{teacherId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ClassTeacher record);
}