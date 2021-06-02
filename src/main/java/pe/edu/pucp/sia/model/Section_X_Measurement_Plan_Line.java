package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

import lombok.Setter;
import lombok.Getter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class Section_X_Measurement_Plan_Line {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_section_measurement_plan_line")
	private Integer id;
	
	@JoinColumn(name="id_section", referencedColumnName = "id_section")
	@ManyToOne
	private Section section;
	@JoinColumn(name="id_measurement_plan_line", referencedColumnName = "id_measurement_plan_line")
	@ManyToOne
	private MeasurementPlanLine measurementPlanLine;
	
	private boolean active=true;
	
}
