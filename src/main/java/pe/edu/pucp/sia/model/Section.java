package pe.edu.pucp.sia.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Section {
    @Id @Column(name="id_section") @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private int code;
    private boolean active;
    //@ForeignKey(name="id_measurement_plan_line");
    //private Integer ;
    
}