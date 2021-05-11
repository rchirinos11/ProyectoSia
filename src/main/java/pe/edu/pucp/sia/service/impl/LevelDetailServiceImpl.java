package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.LevelDetail;
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
	public String createLevelDetail(LevelDetail ld) {
		String response = "";
		try {
			levelDetailRepository.save(ld);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateLevelDetail(LevelDetail ld) {
		String response = "";
		try {
			levelDetailRepository.save(ld);
			response = "Updated"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteLevelDetail(Integer id) {
	String response = "";
		try {
			levelDetailRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
