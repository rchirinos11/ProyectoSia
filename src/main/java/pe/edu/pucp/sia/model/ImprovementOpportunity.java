package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class ImprovementOpportunity {
	
	@Id @Column(name="id_improvement_opportunity") 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String description;
	private boolean active;
	/*
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	*/
}