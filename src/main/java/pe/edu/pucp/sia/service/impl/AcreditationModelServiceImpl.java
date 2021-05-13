package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.AcreditationModel;
import pe.edu.pucp.sia.repository.AcreditationModelRepository;
import pe.edu.pucp.sia.service.AcreditationModelService;

@Service
public class AcreditationModelServiceImpl implements AcreditationModelService {

    @Autowired
    private AcreditationModelRepository acreditationModelRepository;

    @Override
    public Iterable<AcreditationModel> listAll() {
        return acreditationModelRepository.findAll();
    }

    @Override
	public Integer createAcreditationModel(AcreditationModel a) {
		Integer response = 0;
		try {
			response = acreditationModelRepository.save(a).getId(); 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

    @Override
	public Integer updateAcreditationModel(AcreditationModel a) {
		Integer response = 0;
		try {
			response = acreditationModelRepository.save(a).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

    @Override
    public String deleteAcreditationModel(Integer id) {
        String response = "";
		try {
			acreditationModelRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }

    
    
}
