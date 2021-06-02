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
public class Person_X_Measurement_Plan_Line {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_person_measurement_plan_line")
	private Integer id;
	
	@JoinColumn(name="id_person", referencedColumnName = "id_person")
	@ManyToOne
	private Person person;
	@JoinColumn(name="id_measurement_plan_line", referencedColumnName = "id_measurement_plan_line")
	@ManyToOne
	private MeasurementPlanLine measurementPlanLine;
	
	private boolean active=true;

}
