package pe.edu.pucp.sia.model;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Setter;
import lombok.Getter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class ResultsPerCard {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_results_per_card")
	private Integer id;
	
	/*@JoinColumn(name="id_indicator", referencedColumnName = "id_indicator")
	@ManyToOne
	private Indicator indicator;*/
	
	/*@JoinColumn(name="id_measurement_card", referencedColumnName = "id_measurement_card")
	@ManyToOne
	private MeasurementCard measurementCard;*/
	
	/*@JoinColumn(name="id_measurement_level", referencedColumnName = "id_measurement_level")
	@ManyToOne
	private MeasurementLevel measurementLevel;*/
	
	@JsonIgnore
	@JoinColumn(name="id_measurement_plan_line", referencedColumnName = "id_measurement_plan_line")
	@ManyToOne
	private MeasurementPlanLine measurementPlanLine;	
	
	@OneToMany()
    @JoinColumn(name="id_results_per_card") 
	private List<Measurement> measurements;
	
	private Float average;
	private Float percentage;
	private Integer totalStudents;	
	private boolean active=true;
}
