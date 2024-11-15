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
    private String cid;
    private String name;
    private String description;
    private Double baseValue;

    public static CourseDTO fromEntity(Course course) {
        return new CourseDTO(
                course.getCourseID().getCid(),
                course.getName(),
                course.getDescription(),
                course.getBaseValue()
        );
    }
}
