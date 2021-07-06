package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class SuccessPercentage {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_successPercentage")
	private Integer id;
	@JoinColumn(name="id_specialty",referencedColumnName = "id_specialty")
	@ManyToOne
	//@JsonIgnore()
	private Specialty specialty;
	@JoinColumn(name="id_semester",referencedColumnName = "id_semester")
	@ManyToOne
	private Semester semester;
	private int percentage=70;
	public Specialty getSpecialty() {
		return null;
	}
	
	
}
