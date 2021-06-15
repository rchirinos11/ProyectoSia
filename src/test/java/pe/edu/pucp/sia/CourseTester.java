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
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.service.CourseService;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.MeasurementLevelService;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.impl.CourseServiceImpl;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;
import pe.edu.pucp.sia.service.impl.MeasurementLevelServiceImpl;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

//Viene de MeasurementLevelTester
public class CourseTester {

    @Autowired 
    CourseService serviceCourse = new CourseServiceImpl();  
	
	
	@Test
	@Order(1)
	public void insertCourseAndRecieveId() {
		//Crea un curso.
        Course course = new Course();
		course.setCode("1INF06");
        course.setName("Sistemas Operativos");
        //Llamamos al metodo para insertar un curso.
        Integer id = serviceCourse.createCourse(course);
        //Lista los cursos
		Iterable<Course> list = serviceCourse.listAll();
		course = list.iterator().next();
		assertEquals("Sistemas Operativos",course.getName());
		assertThat(id==course.getId());
        assertEquals("1INF06",course.getCode());
	}
		
	
	
	@Test
	@Order(2)
	public void updateCoursel(){
		//Obtiene curso agregado
		Iterable<Course> list = serviceCourse.listAll();
		Course course = list.iterator().next();
		//Cambia un parametro
		course.setName("Tecnicas de Programacion");
		serviceCourse.updateCourse(course);
		//Obtiene lista nueva actualizada
		list = serviceCourse.listAll();
		assertEquals("Tecnicas de Programacion", list.iterator().next().getName());
		}
	
	@Test
	@Order(3)
	public void logicDeleteCourse(){
			//Obtiene curso agregado
            Iterable<Course> list = serviceCourse.listAll();
            Course course = list.iterator().next();
            //Delete logico
            course.setActive(false);
            serviceCourse.updateCourse(course);
            //Obtiene lista nueva actualizada
            list = serviceCourse.listAll();
            assertThat(list).isEmpty();
		}
	
	@Test
	@Order(4)
	private void terminaTest() {
		Iterable<Course> lists = serviceCourse.listAll();
		for (Course c : lists) {
			//Delete logico
			c.setActive(false);
			serviceCourse.updateCourse(c);
		}	
	}
	
	
}
