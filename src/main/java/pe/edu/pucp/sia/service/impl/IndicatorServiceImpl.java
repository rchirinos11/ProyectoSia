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
	public Integer createIndicator(Indicator i) {
		Integer response = 0;
		try {
			response = indicatorRepository.save(i).getId(); 
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}

    @Override
    public Integer updateIndicator(Indicator i) {
        Integer response = 0;
		try {
			response = indicatorRepository.save(i).getId();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }

    @Override
    public String deleteIndicator(Integer id) {
        String response = "";
		try {
			indicatorRepository.deleteIndicator(id);
			response = "Deleted";
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return response;
    }
    
	@Override
	public Iterable<Indicator> listBySpecialty(Integer id) {
		Iterable<Indicator> lista = indicatorRepository.findBySpecialtyId(id);
		for (Indicator indicator : lista) {
			indicator.s;
		}
		return lista;
	}

}
