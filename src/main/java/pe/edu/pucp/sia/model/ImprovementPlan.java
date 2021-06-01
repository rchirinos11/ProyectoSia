package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class ImprovementPlan {
	
	@Id @Column(name="id_improvement_plan") 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private String opportunity;
	//private boolean active;
}
