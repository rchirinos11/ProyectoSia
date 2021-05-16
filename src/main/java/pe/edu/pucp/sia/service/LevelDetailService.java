package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.LevelDetail;

public interface LevelDetailService {
	public Iterable<LevelDetail>  listAll();
	public Integer createLevelDetail(LevelDetail ld);
	public Integer updateLevelDetail(LevelDetail ld);
	public String deleteLevelDetail(Integer id);

}
