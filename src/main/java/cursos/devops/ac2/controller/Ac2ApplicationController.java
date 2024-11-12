package cursos.devops.ac2.controller;

import cursos.devops.ac2.domain.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Ac2ApplicationController {

    @GetMapping("/students")
    private List<Student> getAllStudents() { return List.of(); }

    @GetMapping("/coupons")
    private List<Student> getAllCoupons() { return List.of(); }

    @GetMapping("/courses")
    private List<Student> getAllCourses() { return List.of(); }

}
