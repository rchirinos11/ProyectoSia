package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.AcreditationModel;

public interface AcreditationModelService {
    public Iterable<AcreditationModel> listAll();
    public Integer createAcreditationModel(AcreditationModel a);
	public Integer updateAcreditationModel(AcreditationModel a);
	public String deleteAcreditationModel(Integer id);
	
}
