package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.LevelDetail;

public interface IndicatorRepository extends CrudRepository<Indicator,Integer>{
    
    public List<Indicator> findBystudentResultIdOrderByCode(Integer id);
    public List<Indicator> findBystudentResultId(Integer id);
    public List<Indicator> findBystudentResultSpecialtyIdOrderByCodeAsc(Integer id);
    @Query(value = "call sp_list_indicator_by_specialty(:in_id_specialty)", nativeQuery = true)
    public List<Indicator> findBystudentResultSpecialtyId(@Param("in_id_specialty") Integer idSpecialty);
    
    @Procedure("sp_delete_indicator")
	public void deleteIndicator(Integer id);
}
