package pe.edu.pucp.sia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class Section {
    @Id @Column(name="id_section") @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private int code;
    
    @JsonIgnore
    @ManyToMany @JoinTable(name="measurementplanline_section_list",
			joinColumns = @JoinColumn(name = "id_section"), 
			inverseJoinColumns = @JoinColumn(name = "id_measurement_plan_line"))
    private List<MeasurementPlanLine> mplanlines;

	@ManyToMany @JoinTable(name="section_person_list",
			joinColumns = @JoinColumn(name = "id_section"), 
			inverseJoinColumns = @JoinColumn(name = "id_teacher"))
	private List<Person> teachers;
}
