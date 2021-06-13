package pe.edu.pucp.sia.requests;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Measurement;
import pe.edu.pucp.sia.model.ResultsPerCard;

@Getter @Setter
public class RegisterStudentMeditionsRequest {
	ResultsPerCard resultsPerCard;
	List<Measurement> measurements;
}
