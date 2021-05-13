package pe.edu.pucp.sia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Setter;
import lombok.Getter;

@Entity @Getter @Setter
public class MeasurementCard {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_measurement_card")
	private Integer idMeasurementCard;

	/*@JoinColumn(name="id_measurement_type", referencedColumnName = "id_measurement_type")
	@ManyToOne
	private MeasurementType measurementType;*/
	
	@JoinColumn(name="id_person", referencedColumnName = "id_person")
	@ManyToOne
	private Person person;
	
	@JoinColumn(name="id_course", referencedColumnName = "id_course")
	@ManyToOne
	private Course course;
	
	private LocalDate date;	
	private Boolean active;
	public Integer getIdMeasurementCard() {
		return idMeasurementCard;
	}
	public void setIdMeasurementCard(Integer idMeasurementCard) {
		this.idMeasurementCard = idMeasurementCard;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}	
	
	
	
}
