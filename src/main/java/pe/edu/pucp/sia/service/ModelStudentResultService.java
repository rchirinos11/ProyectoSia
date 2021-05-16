package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ModelStudentResult;

public interface ModelStudentResultService {
    public Iterable<ModelStudentResult>  listAll();
	public Integer createModelStudentResult(ModelStudentResult m);
	public Integer updateModelStudentResult(ModelStudentResult m);
	public String deleteModelStudentResult(Integer id);
}
