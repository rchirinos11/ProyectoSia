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

@Where(clause = "active=true")
@Entity @Getter @Setter
public class AcreditationModel {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_acreditation_model")
    private Integer id;
    private String acronym;
    @Column(name="complete_name")
    private String completeName;
    

    @JoinColumn(name="id_program", referencedColumnName = "id_program")
    @ManyToOne
    private Program program;    

    
}
