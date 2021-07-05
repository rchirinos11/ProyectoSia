package pe.edu.pucp.sia.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import pe.edu.pucp.sia.model.StudentResult;

@Getter @Setter
public class StudentResultIndicatorsCoursesPercentagesDataResponse {
	StudentResult studentResult;
	List<IndicatorCoursePercentageDataResponse> listICP;
}
