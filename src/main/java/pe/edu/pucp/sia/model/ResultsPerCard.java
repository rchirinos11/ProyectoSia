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
public class ResultsPerCard {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_results_per_card")
	private Integer idResultsPerCard;
	
	
	/*@JoinColumn(name="id_indicator", referencedColumnName = "id_indicator")
	@ManyToOne
	private Indicator indicator;*/
	
	@JoinColumn(name="id_measurement_card", referencedColumnName = "id_measurement_card")
	@ManyToOne
	private MeasurementCard measurementCard;
	
	@JoinColumn(name="id_measurement_level", referencedColumnName = "id_measurement_level")
	@ManyToOne
	private MeasurementLevel measurementLevel;
	
	private Float average;
	private Float percentage;
	//@Column(name="total_students")
	private Integer totalStudents;	
	private Boolean active;
	public Integer getIdResultsPerCard() {
		return idResultsPerCard;
	}
	public void setIdResultsPerCard(Integer idResultsPerCard) {
		this.idResultsPerCard = idResultsPerCard;
	}
	public MeasurementCard getMeasurementCard() {
		return measurementCard;
	}
	public void setMeasurementCard(MeasurementCard measurementCard) {
		this.measurementCard = measurementCard;
	}
	public MeasurementLevel getMeasurementLevel() {
		return measurementLevel;
	}
	public void setMeasurementLevel(MeasurementLevel measurementLevel) {
		this.measurementLevel = measurementLevel;
	}
	public Float getAverage() {
		return average;
	}
	public void setAverage(Float average) {
		this.average = average;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	public Integer getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(Integer totalStudents) {
		this.totalStudents = totalStudents;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}	
	
	
	
	
}
