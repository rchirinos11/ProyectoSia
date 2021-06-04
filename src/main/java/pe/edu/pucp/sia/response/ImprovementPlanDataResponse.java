package pe.edu.pucp.sia.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Specialty;

@Getter @Setter
public class ImprovementPlanDataResponse {
	private Integer id;
	private Specialty specialty;
	private String title;
	private String opportunity;
	List<ImprovementProposalResponse> improvementProposals;
}
