package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.ModelStudentResult;
import pe.edu.pucp.sia.response.ApiResponse;

public interface ModelStudentResultService {
    public ApiResponse  listAll();
	public ApiResponse createModelStudentResult(ModelStudentResult m);
	public ApiResponse updateModelStudentResult(ModelStudentResult m);
	public ApiResponse deleteModelStudentResult(Integer id);
}
