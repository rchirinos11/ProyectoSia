package pe.edu.pucp.sia.response;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.model.Specialty;

@Getter @Setter
public class PersonDataResponse {
	Person person;
	Iterable<Faculty> coordinatingFacultyList;
	Iterable<Specialty> coordinatingSpecialtyList;
	Iterable<Specialty> assistingSpecialtyList;	
}
