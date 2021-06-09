package pe.edu.pucp.sia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.Indicator;
import pe.edu.pucp.sia.model.LevelDetail;
import pe.edu.pucp.sia.model.Specialty;
import pe.edu.pucp.sia.model.StudentResult;
import pe.edu.pucp.sia.service.IndicatorService;
import pe.edu.pucp.sia.service.impl.IndicatorServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class IndicatorTester {
    @Autowired
	IndicatorService indicatorService = new IndicatorServiceImpl();
	
    @Test
    @Order(1)
    public void insertIndicatorAndReciveId(){
        //Crear Indicador
        Indicator indicator  = new Indicator();
        indicator.setCode("code");
        indicator.setDescription("descripcion");
        LevelDetail levelDetail = new LevelDetail();
        levelDetail.setDescription("description");  
        List<LevelDetail> listL = new List<>();

        listL.add(levelDetail);
        
        indicator.setLevelDetailList(null);
        //LLama al metodo crear Indicator y obtine el ID
        Integer id= indicatorService.createIndicator(indicator);
        //Lista los indicadores
        Iterable<Indicator> list = indicatorService.listAll();
        indicator = list.iterator().next();
        assertEquals("code", indicator.getCode());
        assertThat(id==indicator.getId());
    }
    @Test
    @Order(2)
    public void updateIndicator(){
        //Obtiene indicator agregado
        Iterable<Indicator> list = indicatorService.listAll();
        Indicator indicator = list.iterator().next();
        //Cambio de un parametro
        indicator.setCode("code2");
        indicatorService.updateIndicator(indicator);
        //Obtiene lista nueva actualizada
        list = indicatorService.listAll();
        assertEquals("code2",list.iterator().next().getCode());

    }

    @Test
    @Order(3)
    public void logicDeleteIndicator(){
        //Obtiene Indicator agregado
        Iterable<Indicator> list = indicatorService.listAll();
        Indicator indicator = list.iterator().next();
        //Delect logico
        indicator.setActive(false);
        indicatorService.updateIndicator(indicator);
        //Ontiene Lista nueva actualizada
        list = indicatorService.listAll();
        assertThat(list).isEmpty();

    }

    @Test
    @Order(4)
    public void listBySpeciality(){
        //crear Indicator
        Indicator indicator = new Indicator();
        indicator.setCode("code");
        Specialty specialty = new Specialty();
        specialty.setCode("code");
        specialty.setName("name");
        StudentResult studentResult = new StudentResult();
        studentResult.setDescription("description");
        studentResult.setSpecialty(specialty);
        //Llama al metodo crear Indicator y obtiene el ID
        Integer id = indicatorService.createIndicator(indicator);

        //Obtiene Indicator agregado
        Iterable<Indicator> list = indicatorService.listBySpecialty(id);
        boolean bol = false;
        for (Indicator i : list) {
			//Delete logico
			if(i.getId()==id)bol = true;
		}
        assertEquals(true,bol);
        terminaTest();
    }

    private void terminaTest() {
		Iterable<Indicator> listf = indicatorService.listAll();
		for (Indicator f : listf) {
			//Delete logico
			f.setActive(false);
			indicatorService.updateIndicator(f);
		}
    }
}
