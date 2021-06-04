package pe.edu.pucp.sia.response;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Activity;

@Getter @Setter
public class ImprovementProposalResponse {
	private Integer id;
	private String description;
	Iterable<Activity> activities;
}
