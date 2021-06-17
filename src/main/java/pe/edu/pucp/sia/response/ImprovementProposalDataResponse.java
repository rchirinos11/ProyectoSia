package pe.edu.pucp.sia.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Activity;

@Getter @Setter
public class ImprovementProposalDataResponse {
	private Integer id;
	private String description;
	List<Activity> activities;
}
