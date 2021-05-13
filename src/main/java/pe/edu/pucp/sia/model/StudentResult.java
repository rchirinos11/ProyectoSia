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
	@JoinColumn(name="id_speciality")
	private Speciality speciality;
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
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Speciality getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
	public EducationalObjective getEducationalObjective() {
		return educationalObjective;
	}
	public void setEducationalObjective(EducationalObjective educationalObjective) {
		this.educationalObjective = educationalObjective;
	}
	public Semester getSemesterStart() {
		return semesterStart;
	}
	public void setSemesterStart(Semester semesterStart) {
		this.semesterStart = semesterStart;
	}
	public Semester getSemesterEnd() {
		return semesterEnd;
	}
	public void setSemesterEnd(Semester semesterEnd) {
		this.semesterEnd = semesterEnd;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
