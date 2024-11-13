package cursos.devops.ac2.dto;

import cursos.devops.ac2.entity.Course;
import cursos.devops.ac2.value_object.CourseID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private CourseID courseID;
    private String name;
    private String description;
    private Double baseValue;

    public static CourseDTO fromEntity(Course course) {
        CourseDTO courseDTO = new CourseDTO(
                course.getId(),
                course.getCourseID(),
                course.getName(),
                course.getDescription(),
                course.getBaseValue()
        );

        return courseDTO;
    }
}
