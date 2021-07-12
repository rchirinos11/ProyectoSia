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
public class Activity {
	@Id @Column(name="id_activity") 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne @JoinColumn(name="id_state")
	private State state;
	@ManyToOne @JoinColumn(name="id_improvement_proposal")
	private ImprovementProposal improvementProposal;
	private String description;
	private String evidence;
	@ManyToOne @JoinColumn(name="id_semester_start")
	private Semester semesterStart;
	@ManyToOne @JoinColumn(name="id_semester_end")
	private Semester semesterEnd;
	private String responsible;
}
