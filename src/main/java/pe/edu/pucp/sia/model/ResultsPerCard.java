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
	@Column(name="total_students")
	private Integer totalStudents;	
	private Boolean active;	
	
	
}
