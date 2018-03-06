package com.springboot.demo.service;

import com.springboot.demo.bean.ClassTeacher;
import com.springboot.demo.bean.ClassTeacherExample;
import com.springboot.demo.mapper.ClassTeacherMapper;
import com.springboot.demo.pojo.rsp.BaseRsp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: liuyanlong
 * @date: created in 2018/3/6 13:39
 */
@Service
public class ClassTeacherService {

    @Resource
    private ClassTeacherMapper classTeacherMapper;

    public BaseRsp<List<ClassTeacher>> getClassTeachers() {
        ClassTeacherExample classTeacherExample = new ClassTeacherExample();
        List<ClassTeacher> classTeachers = classTeacherMapper.selectByExample(classTeacherExample);
        return new BaseRsp(classTeachers);
    }

    @Transactional
    public BaseRsp addClassTeacher() throws Exception {
        ClassTeacher classTeacher = new ClassTeacher();
        classTeacher.setId(5);
        classTeacher.setTeacherId(666);
        classTeacherMapper.updateByPrimaryKeySelective(classTeacher);

        ClassTeacher classTeacher1 = new ClassTeacher();
        classTeacher1.setClassName("test1");

//        classTeacherMapper.insert(classTeacher1);
//        throw new Exception();

        return new BaseRsp();
    }

}
