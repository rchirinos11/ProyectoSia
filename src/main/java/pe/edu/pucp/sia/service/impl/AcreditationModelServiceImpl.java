package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.AcreditationModel;
import pe.edu.pucp.sia.repository.AcreditationModelRepository;
import pe.edu.pucp.sia.response.ApiResponse;
import pe.edu.pucp.sia.service.AcreditationModelService;

@Service
public class AcreditationModelServiceImpl implements AcreditationModelService {

    @Autowired
    private AcreditationModelRepository acreditationModelRepository;

    @Override
    public ApiResponse listAll() {
    	ApiResponse response = null;
    	try {
    		Iterable<AcreditationModel> list = acreditationModelRepository.findAll();
    		response = new ApiResponse(list, 200);
    	} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
        return response;
    }

    @Override
	public ApiResponse createAcreditationModel(AcreditationModel a) {
    	ApiResponse response = null;
		try {
			Integer id = acreditationModelRepository.save(a).getId();
			response = new ApiResponse(id,201);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

    @Override
	public ApiResponse updateAcreditationModel(AcreditationModel a) {
    	ApiResponse response = null;
		try {
			Integer id = acreditationModelRepository.save(a).getId();
			response = new ApiResponse(id,200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
	}

    @Override
    public ApiResponse deleteAcreditationModel(Integer id) {
    	ApiResponse response = null;
		try {
			acreditationModelRepository.deleteAcreditationModel(id);
			response = new ApiResponse("Success",200);
		} catch(Exception ex) {
			response = new ApiResponse(500, ex.getMessage());
		}
		return response;
    }

    
    
}
