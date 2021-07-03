package pe.edu.pucp.sia.response;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.model.Indicator;

@Getter @Setter
public class IndicatorCoursePercentageDataResponse {
	Indicator indicator;
	Course	course;
	Float percentage;
}
