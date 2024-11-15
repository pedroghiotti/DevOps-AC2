package cursos.devops.ac2.repository;

import cursos.devops.ac2.entity.Student_Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_CourseRepository extends JpaRepository<Student_Course, Long> {
}
