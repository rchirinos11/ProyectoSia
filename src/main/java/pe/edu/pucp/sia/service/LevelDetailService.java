package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.response.ApiResponse;

public interface LevelDetailService {
	public ApiResponse  listAll();
	public ApiResponse  listBySpecialty(Integer idSpecialty);
	public ApiResponse createLevelDetail(LevelDetail ld);
	public ApiResponse updateLevelDetail(LevelDetail ld);
	public ApiResponse deleteLevelDetail(Integer id);

}
