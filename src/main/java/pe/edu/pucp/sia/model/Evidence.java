package pe.edu.pucp.sia.model;

import java.sql.Date;

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
public class Evidence {
    @Id @Column(name="id_evidence") @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    @ManyToOne
    @JoinColumn(name="id_measurement_card")
    private MeasurementCard measurementCard;
    private String description;
    //private boolean active;
    
}
