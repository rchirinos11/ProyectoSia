package pe.edu.pucp.sia.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Semester;

@Getter @Setter
public class SemesterPercentagesDataResponse {
	Semester semester;
	List<StudentResultIndicatorsCoursesPercentagesDataResponse> percentages;
}
