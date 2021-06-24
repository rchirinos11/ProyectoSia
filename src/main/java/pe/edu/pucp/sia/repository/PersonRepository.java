package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Semester;

public interface PersonRepository extends CrudRepository<Person,Integer>{
	public Person findByEmail(String email);
	public Iterable<Person> findByEmailIsNotNull();
	public Person findByCode(String code);
	@Query(value = "call sp_list_unfinished_teachers(:in_id_semester,:in_id_specialty)", nativeQuery = true)
	public Iterable<Person> listUnfinishedTeachers(@Param("in_id_semester") Integer idSemester, @Param("in_id_specialty") Integer idSpecialty);
	@Query(value = "call sp_list_teachers_by_specialty(:in_id_specialty)", nativeQuery = true)
	public Iterable<Person> listTeachersBySpecialty(@Param("in_id_specialty") Integer idSpecialty);
}
