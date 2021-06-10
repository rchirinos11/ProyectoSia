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
public class Course {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_course")
	private Integer id;
	private String code;
	private String name;
	@ManyToOne @JoinColumn(name="id_specialty")
	private Specialty specialty;
	private boolean active=true;
}