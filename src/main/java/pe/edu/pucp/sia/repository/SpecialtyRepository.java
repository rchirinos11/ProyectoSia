package pe.edu.pucp.sia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.pucp.sia.model.Person;

import pe.edu.pucp.sia.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty,Integer>{
	public List<Specialty> findByFacultyId(Integer id);
	public List<Specialty> findByCoordinatorId(Integer id);
	public List<Specialty> findByAssistantId(Integer id);
	
	public Iterable<Specialty> findByCoordinatorEmail(String email);
	public Iterable<Specialty> findByAssistantEmail(String email);
	
	@Procedure("sp_delete_specialty")
	public void deleteSpecialty(Integer id);
	@Procedure("sp_set_specialty_coordinator")
	public void setCoordinator(Integer idSpecialty,Integer idCoordinator);
	@Procedure("sp_set_specialty_assistant")
	public void setAssistant(Integer idSpecialty,Integer idAssistant);
	
	@Procedure("sp_set_specialty_percentage")
	public void setPercentage(Integer idSpecialty,Integer idSemester, Integer percentage);
	@Procedure("sp_archive_specialty")
	public void archiveSpecialty(Integer idSpecialty,boolean state);

}
