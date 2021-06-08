package pe.edu.pucp.sia;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.MeasurementPlanLine;
import pe.edu.pucp.sia.model.Section;
import pe.edu.pucp.sia.service.MeasurementPlanLineService;
import pe.edu.pucp.sia.service.impl.MeasurementPlanLineServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MeasurementPlanLineTester {
	@Autowired
	MeasurementPlanLineService service = new MeasurementPlanLineServiceImpl();
	
	@Test
	@Order(1)
	public void insertMeasurementPlanLine() {
		MeasurementPlanLine mpl = new MeasurementPlanLine();
		mpl.setEvaluatoryActivity("Actividad");
		mpl.setSampleStudents(6);
		mpl.setSections(null);
		
		Integer id = service.createMeasurementPlanLine(mpl);
		Iterable<MeasurementPlanLine> list = service.listAll();
		mpl= list.iterator().next();
		assertThat(id==mpl.getId());
		assertEquals(6, mpl.getSampleStudents());
	}
	
	@Test
	@Order(2)
	public void updateMeasurementPlanLine() {
		Iterable<MeasurementPlanLine> list = service.listAll();
		MeasurementPlanLine mpl = list.iterator().next();
		mpl.setSampleStudents(13);
		mpl.setSections(null);
		service.updateMeasurementPlanLine(mpl);
		
		list = service.listAll();
		assertEquals(13, mpl.getSampleStudents());
		
	}
	
	@Test
	@Order(3)
	public void deleteMeasurementPlanLine() {
		Iterable<MeasurementPlanLine> list = service.listAll();
		MeasurementPlanLine mpl = list.iterator().next();
		
		service.deleteMeasurementPlanLine(mpl.getId());
		list = service.listAll();
		assertThat(list).isEmpty();
	}
}
