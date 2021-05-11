package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Setter;
import lombok.Getter;

@Entity @Getter @Setter
public class MeasurementLevel {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_measurement_level")
	private Integer idMeasurementLevel;
	/*@JoinColumn(name="id_speciality", referencedColumnName = "id_speciality")
	@ManyToOne
	private Speciality speciality;*/
	private Integer order;
	private String name;	
	@Column(name="succes_rate")
	private Float successRate;	
	private Boolean active;	
}
