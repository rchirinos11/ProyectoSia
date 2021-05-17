package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.LevelDetail;

public interface LevelDetailRepository extends CrudRepository <LevelDetail,Integer>{
	@Procedure("sp_delete_level_detail")
	public void deleteLevelDetail(Integer id);
}
