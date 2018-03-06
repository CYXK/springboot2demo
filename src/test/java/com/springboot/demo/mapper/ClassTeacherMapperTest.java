package com.springboot.demo.mapper;

import com.springboot.demo.bean.ClassTeacher;
import com.springboot.demo.bean.ClassTeacherExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: liuyanlong
 * @date: created in 2018/3/6 12:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassTeacherMapperTest {

    @Resource
    private ClassTeacherMapper classTeacherMapper;

    @Test
    public void testSelect() {
        ClassTeacherExample classTeacherExample = new ClassTeacherExample();

        List<ClassTeacher> classTeachers = classTeacherMapper.selectByExample(classTeacherExample);
        classTeachers.get(0).setId(null);

        classTeachers.forEach(System.out::println);
    }


}
