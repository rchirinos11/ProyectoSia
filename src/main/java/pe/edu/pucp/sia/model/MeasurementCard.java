package pe.edu.pucp.sia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Setter;
import lombok.Getter;

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
	
	private Date date;	
	private Boolean active;	
}
