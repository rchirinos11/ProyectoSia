package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ModelStudentResult;

public interface ModelStudentResultService {
    public Iterable<ModelStudentResult>  listAll();
	public String createModelStudentResult(ModelStudentResult m);
	public String updateModelStudentResult(ModelStudentResult m);
	public String deleteModelStudentResult(Integer id);
}
