package pe.edu.pucp.sia.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import pe.edu.pucp.sia.model.AcreditationModel;

public interface AcreditationModelRepository extends CrudRepository<AcreditationModel,Integer> {
    @Procedure("sp_delete_acreditation_model")
	public void deleteAcreditationModel(Integer id);
}
