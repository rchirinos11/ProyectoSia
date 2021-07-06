package pe.edu.pucp.sia.response;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Semester;

@Getter @Setter
public class SemesterPercentageFlagDataResponse {
	Semester semester;
	Float percentage;
	Integer flag;
}
