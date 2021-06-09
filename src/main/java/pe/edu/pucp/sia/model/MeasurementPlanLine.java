package pe.edu.pucp.sia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Setter;
import lombok.Getter;

@Where(clause="active=true")
@Entity @Getter @Setter
public class MeasurementPlanLine {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_measurement_plan_line")
	private Integer id;
	@ManyToOne @JoinColumn(name="id_course")
	private Course course;
	@ManyToOne @JoinColumn(name="id_semester")
	private Semester semester;
	@ManyToOne @JoinColumn(name="id_indicator")
	private Indicator indicator;	
	@ManyToOne @JoinColumn(name="id_measurement_type")
	private MeasurementType measurementType;
	private int sampleStudents;
	private String evidenceName;
	private String evaluatoryActivity;
	
	@ManyToMany @JoinTable(name="measurementplanline_section_list",
			joinColumns = @JoinColumn(name = "id_measurement_plan_line"), 
			inverseJoinColumns = @JoinColumn(name = "id_section"))
	private List<Section> sections;

	@ManyToMany @JoinTable(name="measurementplanline_person_list",
			joinColumns = @JoinColumn(name = "id_measurement_plan_line"), 
			inverseJoinColumns = @JoinColumn(name = "id_person"))
	private List<Person> persons;
		
	 @OneToMany(mappedBy = "measurementPlanLine")	 
	 private List<ResultsPerCard> resultsPerCards;
	
}
