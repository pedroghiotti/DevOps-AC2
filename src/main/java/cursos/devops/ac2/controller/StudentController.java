package cursos.devops.ac2.controller;

import cursos.devops.ac2.dto.StudentDTO;
import cursos.devops.ac2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.createStudent(studentDTO);
    }

    @PostMapping("/{studentId}/acquirecourse/{courseId}")
    public void acquireCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        studentService.acquireCourse(studentId, courseId);
    }

    @PostMapping("/{studentId}/concludecourse/{courseId}/{grade}")
    public void concludeCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId, @PathVariable("grade") Double grade) {
        studentService.concludeCourse(studentId, courseId, grade);
    }
}
