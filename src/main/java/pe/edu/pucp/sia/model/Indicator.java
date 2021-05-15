package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Indicator {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_indicator")
    private Integer id;
    private String description;
    private boolean active;
    
}
