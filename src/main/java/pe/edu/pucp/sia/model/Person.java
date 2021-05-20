package pe.edu.pucp.sia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class Person {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_person")
	private Integer id;
	private String code;
	private String name;
	private String pLastName;
	private String mLastName;
	private String email;
	private boolean active=true;
	
	@ManyToMany
	@JoinTable(name = "role_person_list",
			joinColumns = @JoinColumn(name = "id_person"), 
			inverseJoinColumns = @JoinColumn(name = "id_role"))
	private List<Role> roleList;
}
