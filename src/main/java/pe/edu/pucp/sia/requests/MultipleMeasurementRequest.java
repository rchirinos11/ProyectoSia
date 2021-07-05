package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Person;

@Getter @Setter
public class MultipleMeasurementRequest {
	private Integer idTeacher;
	private Integer code;
	private Integer idCourse;
	private Integer idSemester;
	Iterable<Person> students;
}
