package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.model.Specialty;

@Getter @Setter
public class UnfinishedTeachersRequest {
	private Integer idSpecialty;
	private Integer idSemester;
}
