package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.State;

@Getter @Setter
public class ImprovementPlanActivityRequest {
	Iterable<State> states;
	Integer idSemesterStart;
	Integer idSemesterEnd;
	Integer idSpecialty;
}
