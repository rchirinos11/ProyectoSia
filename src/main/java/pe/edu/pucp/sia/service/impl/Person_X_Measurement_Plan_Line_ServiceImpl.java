package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Person_X_Measurement_Plan_Line;
import pe.edu.pucp.sia.repository.Person_X_Measurement_Plan_Line_Repository;
import pe.edu.pucp.sia.service.Person_X_Measurement_Plan_Line_Service;

@Service
public class Person_X_Measurement_Plan_Line_ServiceImpl implements Person_X_Measurement_Plan_Line_Service {

	@Autowired
	private Person_X_Measurement_Plan_Line_Repository person_X_Measurement_Plan_Line_Repository;
	
	@Override
	public Iterable<Person_X_Measurement_Plan_Line> listAll() {
		return person_X_Measurement_Plan_Line_Repository.findAll();
	}

	@Override
	public Integer createPxM(Person_X_Measurement_Plan_Line ld) {
		Integer response =0;
		try {
			response=person_X_Measurement_Plan_Line_Repository.save(ld).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public Integer updatePxM(Person_X_Measurement_Plan_Line ld) {
		Integer response =0;
		try {
			response=person_X_Measurement_Plan_Line_Repository.save(ld).getId();
					} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deletePxM(Integer id) {
		String response = "";
		try {
			person_X_Measurement_Plan_Line_Repository.deletePxM(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
