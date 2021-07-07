package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class User {
    @Id @Column(name="id_user") @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;   
    private String username;
    private String password;
    @OneToOne @JoinColumn(name="id_person")
    private Person person;
    private boolean active;
}
