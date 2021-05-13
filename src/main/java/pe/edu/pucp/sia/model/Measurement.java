package pe.edu.pucp.sia.model;

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
public class Measurement {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_measurement")
	private Integer idMeasurement;
	
	
	@JoinColumn(name="id_results_per_card", referencedColumnName = "id_results_per_card")
	@ManyToOne
	private ResultsPerCard resultsPerCard;
	
	@JoinColumn(name="id_person")
	@ManyToOne
	private Person person;
	
	@JoinColumn(name="id_measurement_level", referencedColumnName = "id_measurement_level")
	@ManyToOne
	private MeasurementLevel measurementLevel;
	
	private Integer orden;
	private String name;	
	private Boolean active;
	public Integer getIdMeasurement() {
		return idMeasurement;
	}
	public void setIdMeasurement(Integer idMeasurement) {
		this.idMeasurement = idMeasurement;
	}
	public ResultsPerCard getResultsPerCard() {
		return resultsPerCard;
	}
	public void setResultsPerCard(ResultsPerCard resultsPerCard) {
		this.resultsPerCard = resultsPerCard;
	}
	public MeasurementLevel getMeasurementLevel() {
		return measurementLevel;
	}
	public void setMeasurementLevel(MeasurementLevel measurementLevel) {
		this.measurementLevel = measurementLevel;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	
	
	
}
