package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.repository.LevelDetailRepository;
import pe.edu.pucp.sia.service.LevelDetailService;

@Service
public class LevelDetailServiceImpl implements LevelDetailService{
	@Autowired
	private LevelDetailRepository levelDetailRepository;
	
	@Override
	public Iterable<LevelDetail> listAll() {
		return levelDetailRepository.findAll();
	}

	@Override
	public Integer createLevelDetail(LevelDetail ld) {
		Integer response =0;
		try {
			response=levelDetailRepository.save(ld).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateLevelDetail(LevelDetail ld) {
		Integer response =0;
		try {
			response=levelDetailRepository.save(ld).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteLevelDetail(Integer id) {
	String response = "";
		try {
			levelDetailRepository.deleteLevelDetail(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<LevelDetail> listBySpecialty(Integer idSpecialty) {
		Iterable<LevelDetail> lista =levelDetailRepository.listLevelDetailBySpecialty(idSpecialty);
		for(LevelDetail l : lista) {	
			l.setMeasurementLevel(null);
			l.setIndicator(null);
		}
		return lista;
	}

}
