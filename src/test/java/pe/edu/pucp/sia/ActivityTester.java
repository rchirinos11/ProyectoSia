

package pe.edu.pucp.sia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.Activity;
import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.ImprovementPlan;
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.model.State;
import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.service.ActivityService;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.ImprovementPlanService;
import pe.edu.pucp.sia.service.ImprovementProposalService;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.StateService;
import pe.edu.pucp.sia.service.impl.ActivityServiceImpl;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;
import pe.edu.pucp.sia.service.impl.ImprovementPlanServiceImpl;
import pe.edu.pucp.sia.service.impl.ImprovementProposalServiceImpl;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;
import pe.edu.pucp.sia.service.impl.StateServiceImpl;

/*

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ActivityTester {

	@Autowired
	ActivityService serviceActivity = new ActivityServiceImpl();
	@Autowired
	ImprovementProposalService service = new ImprovementProposalServiceImpl();
	@Autowired
	ImprovementPlanService serviceImprovementPlan = new ImprovementPlanServiceImpl();
	@Autowired
	SpecialtyService serviceSpecialty = new SpecialtyServiceImpl();
	@Autowired
	FacultyService serviceFaculty = new FacultyServiceImpl();
	@Autowired
	StateService serviceState = new StateServiceImpl();
	
	@Test
	@Order(1)
	public void insertActivityRecieveId() {
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
		improvementPlan.setSpecialty(specialty);
		improvementPlan.setTitle("Plan");
		improvementPlan.setOpportunity("Oportunidad");
		improvementPlan.setId(serviceImprovementPlan.createImprovementPlan(improvementPlanRequest));
		
		//Crea propuesta de mejora
		ImprovementProposal improvementProposal = new ImprovementProposal();
		improvementProposal.setImprovementPlan(improvementPlan);
		improvementProposal.setDescription("Descripción propuesta");
		service.createImprovementProposal(improvementProposal);
		
		//Crea estado
		State state = new State();
		state.setDescription("No iniciado");
		serviceState.createState(state);		
		
		//Crea actividad
		Activity activity = new Activity();
		activity.setState(state);
		activity.setImprovementProposal(improvementProposal);
		activity.setDescription("Actividad");
		activity.setEvidence("Documentos de evidencia");
		activity.setYearStart(2020);
		activity.setYearEnd(2021);
		activity.setResponsible("Asistente");
		Integer id = serviceActivity.createActivity(activity);
		
		//Lista las actividades
		Iterable<Activity> list = serviceActivity.listAll();
		activity = list.iterator().next();
		assertEquals("Actividad",activity.getDescription());
		assertEquals("Documentos de evidencia",activity.getEvidence());
		assertEquals(2020,activity.getYearStart());
		assertEquals(2021,activity.getYearEnd());
		assertEquals("Asistente",activity.getResponsible());
		assertThat(id==activity.getId());
	}

	@Test
	@Order(2)
	public void updateActivity(){
		Iterable<Activity> list = serviceActivity.listAll();
		Activity activity = list.iterator().next();
		
		//Cambia un parametro
		activity.setDescription("Primera actividad");
		serviceActivity.updateActivity(activity);
		
		//Obtiene lista nueva actualizada
		list = serviceActivity.listAll();
		assertEquals("Primera actividad",activity.getDescription());
		}
	
	@Test
	@Order(3)
	public void logicDeleteActivity(){
		Iterable<Activity> list = serviceActivity.listAll();
		Activity activity = list.iterator().next();
		
		//Delete lógico
		activity.setActive(false);
		serviceActivity.updateActivity(activity);
		
		//Obtiene lista nueva actualizada
		list = serviceActivity.listAll();
		assertThat(list).isEmpty();
		//Dejar todo desactivado
		State state = serviceState.listAll().iterator().next();
		state.setActive(false);
		serviceState.updateState(state);
		ImprovementProposal improvementProposal = service.listAll().iterator().next();
		improvementProposal.setActive(false);
		service.updateImprovementProposal(improvementProposal);
		ImprovementPlan improvementPlan = serviceImprovementPlan.listAll().iterator().next();
		improvementPlan.setActive(false);
		serviceImprovementPlan.updateImprovementPlan(improvementPlan);
		Specialty specialty = serviceSpecialty.listAll().iterator().next();
		specialty.setActive(false);
		serviceSpecialty.updateSpecialty(specialty);
		Faculty faculty = serviceFaculty.listAll().iterator().next();
		faculty.setActive(false);
		serviceFaculty.updateFaculty(faculty);	
		}
}
*/