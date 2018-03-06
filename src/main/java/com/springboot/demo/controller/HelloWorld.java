package com.springboot.demo.controller;

import com.springboot.demo.pojo.rsp.BaseRsp;
import com.springboot.demo.service.ClassTeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: liuyanlong
 * @date: created in 2018/3/5 20:27
 */
@RestController
public class HelloWorld {

    @Resource
    private ClassTeacherService classTeacherService;

    @RequestMapping("/teachers")
    public BaseRsp sayHello() {
        try {
            classTeacherService.addClassTeacher();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classTeacherService.getClassTeachers();
    }

}
