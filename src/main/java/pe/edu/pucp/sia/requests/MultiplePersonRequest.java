package pe.edu.pucp.sia.requests;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.Person;

@Getter @Setter
public class MultiplePersonRequest {
	Iterable <Person> persons;
}
