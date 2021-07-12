package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class ImprovementProposal {
	@Id @Column(name="id_improvement_proposal") 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne	@JoinColumn(name="id_improvement_plan")
	private ImprovementPlan improvementPlan;
	private String description;
}
