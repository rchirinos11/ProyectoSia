package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DeleteMultipleMeasurementRequest {
	private Integer idTeacher;
	private Integer idSection;
	private Integer idCourse;
	private Integer idSemester;
}
