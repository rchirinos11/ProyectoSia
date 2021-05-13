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
public class MeasurementLevel {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_measurement_level")
	private Integer idMeasurementLevel;
	
	@JoinColumn(name="id_speciality", referencedColumnName = "id_speciality")
	@ManyToOne
	private Speciality speciality;
	private Integer orden;
	private String name;	
	//@Column(name="success_rate")
	private Float successRate;	
	private Boolean active;
	public Integer getIdMeasurementLevel() {
		return idMeasurementLevel;
	}
	public void setIdMeasurementLevel(Integer idMeasurementLevel) {
		this.idMeasurementLevel = idMeasurementLevel;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getSuccessRate() {
		return successRate;
	}
	public void setSuccessRate(Float successRate) {
		this.successRate = successRate;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}	
	
}
