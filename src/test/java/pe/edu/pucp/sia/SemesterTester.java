package pe.edu.pucp.sia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.service.SemesterService;
import pe.edu.pucp.sia.service.impl.SemesterServiceImpl;
/*
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class SemesterTester {
	@Autowired
	SemesterService service = new SemesterServiceImpl();
	
	@Test
	@Order(1)
	public void insertSemesterRecieveId() {
		Semester semester = new Semester();
		semester.setYear(2021);
		semester.setNumber(1);

		Integer id = service.createSemester(semester);
		Iterable<Semester> list = service.listAll();
		semester = list.iterator().next();
		assertEquals(2021,semester.getYear());
		assertEquals(1,semester.getNumber());
		assertThat(id==semester.getId());
	}
	
	@Test
	@Order(2)
	public void updateSemester(){
		Iterable<Semester> list = service.listAll();
		Semester semester = list.iterator().next();
		//Cambia un parametro
		semester.setYear(2022);
		semester.setNumber(0);
		service.updateSemester(semester);
		//Obtiene lista nueva actualizada
		list = service.listAll();
		assertEquals(2022,list.iterator().next().getYear());
		assertEquals(0,list.iterator().next().getNumber());
		}
	
	@Test
	@Order(3)
	public void logicDeleteSemester(){
		Iterable<Semester> list = service.listAll();
		Semester semester = list.iterator().next();
		//Delete logico
		semester.setActive(false);
		service.updateSemester(semester);
		//Obtiene lista nueva actualizada
		list = service.listAll();
		assertThat(list).isEmpty();
		}
}
*/