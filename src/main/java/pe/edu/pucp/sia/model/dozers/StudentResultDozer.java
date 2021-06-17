package pe.edu.pucp.sia.model.dozers;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import pe.edu.pucp.sia.model.EducationalObjective;
import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.Semester;
import pe.edu.pucp.sia.model.Specialty;

@Getter @Setter
public class StudentResultDozer {
    private Integer id;

	private Specialty specialty;

	private EducationalObjective educationalObjective;

	private Semester semesterStart;
    
	private Semester semesterEnd;
	private int orderNumber;
	private String description;

    private List<Indicator> indicators;
}
