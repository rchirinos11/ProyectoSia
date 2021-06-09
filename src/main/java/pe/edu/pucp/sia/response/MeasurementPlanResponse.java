package pe.edu.pucp.sia.response;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.ResultsPerCard;
import pe.edu.pucp.sia.model.Section;

@Getter @Setter
public class MeasurementPlanResponse {
	MeasurementPlanLine measurementPlanLine;
	Iterable<ResultsPerCard> resultsPerCardList;
	Iterable<Section> sectionList;
}
