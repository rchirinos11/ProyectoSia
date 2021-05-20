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

@Where(clause="active=true")
@Entity @Getter @Setter
public class Faculty {
	@Id @Column(name="id_faculty") @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn(name="id_coordinator")
	private Person coordinator;
	private boolean active=true;
}
