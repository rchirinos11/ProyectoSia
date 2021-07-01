//Request inserted. If fails, delete file

package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentResultSemestersRequest {
    private Integer idSemesterStart;
	private Integer idSemesterEnd;
}
