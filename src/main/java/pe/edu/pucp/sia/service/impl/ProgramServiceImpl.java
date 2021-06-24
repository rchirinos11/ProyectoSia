package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Program;
import pe.edu.pucp.sia.repository.ProgramRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<Program> list = programRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

    @Override
    public ApiResponse createProgram(Program p) {
        ApiResponse response = null;
		try {
			Integer id = programRepository.save(p).getId(); 
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

    @Override
    public ApiResponse updateProgram(Program p) {
        ApiResponse response = null;
		try {
			Integer id = programRepository.save(p).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

    @Override
    public ApiResponse deleteProgram(Integer id) {
        ApiResponse response = null;
		try {
			programRepository.deleteProgram(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }
    
}
