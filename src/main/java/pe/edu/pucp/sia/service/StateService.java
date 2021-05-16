package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.State;

public interface StateService {
	public Iterable<State>  listAll();
	public Integer createState(State s);
	public Integer updateState(State s);
	public String deleteState(Integer id);
}