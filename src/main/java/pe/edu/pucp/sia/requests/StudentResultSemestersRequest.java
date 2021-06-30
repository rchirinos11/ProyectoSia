//Request inserted. If fails, delete file

package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Semester;

@Getter @Setter
public class StudentResultSemestersRequest {
    private Integer idSemester1;
	private Integer idSemester2;
}
