package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.MeasurementLevel;

public interface MeasurementLevelRepository extends CrudRepository <MeasurementLevel,Integer>{
	public List<MeasurementLevel> findBySpecialtyIdAndSemesterIdOrderByOrdenAsc(Integer idSpecialty,Integer idSemester);
	public List<MeasurementLevel> findAllByOrderByOrdenAsc();
	public List<MeasurementLevel> findBySemesterIdOrderByOrdenAsc(Integer idSemester);
	public MeasurementLevel findBySpecialtyIdAndSemesterIdAndIsMinimum(Integer idSpecialty,Integer idSemester,Integer minimum);
	//public MeasurementLevel findById(Integer id);
	@Procedure("sp_delete_measurement_level")
	public void deleteMeasurementLevel(Integer id);
}
