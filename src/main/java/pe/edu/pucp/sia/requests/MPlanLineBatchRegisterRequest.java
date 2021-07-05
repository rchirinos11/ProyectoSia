package pe.edu.pucp.sia.requests;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.MeasurementPlanLine;

@Getter @Setter
public class MPlanLineBatchRegisterRequest {
	List<Integer> indicators;
	MeasurementPlanLine measurementPlanLine;
}
