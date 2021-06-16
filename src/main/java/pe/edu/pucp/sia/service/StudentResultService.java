package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.model.dozers.StudentResultDozer;

public interface StudentResultService {
	public Iterable<StudentResult> listAll();
	public Iterable<StudentResult> listBySpecialty(Integer id);
	public Iterable<StudentResultDozer> listBySpecialtyPlusIndicator(Integer id);
	public Integer createStudentResult(StudentResult sr);
	public Integer updateStudentResult(StudentResult sr);
	public String deleteStudentResult(Integer id);
}
