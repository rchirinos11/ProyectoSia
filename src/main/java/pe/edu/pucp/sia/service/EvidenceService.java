package pe.edu.pucp.sia.service;

import pe.edu.pucp.sia.model.Evidence;

public class EvidenceService {
    public Iterable<Evidence> listAll();
	public int createEvidence(Evidence e);
	public int deleteEvidence(Integer id);
	public int updateEvidence(Evidence e);    
}
