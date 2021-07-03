package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Person;

@Getter @Setter
public class MultipleMeasurementRequest {
	private Integer idProfesor;
	private Integer idSeccion;
	private Integer idCurso;
	private Integer idSemestre;
	Iterable<Person> students;
}
