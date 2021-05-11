package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.StudentResult;

public interface StudentResultService {
	public Iterable<StudentResult> listAll();
	public String createStudentResult(StudentResult sr);
	public String updateStudentResult(StudentResult sr);
	public String deleteStudentResult(Integer id);
}
