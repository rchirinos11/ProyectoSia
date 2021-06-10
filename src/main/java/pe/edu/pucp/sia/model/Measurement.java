	package pe.edu.pucp.sia.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;
import lombok.Getter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class Measurement {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_measurement")
	private Integer id;
	
	//@JsonIgnore
	@JoinColumn(name="id_results_per_card", referencedColumnName = "id_results_per_card")
	@ManyToOne
	private ResultsPerCard resultsPerCard;
	
	@JoinColumn(name="id_person")
	@ManyToOne
	private Person person;
	
	@JoinColumn(name="id_measurement_level", referencedColumnName = "id_measurement_level")
	@ManyToOne
	private MeasurementLevel measurementLevel;
	
	//private Integer orden;
	//private String name;	
	private boolean active=true;

	public ResultsPerCard getResultsPerCard() {
		return null;
	}	
	
	
	
}
