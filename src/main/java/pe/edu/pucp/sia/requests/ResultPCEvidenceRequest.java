package pe.edu.pucp.sia.requests;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultPCEvidenceRequest {
	private Integer idResultsPerCard;
	private List<String> evidences;
}
