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
    public Integer createProgram(Program p) {
        Integer response = 0;
		try {
			response = programRepository.save(p).getId(); 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }

    @Override
    public Integer updateProgram(Program p) {
        Integer response = 0;
		try {
			response = programRepository.save(p).getId();
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
