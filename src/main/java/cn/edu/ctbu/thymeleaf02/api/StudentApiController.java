package cn.edu.ctbu.thymeleaf02.api;


import cn.edu.ctbu.thymeleaf02.core.R;
import cn.edu.ctbu.thymeleaf02.entity.Student;
import cn.edu.ctbu.thymeleaf02.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentApiController {

    @Autowired
    private StudentService studentService;



    @GetMapping("/listall")
    public R<List<Student>> list()
    {
        return R.ok(studentService.findAll());

    }


    @GetMapping("/list")
    public R<List<Student>> list(Student student,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int limit)
    {
        Pageable pageable = PageRequest.of(page -1, limit, Sort.by("id").descending());

        ExampleMatcher matcher = ExampleMatcher.matching()
                 .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sNo", ExampleMatcher.GenericPropertyMatchers.contains());

        if("".equals(student.getName()))student.setName(null);

        Page<Student>pageData=studentService.findAll(Example.of(student,matcher),pageable);

        return R.page(pageData.getTotalElements(),pageData.getContent());
    }
}
