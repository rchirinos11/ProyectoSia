package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.SuccessPercentage;


public interface SuccessPercentageRepository extends CrudRepository<SuccessPercentage,Integer>{
	Iterable<SuccessPercentage> findBySpecialtyIdAndSemesterId (Integer idSpecialty, Integer idSemester);

}
