package pe.edu.pucp.sia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.State;
import pe.edu.pucp.sia.service.StateService;
import pe.edu.pucp.sia.service.impl.StateServiceImpl;
/*
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StateTester {

	@Autowired
	StateService serviceState = new StateServiceImpl();
	
	@Test
	@Order(1)
	public void insertStateRecieveId() {
		//Crea estado
		State state = new State();
		state.setDescription("No ini");
		Integer id = serviceState.createState(state);
		
		//Lista los estados
		Iterable<State> list = serviceState.listAll();
		state = list.iterator().next();
		assertEquals("No ini",state.getDescription());
		assertThat(id==state.getId());
	}

	@Test
	@Order(2)
	public void updateState(){
		Iterable<State> list = serviceState.listAll();
		State state = list.iterator().next();
		
		//Cambia un parametro
		state.setDescription("No iniciado");
		serviceState.updateState(state);
		
		//Obtiene lista nueva actualizada
		list = serviceState.listAll();
		assertEquals("No iniciado",state.getDescription());
		}
	
	@Test
	@Order(3)
	public void logicDeleteState(){
		Iterable<State> list = serviceState.listAll();
		State state = list.iterator().next();
		
		//Delete logico
		state.setActive(false);
		serviceState.updateState(state);
		
		//Obtiene lista nueva actualizada
		list = serviceState.listAll();
		assertThat(list).isEmpty();
		}
}
*/