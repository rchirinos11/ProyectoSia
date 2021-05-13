package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.StudentResult;

public interface StudentResultService {
	public Iterable<StudentResult> listAll();
	public Iterable<StudentResult> listBySpecialty(Integer id);
	public Integer createStudentResult(StudentResult sr);
	public Integer updateStudentResult(StudentResult sr);
	public String deleteStudentResult(Integer id);
}
