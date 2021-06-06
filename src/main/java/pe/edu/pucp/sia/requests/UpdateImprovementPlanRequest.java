package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.model.Specialty;

@Getter @Setter
public class UpdateImprovementPlanRequest {
	private Integer id;
	private Specialty specialty;
	private String title;
	private String opportunity;
	Iterable<ImprovementProposal> improvementProposals;
}
