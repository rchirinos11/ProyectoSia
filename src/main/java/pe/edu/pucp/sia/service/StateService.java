package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.State;

public interface StateService {
	public Iterable<State>  listAll();
	public String createState(State s);
	public String updateState(State s);
	public String deleteState(Integer id);
}