package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentResultCopyRequest {
	private Integer idSpecialtyFrom;
	private Integer idSemesterFrom;
	private Integer	idSpecialtyTo;
	private Integer idSemesterTo;
}
