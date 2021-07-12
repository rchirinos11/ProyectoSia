package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

import lombok.Setter;
import lombok.Getter;

@Where(clause = "active=true")
@Entity @Getter @Setter 
public class MeasurementLevel {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_measurement_level")
	private Integer id;
	@ManyToOne @JoinColumn(name="id_specialty")
	private Specialty specialty;
	@ManyToOne @JoinColumn(name="id_semester")
	private Semester semester;
	private Integer orden;
	private String name;	
	private Integer isMinimum=0;
}
