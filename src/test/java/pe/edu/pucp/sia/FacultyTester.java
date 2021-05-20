package pe.edu.pucp.sia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.PersonService;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;
import pe.edu.pucp.sia.service.impl.PersonServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FacultyTester {
	
	@Autowired
	FacultyService service = new FacultyServiceImpl();
	
	@Autowired
	PersonService serviceCoordinator = new PersonServiceImpl();
	
	@Test
	@Order(1)
	public void insertFacultyAndRecieveId() {
		//Crea facultad
		Faculty faculty = new Faculty();
		faculty.setName("Humanidades");
		//Llama al metodo crear Facultad y obtiene el ID
		Integer id = service.createFaculty(faculty);
		//Lista las facultades
		Iterable<Faculty> list = service.listAll();
		//Comprueba id devuelta sea el mismo que el de BD
		faculty = list.iterator().next();
		assertEquals("Humanidades",faculty.getName());
		assertThat(id==faculty.getId());
	}

	@Test
	@Order(2)
	public void updateFaculty(){
		//Obtiene facultad agregada
		Iterable<Faculty> list = service.listAll();
		Faculty faculty = list.iterator().next();
		//Cambia un parametro
		faculty.setName("Ciencias e Ingenieria");
		service.updateFaculty(faculty);
		//Obtiene lista nueva actualizada
		list = service.listAll();
		assertEquals("Ciencias e Ingenieria",list.iterator().next().getName());
		}
	
	@Test
	@Order(3)
	public void logicDeleteFaculty(){
		//Obtiene facultad agregada
		Iterable<Faculty> list = service.listAll();
		Faculty faculty = list.iterator().next();
		//Delete logico
		faculty.setActive(false);
		service.updateFaculty(faculty);
		//Obtiene lista nueva actualizada
		list = service.listAll();
		assertThat(list).isEmpty();
		}
	
	@Test
	@Order(4)
	public void listByCoordinator(){
		//Crea facultad
		Faculty faculty = new Faculty();
		faculty.setName("Arte");
		Person coordinator = new Person();
		coordinator.setName("Pablo");
		serviceCoordinator.createPerson(coordinator);
		faculty.setCoordinator(coordinator);
		//Llama al metodo crear Facultad y obtiene el ID
		Integer id = service.createFaculty(faculty);
		
		//Obtiene facultad agregada
		Iterable<Faculty> list = service.listByCoordinator(id);
		//Obtiene lista nueva actualizada
		list = service.listAll();
		assertEquals("Arte",list.iterator().next().getName());
		}
}
