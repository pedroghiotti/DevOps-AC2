package cursos.devops.ac2.service;

import cursos.devops.ac2.dto.StudentDTO;
import cursos.devops.ac2.entity.Student;
import cursos.devops.ac2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentDTO::fromEntity).collect(Collectors.toList());
    }

}
