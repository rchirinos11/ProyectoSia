package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Indicator;

public interface IndicatorRepository extends CrudRepository<Indicator,Integer>{
    
    public List<Indicator> findBySpecialtyId(Integer id);
    
    @Procedure("sp_delete_indicator")
	public void deleteIndicator(Integer id);
}
