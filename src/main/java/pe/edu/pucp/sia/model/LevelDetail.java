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
public class LevelDetail {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_level_detail")
	private Integer idLevelDetail;
	
	@JoinColumn(name="id_measurement_level", referencedColumnName = "id_measurement_level")
	@ManyToOne
	private MeasurementLevel measurementLevel;
	private String description;	
	private Boolean active;
	public Integer getIdLevelDetail() {
		return idLevelDetail;
	}
	public void setIdLevelDetail(Integer idLevelDetail) {
		this.idLevelDetail = idLevelDetail;
	}
	public MeasurementLevel getMeasurementLevel() {
		return measurementLevel;
	}
	public void setMeasurementLevel(MeasurementLevel measurementLevel) {
		this.measurementLevel = measurementLevel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}	
	
	
}
