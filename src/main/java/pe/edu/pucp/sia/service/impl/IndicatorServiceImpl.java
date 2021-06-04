package pe.edu.pucp.sia.service.impl;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.repository.IndicatorRepository;
import pe.edu.pucp.sia.repository.LevelDetailRepository;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.service.IndicatorService;

@Service
public class IndicatorServiceImpl implements IndicatorService {

    @Autowired
	private IndicatorRepository indicatorRepository;
    @Autowired
    private LevelDetailRepository levelDetailRepository;
    @Autowired
    private MeasurementPlanLineRepository mplRepository;

    @Override
    public Iterable<Indicator> listAll() {
        return indicatorRepository.findAll();
    }

    @Override
	public Integer createIndicator(Indicator i) {
		Integer response = 0;
		try {
			for(LevelDetail l : i.getLevelDetailList()) 
				levelDetailRepository.save(l);
			
			response = indicatorRepository.save(i).getId(); 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

    @Override
    public Integer updateIndicator(Indicator i) {
        Integer response = 0;
		try {
			for(LevelDetail l : i.getLevelDetailList()) 
				levelDetailRepository.save(l);
			response = indicatorRepository.save(i).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }

    @Override
    public String deleteIndicator(Integer id) {
        String response = "";
		try {
			Iterator<MeasurementPlanLine> i = mplRepository.findByIndicatorId(id).iterator();
			if(!i.hasNext()) {
				indicatorRepository.deleteIndicator(id);
				response = "Deleted";
			} else {
				response = "Cannot delete due to dependency";
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }
    
	@Override
	public Iterable<Indicator> listBySpecialty(Integer id) {
		Iterable<Indicator> lista = indicatorRepository.findBystudentResultSpecialtyId(id);
		for (Indicator indicator: lista) {
			indicator.getStudentResult().setSpecialty(null);
		}
		return lista;
	}

}
