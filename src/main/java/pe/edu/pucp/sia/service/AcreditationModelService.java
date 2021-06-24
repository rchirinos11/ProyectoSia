package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.AcreditationModel;
import pe.edu.pucp.sia.response.ApiResponse;

public interface AcreditationModelService {
    public ApiResponse listAll();
    public ApiResponse createAcreditationModel(AcreditationModel a);
	public ApiResponse updateAcreditationModel(AcreditationModel a);
	public ApiResponse deleteAcreditationModel(Integer id);
	
}
