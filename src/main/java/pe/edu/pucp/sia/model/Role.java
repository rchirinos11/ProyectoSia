package pe.edu.pucp.sia.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Role {
    @Id @Column(name="id_role") @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer id;
    private String description;    
}
