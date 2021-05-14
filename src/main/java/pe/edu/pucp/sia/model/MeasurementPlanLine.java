package pe.edu.pucp.sia.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Setter;
import lombok.Getter;

@Entity @Getter @Setter
public class MeasurementPlanLine {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private @ManyToOne @JoinColumn(name="id_course") Course course;
	private @ManyToOne @JoinColumn(name="id_semester") Semester semester;
//	private Indicator indicator;
//	private @ManyToMany Section section;
	private int sampleStudents;
	private String evaluatoryActivity;
	
}
