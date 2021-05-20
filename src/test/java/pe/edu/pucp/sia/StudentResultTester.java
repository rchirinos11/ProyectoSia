package pe.edu.pucp.sia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.StudentResultService;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;
import pe.edu.pucp.sia.service.impl.StudentResultServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StudentResultTester {
	@Autowired
	SpecialtyService serviceSpecialty = new SpecialtyServiceImpl();
	
	@Autowired
	FacultyService serviceFaculty = new FacultyServiceImpl();
	
	@Autowired
	StudentResultService serviceStudentResult = new StudentResultServiceImpl();
	
	@Test
	@Order(1)
	public void insertStudentResultAndRecieveId() {
		//Crea facultad y especialidad
		Faculty faculty = new Faculty();
		faculty.setName("Ciencias");
		serviceFaculty.createFaculty(faculty);
		
		Specialty specialty = new Specialty();
		specialty.setName("Informatica");
		specialty.setFaculty(faculty);
		serviceSpecialty.createSpecialty(specialty);
		
		//Crea StudentResult
		StudentResult studenResult = new StudentResult();
		studenResult.setOrderNumber(1);
		studenResult.setDescription("Sabe leer");
		studenResult.setSpecialty(specialty);
		Integer id = serviceStudentResult.createStudentResult(studenResult);
		
		//Lista los studentResults
		Iterable<StudentResult> list = serviceStudentResult.listAll();
		//Comprueba id devuelta sea el mismo que el de BD
		studenResult = list.iterator().next();
		assertEquals(1,studenResult.getOrderNumber());
		assertEquals("Sabe leer",studenResult.getDescription());
		assertThat(id==studenResult.getId());
	}
	
	@Test
	@Order(2)
	public void updateStudentResult(){
		Iterable<StudentResult> list = serviceStudentResult.listAll();
		StudentResult studentResult = list.iterator().next();
		//Cambia un parametro
		studentResult.setDescription("Sabe bailar");
		serviceStudentResult.updateStudentResult(studentResult);
		//Obtiene lista nueva actualizada
		list = serviceStudentResult.listAll();
		assertEquals("Sabe bailar",list.iterator().next().getDescription());
		}
	
	@Test
	@Order(3)
	public void listBySpeciality(){
		//Crea facultad y especialidad
		Faculty faculty = new Faculty();
		faculty = serviceFaculty.listAll().iterator().next();
		
		Specialty specialty1 = new Specialty();
		specialty1 = serviceSpecialty.listAll().iterator().next();
		Specialty specialty2 = new Specialty();
		specialty2.setName("Mecanica");
		specialty2.setFaculty(faculty);
		serviceSpecialty.createSpecialty(specialty2);
		
		//Agrega otros Student Results.
		StudentResult studenResult1 = new StudentResult();
		StudentResult studenResult2 = new StudentResult();
		studenResult1.setOrderNumber(1);
		studenResult1.setDescription("Sabe cantar");
		studenResult1.setSpecialty(specialty1);
		serviceStudentResult.createStudentResult(studenResult1);
		
		studenResult2.setOrderNumber(2);
		studenResult2.setDescription("Dibuja planos");
		studenResult2.setSpecialty(specialty2);
		serviceStudentResult.createStudentResult(studenResult2);
		//Obtiene listas
		Iterable<StudentResult> list;
		list = serviceStudentResult.listAll();
		assertThat(list).size().isEqualTo(3);
		list = serviceStudentResult.listBySpecialty(specialty1.getId());
		assertThat(list).size().isEqualTo(2);
		list = serviceStudentResult.listBySpecialty(specialty2.getId());
		assertThat(list).size().isEqualTo(1);
		}
	
	@Test
	@Order(4)
	public void logicDeleteStudentResult(){
		//Obtiene student results agregada
		Iterable<StudentResult> list = serviceStudentResult.listAll();
		for (StudentResult sr : list) {
			//Delete logico
			sr.setActive(false);
			serviceStudentResult.updateStudentResult(sr);
		}
		//Obtiene lista nueva actualizada
		list = serviceStudentResult.listAll();
		assertThat(list).isEmpty();
		terminaTest();
		}
	
	private void terminaTest() {
		Iterable<Specialty> lists = serviceSpecialty.listAll();
		for (Specialty s : lists) {
			//Delete logico
			s.setActive(false);
			serviceSpecialty.updateSpecialty(s);
		}
		
		Iterable<Faculty> listf = serviceFaculty.listAll();
		for (Faculty f : listf) {
			//Delete logico
			f.setActive(false);
			serviceFaculty.updateFaculty(f);
		}
	}
}
