package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class StudentResult {
	@Id @Column(name="id_student_result") @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="id_specialty")
	private Specialty specialty;
	@ManyToOne
	@JoinColumn(name="id_educational_objective")
	private EducationalObjective educationalObjective;
	@ManyToOne
	@JoinColumn(name="id_semester_start")
	private Semester semesterStart;
	@ManyToOne
	@JoinColumn(name="id_semester_end")
	private Semester semesterEnd;
	private int orderNumber;
	private String description;
	private boolean active;
}
