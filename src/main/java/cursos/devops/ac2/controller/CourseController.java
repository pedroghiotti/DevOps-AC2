package cursos.devops.ac2.controller;

import cursos.devops.ac2.dto.CourseDTO;
import cursos.devops.ac2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseDTO> getCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public void createCourse(@RequestBody CourseDTO courseDTO) {
        courseService.createCourse(courseDTO);
    }
}
