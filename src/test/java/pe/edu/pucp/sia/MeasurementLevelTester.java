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
import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.MeasurementLevelService;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;
import pe.edu.pucp.sia.service.impl.MeasurementLevelServiceImpl;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MeasurementLevelTester {
	@Autowired
	SpecialtyService serviceSpecialty = new SpecialtyServiceImpl();

	@Autowired
	FacultyService serviceFaculty = new FacultyServiceImpl();
	
	@Autowired
	MeasurementLevelService serviceMeasurementLevel = new MeasurementLevelServiceImpl();
	
	@Test
	@Order(1)
	public void insertMeasurementLevelAndRecieveId() {
		//Crea facultad y especialidad
		Faculty faculty = new Faculty();
		faculty.setName("Ciencias");
		serviceFaculty.createFaculty(faculty);
		
		Specialty specialty = new Specialty();
		specialty.setName("Informatica");
		specialty.setFaculty(faculty);
		serviceSpecialty.createSpecialty(specialty);
		
		//Crea MeasurementLevel
		MeasurementLevel measurementLevel = new MeasurementLevel();
		measurementLevel.setOrden(1);
		measurementLevel.setName("Desempeña correctamente");
		measurementLevel.setSpecialty(specialty);
		Integer id = serviceMeasurementLevel.createMeasurementLevel(measurementLevel);
		
		//Lista los studentResults
		Iterable<MeasurementLevel> list = serviceMeasurementLevel.listAll();
		//Comprueba id devuelta sea el mismo que el de BD
		measurementLevel = list.iterator().next();
		assertEquals(1,measurementLevel.getOrden());
		assertEquals("Desempeña correctamente",measurementLevel.getName());
		assertThat(id==measurementLevel.getId());
	}
	
	@Test
	@Order(2)
	public void updateMeasurementLevel(){
		Iterable<MeasurementLevel> list = serviceMeasurementLevel.listAll();
		MeasurementLevel measurementLevel = list.iterator().next();
		//Cambia un parametro
		measurementLevel.setName("Terminó trabajo con exito.");
		serviceMeasurementLevel.updateMeasurementLevel(measurementLevel);
		//Obtiene lista nueva actualizada
		list = serviceMeasurementLevel.listAll();
		assertEquals("Terminó trabajo con exito.",list.iterator().next().getName());
		}
	
	@Test
	@Order(3)
	public void logicDeleteMeasurementLevel(){
		//Obtiene measurementLevel
		Iterable<MeasurementLevel> list = serviceMeasurementLevel.listAll();
		for (MeasurementLevel ml : list) {
			//Delete logico
			ml.setActive(false);
			serviceMeasurementLevel.updateMeasurementLevel(ml);
		}
		//Obtiene lista nueva actualizada
		list = serviceMeasurementLevel.listAll();
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
