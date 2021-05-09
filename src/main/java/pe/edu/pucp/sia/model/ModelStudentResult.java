package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class ModelStudentResult {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_model_student_result")
    private Integer idModelStudentResult;
    private String description;
    private boolean active;
}
