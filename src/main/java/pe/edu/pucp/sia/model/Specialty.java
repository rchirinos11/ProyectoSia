package pe.edu.pucp.sia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class Specialty {
	@Id @Column(name="id_specialty") @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne @JoinColumn(name="id_faculty")
	private Faculty faculty;
	private String code;
	private String name;
	@ManyToOne @JoinColumn(name="id_coordinator")
	private Person coordinator;
	@ManyToOne @JoinColumn(name="id_assistant")
	private Person assistant;
	@OneToMany()
	@JoinColumn(name="id_specialty")
	private List<SuccessPercentage> successPercentages;
	private boolean archived;
}
