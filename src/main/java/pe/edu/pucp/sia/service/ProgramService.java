package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Program;
import pe.edu.pucp.sia.response.ApiResponse;

public interface ProgramService {
    public ApiResponse listAll();
	public ApiResponse createProgram(Program p);
	public ApiResponse updateProgram(Program p);
	public ApiResponse deleteProgram(Integer id);
}
