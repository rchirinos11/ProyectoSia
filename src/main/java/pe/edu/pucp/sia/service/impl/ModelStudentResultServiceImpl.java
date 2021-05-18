package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.ModelStudentResult;
import pe.edu.pucp.sia.repository.ModelStudentResultRepository;
import pe.edu.pucp.sia.service.ModelStudentResultService;

@Service
public class ModelStudentResultServiceImpl implements ModelStudentResultService {

    @Autowired
    private ModelStudentResultRepository modelStudentResultRepository;

    @Override
    public Iterable<ModelStudentResult> listAll() {
        return modelStudentResultRepository.findAll();
    }

    @Override
	public Integer createModelStudentResult(ModelStudentResult m) {
		Integer response = 0;
		try {
			response = modelStudentResultRepository.save(m).getId(); 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

    @Override
	public Integer updateModelStudentResult(ModelStudentResult m) {
		Integer response = 0;
		try {
			response = modelStudentResultRepository.save(m).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

    @Override
    public String deleteModelStudentResult(Integer id) {
        String response = "";
		try {
			modelStudentResultRepository.deleteModelStudentResult(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }
    
}
