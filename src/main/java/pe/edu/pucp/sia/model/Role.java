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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Role {
    @Id @Column(name="id_role") @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer id;
    private String description;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "role_person_list", 
		joinColumns = @JoinColumn(name = "id_role"), 
		inverseJoinColumns = @JoinColumn(name = "id_person"))
    private List<Person> personList;
    //private boolean active;
    
    public Role() {
    }
    
    public Role(int id) {
    	this.id = id;
    }
}
