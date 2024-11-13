package cursos.devops.ac2.entity;

import cursos.devops.ac2.value_object.CourseID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    CourseID courseID;

    String name;
    String description;
    Double baseValue;
}
