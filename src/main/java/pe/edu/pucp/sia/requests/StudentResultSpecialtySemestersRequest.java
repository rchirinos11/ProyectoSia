package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentResultSpecialtySemestersRequest {
	Integer idSpecialty;
	Integer idSemesterStart;
	Integer idSemesterEnd;
}
