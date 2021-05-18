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
public class Program {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_program")
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name="id_model_student_result")
    private ModelStudentResult modelStudentResult;
}
