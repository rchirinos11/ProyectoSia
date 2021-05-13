package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Program;
import pe.edu.pucp.sia.repository.ProgramRepository;
import pe.edu.pucp.sia.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public Iterable<Program> listAll() {
        return programRepository.findAll();
    }

    @Override
    public String createProgram(Program p) {
        String response = "";
		try {
			programRepository.save(p);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }

    @Override
    public String updateProgram(Program p) {
        String response = "";
		try {
			programRepository.save(p);
			response = "Updated";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }

    @Override
    public String deleteProgram(Integer id) {
        String response = "";
		try {
			programRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }
    
}
