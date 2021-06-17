package pe.edu.pucp.sia.model.comparators;

import java.util.Comparator;

import pe.edu.pucp.sia.model.LevelDetail;

public class LevelDetailComparator implements Comparator<LevelDetail> {

    @Override
    public int compare(LevelDetail o1, LevelDetail o2) {
        return o1.getMeasurementLevel().getOrden().compareTo(o2.getMeasurementLevel().getOrden());
    }
    
}
