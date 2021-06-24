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
import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.ImprovementPlanService;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;
import pe.edu.pucp.sia.service.impl.ImprovementPlanServiceImpl;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;
/*
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ImprovementPlanTester {
	@Autowired
	ImprovementPlanService service = new ImprovementPlanServiceImpl();
	@Autowired
	SpecialtyService serviceSpecialty = new SpecialtyServiceImpl();
	@Autowired
	FacultyService serviceFaculty = new FacultyServiceImpl();
	
	@Test
	@Order(1)
	public void insertImprovementPlanRecieveId() {
		//Crea facultades
		Faculty faculty = new Faculty();
		faculty.setName("Ciencias");
		serviceFaculty.createFaculty(faculty);
				
		//Crea specialidad
		Specialty specialty = new Specialty();
		specialty.setName("Mecanica");
		specialty.setFaculty(faculty);
		serviceSpecialty.createSpecialty(specialty);
		
		//Crea plan de mejora
		CreateImprovementPlanRequest improvementPlanRequest = new CreateImprovementPlanRequest();
		ImprovementPlan improvementPlan = new ImprovementPlan();
		improvementPlanRequest.setSpecialty(specialty);
		improvementPlanRequest.setTitle("Plan");
		improvementPlanRequest.setOpportunity("Oportunidad");
		Integer id = service.createImprovementPlan(improvementPlanRequest);
		
		//Lista los planes de mejora
		Iterable<ImprovementPlan> listI = service.listAll();
		
		//Comprueba id devuelta sea el mismo que el de BD
		improvementPlan = listI.iterator().next();
		assertEquals("Plan",improvementPlan.getTitle());
		assertEquals("Oportunidad",improvementPlan.getOpportunity());
		assertThat(id==improvementPlan.getId());
	}
	
	@Test
	@Order(2)
	public void updateImprovementPlan(){
		Iterable<ImprovementPlan> list = service.listAll();
		ImprovementPlan improvementPlan = list.iterator().next();
		//Cambia un parametro
		improvementPlan.setTitle("Primer plan");
		service.updateImprovementPlan(improvementPlan);
		//Obtiene lista nueva actualizada
		list = service.listAll();
		assertEquals("Primer plan",list.iterator().next().getTitle());
		}
	
	@Test
	@Order(3)
	public void logicDeleteImprovementPlan(){
		Iterable<ImprovementPlan> list = service.listAll();
		ImprovementPlan improvementPlan = list.iterator().next();
		//Delete logico
		improvementPlan.setActive(false);
		service.updateImprovementPlan(improvementPlan);
		//Obtiene lista nueva actualizada
		list = service.listAll();
		assertThat(list).isEmpty();
		//Dejar todo desactivado
		Specialty specialty = serviceSpecialty.listAll().iterator().next();
		specialty.setActive(false);
		serviceSpecialty.updateSpecialty(specialty);
		Faculty faculty = serviceFaculty.listAll().iterator().next();
		faculty.setActive(false);
		serviceFaculty.updateFaculty(faculty);
		}
	
}
*/