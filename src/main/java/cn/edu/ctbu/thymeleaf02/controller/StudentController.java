package cn.edu.ctbu.thymeleaf02.controller;

import cn.edu.ctbu.thymeleaf02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String list() {
        return "/student/list";
    }

}
