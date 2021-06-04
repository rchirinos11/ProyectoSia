package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Activity;

@Getter @Setter
public class CreateImprovementProposalRequest {
	private Integer id;
	private String description;
	Iterable<Activity> activities;
}
