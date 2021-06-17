package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Evidence;
import pe.edu.pucp.sia.response.ApiResponse;

public interface EvidenceService {
    public ApiResponse listAll();
	public ApiResponse createEvidence(Evidence e);
	public ApiResponse deleteEvidence(Integer id);
	public ApiResponse updateEvidence(Evidence e);    
}
