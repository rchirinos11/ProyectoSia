package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.State;
import pe.edu.pucp.sia.response.ApiResponse;

public interface StateService {
	public ApiResponse listAll();
	public ApiResponse createState(State s);
	public ApiResponse updateState(State s);
	public ApiResponse deleteState(Integer id);
}