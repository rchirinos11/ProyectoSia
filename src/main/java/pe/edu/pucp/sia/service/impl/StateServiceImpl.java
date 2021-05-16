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
	public Integer createState(State s) {
		Integer response = 0;
		try {
			response = stateRepository.save(s).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateState(State s) {
		Integer response = 0;
		try {
			response = stateRepository.save(s).getId();
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
