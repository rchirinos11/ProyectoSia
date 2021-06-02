package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Section_X_Measurement_Plan_Line;
import pe.edu.pucp.sia.repository.Section_X_Measurement_Plan_Line_Repository;
import pe.edu.pucp.sia.service.Section_X_Measurement_Plan_Line_Service;

@Service
public class Section_X_Measurement_Plan_Line_ServiceImpl implements Section_X_Measurement_Plan_Line_Service {

	@Autowired
	private Section_X_Measurement_Plan_Line_Repository section_X_Measurement_Plan_Line_Repository;
	
	@Override
	public Iterable<Section_X_Measurement_Plan_Line> listAll() {
			return section_X_Measurement_Plan_Line_Repository.findAll();
	}

	@Override
	public Integer createSxM(Section_X_Measurement_Plan_Line ld) {
		Integer response =0;
		try {
			response=section_X_Measurement_Plan_Line_Repository.save(ld).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updateSxM(Section_X_Measurement_Plan_Line ld) {
		Integer response =0;
		try {
			response=section_X_Measurement_Plan_Line_Repository.save(ld).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteSxM(Integer id) {
		String response = "";
		try {
			section_X_Measurement_Plan_Line_Repository.deleteSxM(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
