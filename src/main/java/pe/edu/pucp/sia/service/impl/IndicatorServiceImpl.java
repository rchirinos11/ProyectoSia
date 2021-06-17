package pe.edu.pucp.sia.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.comparators.LevelDetailComparator;
import pe.edu.pucp.sia.repository.IndicatorRepository;
import pe.edu.pucp.sia.repository.LevelDetailRepository;
import pe.edu.pucp.sia.repository.MeasurementPlanLineRepository;
import pe.edu.pucp.sia.response.ApiResponse;
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
    public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<Indicator> list = indicatorRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

    @Override
	public ApiResponse createIndicator(Indicator i) {
		ApiResponse response = null;
		try {
			for(LevelDetail l : i.getLevelDetails()) 
				levelDetailRepository.save(l);
			Integer id = indicatorRepository.save(i).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

    @Override
    public ApiResponse updateIndicator(Indicator i) {
        ApiResponse response = null;
		try {
			for(LevelDetail l : i.getLevelDetails()) 
				levelDetailRepository.save(l);
			Integer id = indicatorRepository.save(i).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

    @Override
    public ApiResponse deleteIndicator(Integer id) {
    	ApiResponse response = null;
		try {
			Iterator<MeasurementPlanLine> i = mplRepository.findByIndicatorId(id).iterator();
			Iterator<LevelDetail> l = levelDetailRepository.findByIndicatorId(id).iterator();
			if(!i.hasNext() && !l.hasNext()) {
				indicatorRepository.deleteIndicator(id);
				response = new ApiResponse("Success",200);
			} else {
				response = new ApiResponse(409,"Cannot Delete due to dependency");
			}
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }
    
	@Override
	public ApiResponse listBySpecialty(Integer id) {
		ApiResponse response = null;
		try {
			Iterable<Indicator> list = indicatorRepository.findBystudentResultSpecialtyId(id);
			for (Indicator indicator: list) {
				indicator.getStudentResult().setSpecialty(null);
				indicator.getLevelDetails().sort(new LevelDetailComparator());
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

	@Override
	public ApiResponse listByStudentResult(Integer id) {
		ApiResponse response = null;
		try {
			List<Indicator> list = indicatorRepository.findBystudentResultIdOrderByCode(id);
			for (Indicator indicator: list) {
				indicator.setStudentResult(null);
				indicator.setLevelDetails(null);
			}
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

}
