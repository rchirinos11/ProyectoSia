package pe.edu.pucp.sia.model.comparators;

import java.util.Comparator;

import pe.edu.pucp.sia.model.MeasurementPlanLine;

public class MeasurementPlanLineComparator implements Comparator<MeasurementPlanLine>{

    @Override
    public int compare(MeasurementPlanLine o1, MeasurementPlanLine o2) {
        return o1.getIndicator().getStudentResult().getOrderNumber()-(o2.getIndicator().getStudentResult().getOrderNumber());
        
    }
    
}
