package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Setter;
import lombok.Getter;

@Entity @Getter @Setter
public class MeasurementPlanLine {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_person")
	private Integer id;
	@ManyToOne @Column(name="id_course")
	private Course course;
	@ManyToOne @Column(name="id_semester")
	private Semester semester;
	@ManyToOne @Column(name="id_indicator")
	private Indicator indicator;
//	@ManyToOne @Column(name="id_section")
//	private Section section;
	private int sampleStudents;
	private String evaluatoryActivity;
	private boolean active;
}
