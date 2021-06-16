package pe.edu.pucp.sia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.repository.LevelDetailRepository;
import pe.edu.pucp.sia.repository.MeasurementLevelRepository;
import pe.edu.pucp.sia.service.MeasurementLevelService;
@Service
public class MeasurementLevelServiceImpl implements MeasurementLevelService {
	@Autowired
	private MeasurementLevelRepository measurementLevelRepository;

	@Autowired
	private LevelDetailRepository levelDetailRepository;

	@Override
	public Iterable<MeasurementLevel> listAll() {
		return measurementLevelRepository.findAllByOrderByOrdenAsc();
	}

	@Override
	public Integer createMeasurementLevel(MeasurementLevel ml) {
		Integer response =0;
		try {
			response=measurementLevelRepository.save(ml).getId();
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateMeasurementLevel(MeasurementLevel ml) {
		Integer response =0;
		try {
			response=measurementLevelRepository.save(ml).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteMeasurementLevel(Integer id) {
		String response = "";
		List<LevelDetail> lista = null;
		try {
			lista = levelDetailRepository.findByMeasurementLevelId(id);
			for (LevelDetail ld : lista) {
				levelDetailRepository.deleteLevelDetail(ld.getId());
			}
			measurementLevelRepository.deleteMeasurementLevel(id);
			response = "Deleted"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Iterable<MeasurementLevel> listBySpecialty(Integer id) {
		Iterable<MeasurementLevel> lista = measurementLevelRepository.findBySpecialtyIdOrderByOrdenAsc(id);
		for (MeasurementLevel ml : lista) {
			ml.setSpecialty(null);
		}
		return lista;
	}

	@Override
	public Integer updateCurrentMeasurementLevel(Integer id) {
		Integer response =0;
		Integer specialtyId=0;
		try {
			MeasurementLevel ml = measurementLevelRepository.findById(id).get();
			ml.setIsMinimum(1);		
			response=measurementLevelRepository.save(ml).getId();
			
			specialtyId=ml.getSpecialty().getId();			
			Iterable<MeasurementLevel> lista = measurementLevelRepository.findAll();
			for(MeasurementLevel m : lista) {
				if(m.getSpecialty()!=null)				
					if (m.getSpecialty().getId()==specialtyId && (m.getId())!=response) {
							m.setIsMinimum(0);
							measurementLevelRepository.save(m);
					}
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
