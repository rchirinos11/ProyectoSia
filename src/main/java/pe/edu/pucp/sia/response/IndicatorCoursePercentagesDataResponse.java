package pe.edu.pucp.sia.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.model.Indicator;

@Getter @Setter
public class IndicatorCoursePercentagesDataResponse {
	Indicator indicator;
	Course course;
	List<SemesterPercentageFlagDataResponse> percentages;
}
