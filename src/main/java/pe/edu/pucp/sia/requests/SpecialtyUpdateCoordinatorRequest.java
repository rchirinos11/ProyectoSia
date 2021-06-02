package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SpecialtyUpdateCoordinatorRequest {
	private Integer idSpecialty;
	private Integer idCoordinator;
}
