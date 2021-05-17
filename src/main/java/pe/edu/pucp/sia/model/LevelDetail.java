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
public class LevelDetail {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_level_detail")
	private Integer id;
	
	@JoinColumn(name="id_measurement_level", referencedColumnName = "id_measurement_level")
	@ManyToOne
	private MeasurementLevel measurementLevel;
	private String description;	
	private boolean active=true;
}
