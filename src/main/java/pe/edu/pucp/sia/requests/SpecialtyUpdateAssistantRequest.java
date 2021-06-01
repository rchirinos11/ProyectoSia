package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SpecialtyUpdateAssistantRequest {
	private Integer idSpecialty;
	private Integer idAssistant;
}
