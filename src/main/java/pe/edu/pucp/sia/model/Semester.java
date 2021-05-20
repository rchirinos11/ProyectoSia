package pe.edu.pucp.sia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Where(clause = "active=true")
@Entity @Getter @Setter
public class Semester {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_semester")
	private Integer id;
	private Integer year;
	private Integer number;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	private boolean current;
	private boolean active=true;
}
