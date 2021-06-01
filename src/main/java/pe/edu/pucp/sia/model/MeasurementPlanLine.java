package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

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
	@ManyToOne @JoinColumn(name="id_person")
	private Person person;
	
//	@ManyToOne @Column(name="id_section")
//	private Section section;
	private int sampleStudents;
	private String evaluatoryActivity;
}
