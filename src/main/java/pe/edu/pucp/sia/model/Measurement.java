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
	
	@JoinColumn(name="id_person", referencedColumnName = "id_person")
	@ManyToOne
	private Person person;
	
	@JoinColumn(name="id_measurement_level", referencedColumnName = "id_measurement_level")
	@ManyToOne
	private MeasurementLevel measurementLevel;
	
	private Integer order;
	private String name;	
	private Boolean active;	

}
