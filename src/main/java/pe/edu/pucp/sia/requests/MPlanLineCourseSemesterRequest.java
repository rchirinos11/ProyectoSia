package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MPlanLineCourseSemesterRequest {
	private Integer idCourse;
	private Integer idSemester;
}
