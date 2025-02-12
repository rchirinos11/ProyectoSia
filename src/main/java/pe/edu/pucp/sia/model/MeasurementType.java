package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class MeasurementType {
    @Id @Column(name="id_measurement_type") @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;   
    private String description;    
}
