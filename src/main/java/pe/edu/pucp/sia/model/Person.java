package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Person {
	@Id @Column(name="id_person") @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String code;
	private String name;
	private String pLastName;
	private String mLastName;
	private String email;
	//@ManyToOne						//Esto lo agregan para sus FK
	//@JoinColumn(name="id_person")		//Esto lo agregan para sus FK
	//private ClasePadre clasePadre;	//Esto lo agregan para sus FK
}
