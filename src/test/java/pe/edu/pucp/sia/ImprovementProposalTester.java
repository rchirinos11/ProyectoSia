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
import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.requests.CreateImprovementPlanRequest;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.ImprovementPlanService;
import pe.edu.pucp.sia.service.ImprovementProposalService;
import pe.edu.pucp.sia.service.SpecialtyService;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;
import pe.edu.pucp.sia.service.impl.ImprovementPlanServiceImpl;
import pe.edu.pucp.sia.service.impl.ImprovementProposalServiceImpl;
import pe.edu.pucp.sia.service.impl.SpecialtyServiceImpl;
/*
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ImprovementProposalTester {
	@Autowired
	ImprovementProposalService service = new ImprovementProposalServiceImpl();
	@Autowired
	ImprovementPlanService serviceImprovementPlan = new ImprovementPlanServiceImpl();
	@Autowired
	SpecialtyService serviceSpecialty = new SpecialtyServiceImpl();
	@Autowired
	FacultyService serviceFaculty = new FacultyServiceImpl();
	
	@Test
	@Order(1)
	public void insertImprovementProposalRecieveId() {
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
		Integer id =  service.createImprovementProposal(improvementProposal);
		
		//Lista las oportunidades de mejora
		Iterable<ImprovementProposal> listI = service.listAll();
		
		//Comprueba id devuelta sea el mismo que el de BD
		improvementProposal = listI.iterator().next();
		assertEquals("Descripción propuesta",improvementProposal.getDescription());
		assertThat(id==improvementProposal.getId());
	}
	
	@Test
	@Order(2)
	public void updateImprovementProposal(){
		Iterable<ImprovementProposal> list = service.listAll();
		ImprovementProposal improvementProposal = list.iterator().next();
		//Cambia un parametro
		improvementProposal.setDescription("Descripción de la propuesta");
		service.updateImprovementProposal(improvementProposal);
		//Obtiene lista nueva actualizada
		list = service.listAll();
		assertEquals("Descripción de la propuesta",list.iterator().next().getDescription());
		}
	
	@Test
	@Order(3)
	public void logicDeleteImprovementPlan(){
		Iterable<ImprovementProposal> list = service.listAll();
		ImprovementProposal improvementProposal = list.iterator().next();
		//Delete logico
		improvementProposal.setActive(false);
		service.updateImprovementProposal(improvementProposal);
		//Obtiene lista nueva actualizada
		list = service.listAll();
		assertThat(list).isEmpty();
		//Dejar todo desactivado
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
	
}*/