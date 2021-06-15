package pe.edu.pucp.sia;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.Course;
import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.MeasurementLevel;
import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.service.CourseService;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.MeasurementLevelService;
import pe.edu.pucp.sia.service.SectionService;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.impl.CourseServiceImpl;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;
import pe.edu.pucp.sia.service.impl.MeasurementLevelServiceImpl;
import pe.edu.pucp.sia.service.impl.SectionServiceImpl;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

//Viene de MeasurementLevelTester
public class SectionTester {
	
    @Autowired 
    SectionService serviceSection = new SectionServiceImpl();
    
	
	
	@Test
	@Order(1)
	public void insertSectionAndRecieveId() {
		//Crea un curso.
        Section section = new Section();		
        section.setCode(20151460);
        //Llamamos al metodo para insertar un curso.
        Integer id = serviceSection.createSection(section);
        //Lista los cursos
		Iterable<Section> list = serviceSection.listAll();
		section = list.iterator().next();		
		assertThat(id==section.getId());
        assertEquals(20151460,section.getCode());
	}
		
	
	
	@Test
	@Order(2)
	public void updateSection(){
		//Obtiene curso agregado
		Iterable<Section> list = serviceSection.listAll();
		Section section = list.iterator().next();
		//Cambia un parametro
		section.setCode(20161359);
		serviceSection.updateSection(section);
		//Obtiene lista nueva actualizada
		list = serviceSection.listAll();
		assertEquals(20161359, list.iterator().next().getCode());
		}
	
	@Test
	@Order(3)
	public void logicDeleteSection(){
			//Obtiene curso agregado
            Iterable<Section> list = serviceSection.listAll();
            Section section = list.iterator().next();
            //Delete logico
            section.setActive(false);
            serviceSection.updateSection(section);
            //Obtiene lista nueva actualizada
            list = serviceSection.listAll();
            assertThat(list).isEmpty();
		}
	
	private void terminaTest() {
		Iterable<Section> lists = serviceSection.listAll();
		for (Section s : lists) {
			//Delete logico
			s.setActive(false);
			serviceSection.updateSection(s);
		}	
	}
	
	
}
