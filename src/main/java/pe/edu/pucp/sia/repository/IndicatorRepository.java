package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.Indicator;

public interface IndicatorRepository extends CrudRepository<Indicator,Integer>{
    @Procedure("sp_delete_indicator")
	public void deleteIndicator(Integer id);
    public Iterable<Indicator> findByStudentResultId(Integer id);
}
