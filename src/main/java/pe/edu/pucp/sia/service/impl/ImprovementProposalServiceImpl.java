package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.ImprovementProposal;
import pe.edu.pucp.sia.repository.ImprovementProposalRepository;
import pe.edu.pucp.sia.service.ImprovementProposalService;

@Service
public class ImprovementProposalServiceImpl implements ImprovementProposalService{
	@Autowired
	private ImprovementProposalRepository improvementProposalRepository;
	
	@Override
	public Iterable<ImprovementProposal> listAll() {
		 return improvementProposalRepository.findAll();
	}

	@Override
	public String createImprovementProposal(ImprovementProposal i) {
		String response = "";
		try {
			improvementProposalRepository.save(i);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String updateImprovementProposal(ImprovementProposal i) {
		String response = "";
		try {
			improvementProposalRepository.save(i);
			response = "Updated";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

	@Override
	public String deleteImprovementProposal(Integer id) {
		String response = "";
		try {
			improvementProposalRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

}
