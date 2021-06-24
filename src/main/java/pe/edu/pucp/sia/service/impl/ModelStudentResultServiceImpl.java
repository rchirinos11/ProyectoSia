package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.ModelStudentResult;
import pe.edu.pucp.sia.repository.ModelStudentResultRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.ModelStudentResultService;

@Service
public class ModelStudentResultServiceImpl implements ModelStudentResultService {

    @Autowired
    private ModelStudentResultRepository modelStudentResultRepository;

    @Override
    public ApiResponse listAll() {
		ApiResponse response = null;
		try {
			Iterable<ModelStudentResult> list = modelStudentResultRepository.findAll();
			response = new ApiResponse(list,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

    @Override
	public ApiResponse createModelStudentResult(ModelStudentResult m) {
		ApiResponse response = null;
		try {
			Integer id = modelStudentResultRepository.save(m).getId(); 
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

    @Override
	public ApiResponse updateModelStudentResult(ModelStudentResult m) {
		ApiResponse response = null;
		try {
			Integer id = modelStudentResultRepository.save(m).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

    @Override
    public ApiResponse deleteModelStudentResult(Integer id) {
        ApiResponse response = null;
		try {
			modelStudentResultRepository.deleteModelStudentResult(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }
    
}
