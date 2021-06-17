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

import lombok.Getter;
import lombok.Setter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class Indicator {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_indicator")
    private Integer id;
    private String description;
    private String code;

    @ManyToOne
	@JoinColumn(name="id_student_result")
	private StudentResult studentResult;

    @OneToMany()
    @JoinColumn(name="id_indicator") 
    private List<LevelDetail> levelDetails;


}

