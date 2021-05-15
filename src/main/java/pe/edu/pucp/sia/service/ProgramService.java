package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Program;

public interface ProgramService {
    public Iterable<Program>  listAll();
	public Integer createProgram(Program p);
	public Integer updateProgram(Program p);
	public String deleteProgram(Integer id);
}
