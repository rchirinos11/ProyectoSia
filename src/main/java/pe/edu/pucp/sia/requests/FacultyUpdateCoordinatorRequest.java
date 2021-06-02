package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FacultyUpdateCoordinatorRequest {
	private Integer idFaculty;
	private Integer idCoordinator;
}
