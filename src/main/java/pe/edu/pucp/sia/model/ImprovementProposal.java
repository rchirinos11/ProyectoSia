package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class ImprovementProposal {
	
	@Id @Column(name="id_improvement_proposal") 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="id_improvement_opportunity")
	private ImprovementOpportunity improvementOpportunity;
	private String description;
	private boolean active;
	/*
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public ImprovementOpportunity getImprovementOpportunity() {
		return this.improvementOpportunity;
	}
	public void setImprovementOpportunity(ImprovementOpportunity improvementOpportunity) {
		this.improvementOpportunity = improvementOpportunity;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	*/
}
