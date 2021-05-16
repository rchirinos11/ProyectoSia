package pe.edu.pucp.sia.model;

import java.time.LocalDate;

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
public class Activity {
	@Id @Column(name="id_activity") 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="id_state")
	private State state;
	@ManyToOne
	@JoinColumn(name="id_improvement_proposal")
	private ImprovementProposal improvementProposal;
	private String description;
	private LocalDate yearStart;
	private LocalDate yearEnd;
	private String responsible;
	private boolean active;
	/*
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public State getState() {
		return this.state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public ImprovementProposal getImprovementProposal() {
		return this.improvementProposal;
	}
	public void setImprovementProposal(ImprovementProposal improvementProposal) {
		this.improvementProposal = improvementProposal;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	
	public LocalDate getYearStart() {
		return this.yearStart;
	}
	public void setYearStart(LocalDate yearStart) {
		this.yearStart = yearStart;
	}
	
	public LocalDate getYearEnd() {
		return this.yearEnd;
	}
	public void setYearEnd(LocalDate yearEnd) {
		this.yearEnd = yearEnd;
	}
	*/
}
