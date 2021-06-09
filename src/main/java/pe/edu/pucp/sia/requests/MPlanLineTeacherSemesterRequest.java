package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MPlanLineTeacherSemesterRequest {
	private Integer idTeacher;
	private Integer idSemester;
}
