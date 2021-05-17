package pe.edu.pucp.sia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Setter;
import lombok.Getter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class MeasurementCard {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_measurement_card")
	private Integer id;

	/*@JoinColumn(name="id_measurement_type", referencedColumnName = "id_measurement_type")
	@ManyToOne
	private MeasurementType measurementType;*/
	
	@JoinColumn(name="id_person", referencedColumnName = "id_person")
	@ManyToOne
	private Person person;
	
	@JoinColumn(name="id_course", referencedColumnName = "id_course")
	@ManyToOne
	private Course course;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;	
	private boolean active=true;
}
