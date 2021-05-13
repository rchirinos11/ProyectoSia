package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.State;
import pe.edu.pucp.sia.repository.StateRepository;
import pe.edu.pucp.sia.service.StateService;

@Service
public class StateServiceImpl implements StateService{
	@Autowired
	private StateRepository stateRepository;
	
	@Override
	public Iterable<State> listAll() {
		 return stateRepository.findAll();
	}

	@Override
	public String createState(State s) {
		String response = "";
		try {
			stateRepository.save(s);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateState(State s) {
		String response = "";
		try {
			stateRepository.save(s);
			response = "Updated";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteState(Integer id) {
		String response = "";
		try {
			stateRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
