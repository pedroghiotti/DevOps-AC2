package cursos.devops.ac2.controller;

import cursos.devops.ac2.dto.StudentDTO;
import cursos.devops.ac2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {

    @Autowired private StudentService studentService;

    @GetMapping
    public List<StudentDTO> getCoupons() {
        return studentService.getAllStudents();
    }

}
