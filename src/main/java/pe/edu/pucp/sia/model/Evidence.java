package pe.edu.pucp.sia.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Evidence {
    @Id @Column(name="id_evidence") @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    private boolean active;

    //@ForeignKey(name="id_activity");
    //private Integer id_activity;
    //@ForeignKey(name="id_measurement_card");
    //private Integer id_measurement_card;
    
}
