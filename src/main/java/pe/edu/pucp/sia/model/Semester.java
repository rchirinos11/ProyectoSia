package pe.edu.pucp.sia.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Semester {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_semester")
	private Integer id;
	private Integer year;
	private Integer number;
	private LocalDate startDate;
	private LocalDate endDate;
	private Boolean current;
}
