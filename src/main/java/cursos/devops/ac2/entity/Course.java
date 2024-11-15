package cursos.devops.ac2.entity;

import cursos.devops.ac2.dto.CouponDTO;
import cursos.devops.ac2.dto.CourseDTO;
import cursos.devops.ac2.value_object.CourseID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull @Embedded private CourseID courseID;

    @NonNull private String name;
    @NonNull private String description;
    @NonNull private Double baseValue;

    public Course(CourseDTO courseDTO) {
        this.courseID = new CourseID(courseDTO.getCid());
        this.name = courseDTO.getName();
        this.description = courseDTO.getDescription();
        this.baseValue = courseDTO.getBaseValue();
    }

    public static Course fromDTO(CourseDTO courseDTO) {
        return new Course(courseDTO);
    }
}
