package pe.edu.pucp.sia.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class MeasurementLevel {
    @Id @Column(name="id_measurement_level") @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private int order;
    private String name;
    private float successRate;
    private boolean active;    

    //@ForeignKey(name="id_specialty);
    //private Integer id_specialty;
}
