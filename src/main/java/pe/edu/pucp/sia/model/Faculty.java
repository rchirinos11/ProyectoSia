package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Faculty {
	@Id @Column(name="id_faculty") @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;

}
