package pe.edu.pucp.sia.repository;

import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.Person;

public interface MeasurementPlanLineRepository extends CrudRepository<MeasurementPlanLine, Integer>{
	public Iterable<MeasurementPlanLine> findByCourseId(Integer id);
	public Iterable<MeasurementPlanLine> findByIndicatorStudentResultSpecialtyIdAndSemesterId(Integer idSpecialty, Integer idSemester);
	public Iterable<MeasurementPlanLine> findByCourseIdAndSemesterId(Integer idCourse, Integer idSemester);
	public Iterable<MeasurementPlanLine> findByIndicatorId(Integer id);
	public Iterable<MeasurementPlanLine> findBySemesterIdAndSectionsTeachersIn(Integer idSemester, Iterable<Person> persons);
	public Iterable<MeasurementPlanLine> findByCourseIdAndSemesterIdAndSectionsTeachersInOrderByIndicatorCodeAsc(Integer idCourse, Integer idSemester, Iterable<Person> persons);
}
