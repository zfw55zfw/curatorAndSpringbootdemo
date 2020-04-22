package com.newland.show.controller;

import com.newland.show.config.FastjsonUtil;
import com.newland.show.entity.Student;
import com.newland.show.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhengfawei
 * @create 2018-04-18 下午1:50
 * @desc
 **/
@Controller
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @PostMapping("/initstudent")
    @ResponseBody
    public String initStudent(){


        List<Student> list = studentService.findAll();
        String jsonStr = FastjsonUtil.listToString(list);
        logger.info(jsonStr);
        return jsonStr;
    }



}
