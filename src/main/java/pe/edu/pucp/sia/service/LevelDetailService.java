package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.LevelDetail;

public interface LevelDetailService {
	public Iterable<LevelDetail>  listAll();
	public String createLevelDetail(LevelDetail ld);
	public String updateLevelDetail(LevelDetail ld);
	public String deleteLevelDetail(Integer id);

}
