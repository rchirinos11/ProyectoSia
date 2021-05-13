package pe.edu.pucp.sia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.repository.IndicatorRepository;
import pe.edu.pucp.sia.service.IndicatorService;

@Service
public class IndicatorServiceImpl implements IndicatorService {

    @Autowired
	private IndicatorRepository indicatorRepository;

    @Override
    public Iterable<Indicator> listAll() {
        return indicatorRepository.findAll();
    }

    @Override
    public String createIndicator(Indicator i) {
        String response = "";
		try {
			indicatorRepository.save(i);
			response = "Created"; 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }

    @Override
    public String updateIndicator(Indicator i) {
        String response = "";
		try {
			indicatorRepository.save(i);
			response = "Updated";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }

    @Override
    public String deleteIndicator(Integer id) {
        String response = "";
		try {
			indicatorRepository.deleteById(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }
    
}
