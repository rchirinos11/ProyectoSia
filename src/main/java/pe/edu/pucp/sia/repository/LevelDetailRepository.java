package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.LevelDetail;

public interface LevelDetailRepository extends CrudRepository <LevelDetail,Integer>{
	@Query(value = "call sp_list_level_detail_by_specialty(:in_id_specialty)", nativeQuery = true)
	public Iterable<LevelDetail> listLevelDetailBySpecialty(@Param("in_id_specialty") Integer idSpecialty);
	
	
	@Procedure("sp_delete_level_detail")
	public void deleteLevelDetail(Integer id);
}
