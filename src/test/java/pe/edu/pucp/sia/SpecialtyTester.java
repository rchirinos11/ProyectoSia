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
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.PersonService;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;
import pe.edu.pucp.sia.service.impl.PersonServiceImpl;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;
/*
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SpecialtyTester {
	
	@Autowired
	SpecialtyService serviceSpecialty = new SpecialtyServiceImpl();
	
	@Autowired
	FacultyService serviceFaculty = new FacultyServiceImpl();
	
	@Autowired
	PersonService servicePerson = new PersonServiceImpl();
	
	Faculty faculty1 = new Faculty();
	Faculty faculty2 = new Faculty();
	Integer idSpecialty1,idSpecialty2,idSpecialty3;
	
	@Test
	@Order(1)
	public void insertSpecialityAndRecieveId() {
		//Crea facultades
		faculty1.setName("Ciencias");
		serviceFaculty.createFaculty(faculty1);
		faculty2.setName("Letras");
		serviceFaculty.createFaculty(faculty2);
		
		//Crea specialidad
		Specialty specialty = new Specialty();
		specialty.setName("Mecanica");
		specialty.setFaculty(faculty1);
		idSpecialty1 = serviceSpecialty.createSpecialty(specialty);
		
		//Lista las especialidades
		Iterable<Specialty> list = serviceSpecialty.listAll();
		//Comprueba id devuelta sea el mismo que el de BD
		specialty = list.iterator().next();
		assertEquals("Mecanica",specialty.getName());
		assertThat(idSpecialty1==specialty.getId());
		
	}
	
	@Test
	@Order(2)
	public void updateSpecialty(){
		//Obtiene specialty agregada
		Iterable<Specialty> list = serviceSpecialty.listAll();
		Specialty specialty = list.iterator().next();
		//Cambia un parametro
		specialty.setName("Informatica");
		serviceSpecialty.updateSpecialty(specialty);
		//Obtiene lista nueva actualizada
		list = serviceSpecialty.listAll();
		assertEquals("Informatica",list.iterator().next().getName());
		}
	
	@Test
	@Order(3)
	public void listByFaculty(){
		//Selecciona facultades
		Iterable<Faculty> lista = serviceFaculty.listAll();
		for (Faculty f : lista) {
			if (f.getName()=="Ciencias") faculty1=f;
			if (f.getName()=="Letras") faculty2=f;
		}
		
		Specialty specialty1 = new Specialty();
		Specialty specialty2 = new Specialty();
		Iterable<Specialty> list;
		
		//Asigna a specialidades
		specialty1.setFaculty(faculty1);
		specialty1.setName("Electronica");
		specialty2.setFaculty(faculty2);
		specialty2.setName("Literatura");
		//Llama al metodo crear Specialidad y obtiene el ID
		idSpecialty2 = serviceSpecialty.createSpecialty(specialty1);
		idSpecialty3 = serviceSpecialty.createSpecialty(specialty2);
		
		//Obtiene listas
		list = serviceSpecialty.listAll();
		assertThat(list).size().isEqualTo(3);
		list = serviceSpecialty.listByFaculty(faculty1.getId());
		assertThat(list).size().isEqualTo(2);
		list = serviceSpecialty.listByFaculty(faculty2.getId());
		assertThat(list).size().isEqualTo(1);
		}
	
	@Test
	@Order(4)
	public void logicDeleteSpecialty(){
		//Obtiene facultad agregada
		Iterable<Specialty> list = serviceSpecialty.listAll();
		for (Specialty s : list) {
			//Delete logico
			s.setActive(false);
			serviceSpecialty.updateSpecialty(s);
		}
		//Obtiene lista nueva actualizada
		list = serviceSpecialty.listAll();
		assertThat(list).isEmpty();
		terminaTest();
		}
	
	@Test
	@Order(5)
	private void terminaTest() {
		Iterable<Faculty> listf = serviceFaculty.listAll();
		for (Faculty f : listf) {
			//Delete logico
			f.setActive(false);
			serviceFaculty.updateFaculty(f);
		}
	}
	

	
}
*/