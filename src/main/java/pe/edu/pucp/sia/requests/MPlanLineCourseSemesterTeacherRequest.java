package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MPlanLineCourseSemesterTeacherRequest {
	private Integer idCourse;
	private Integer idSemester;
	private Integer idTeacher;
}
