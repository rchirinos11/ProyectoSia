package pe.edu.pucp.sia.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.ResultsPerCard;

@Getter @Setter
public class ResultsPerCardScheduleDataResponse {
	ResultsPerCard resultsPerCard;
	int code; 
}
