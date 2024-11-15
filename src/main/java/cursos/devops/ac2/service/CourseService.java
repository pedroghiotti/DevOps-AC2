package cursos.devops.ac2.service;

import cursos.devops.ac2.dto.CourseDTO;
import cursos.devops.ac2.entity.Course;
import cursos.devops.ac2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired private CourseRepository courseRepository;

    public Course createCourse(CourseDTO courseDTO) {
        Course newCourse = Course.fromDTO(courseDTO);
        courseRepository.save(newCourse);
        return newCourse;
    }

    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(CourseDTO::fromEntity).collect(Collectors.toList());
    }

    @Transactional
    public CourseDTO getCourseById(Long id) {
        return CourseDTO.fromEntity(courseRepository.getReferenceById(id));
    }

}
