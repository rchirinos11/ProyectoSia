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
	@ManyToOne @JoinColumn(name="id_results_per_card")
	private ResultsPerCard resultsPerCard;
	@ManyToOne @JoinColumn(name="id_person")
	private Person person;
	@ManyToOne @JoinColumn(name="id_measurement_level")
	private MeasurementLevel measurementLevel;
	private boolean active=true;
	public ResultsPerCard getResultsPerCard() {
		return null;
	}	
}
