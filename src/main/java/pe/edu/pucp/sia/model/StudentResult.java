package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentResult {
	@Id @Column(name="id_student_result") @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="id_student_result")
	private Speciality speciality;
	@ManyToOne
	@JoinColumn(name="id_educational_objective")
	private EducationalObjective educationalObjective;
	/*
	@ManyToOne
	@JoinColumn(name="id_semester_start")
	private Semester semesterStart;
	@ManyToOne
	@JoinColumn(name="id_semester_end")
	private Semester semesterEnd;
	*/
	private String description;
}
