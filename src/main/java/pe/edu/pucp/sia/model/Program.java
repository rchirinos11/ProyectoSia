package pe.edu.pucp.sia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Program {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_program")
    private Integer id;
    private String name;
    private Boolean active;

    @ManyToOne
    private ModelStudentResult modelStudentResult;
}
