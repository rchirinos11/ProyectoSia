package pe.edu.pucp.sia.response;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.StudentResult;

@Getter @Setter
public class StudentResultPercentageDataResponse {
	StudentResult studentResult;
	Float achievementPercentage;
}
