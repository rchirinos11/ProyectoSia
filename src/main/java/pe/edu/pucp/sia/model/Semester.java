package pe.edu.pucp.sia.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Semester {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer year;
	private Integer number;
	private Date startDate;
	private Date endDate;
}