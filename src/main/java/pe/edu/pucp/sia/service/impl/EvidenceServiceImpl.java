package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Evidence;
import pe.edu.pucp.sia.repository.EvidenceRepository;
import pe.edu.pucp.sia.service.EvidenceService;

@Service
public class EvidenceServiceImpl implements EvidenceService{
	
	@Autowired
	private EvidenceRepository evidenceRepository;
	
	@Override
	public Iterable<Evidence> listAll() {
		return evidenceRepository.findAll();
	}

	@Override
	public int createEvidence(Evidence e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEvidence(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEvidence(Evidence e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
