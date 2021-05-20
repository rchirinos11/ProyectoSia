package pe.edu.pucp.sia;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.Faculty;
import pe.edu.pucp.sia.service.FacultyService;
import pe.edu.pucp.sia.service.impl.FacultyServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SiaApplicationTests {
	
	@Autowired
	FacultyService service = new FacultyServiceImpl();;
	
	@Test
	@Order(1)
	public void contextLoads() {
		Iterable<Faculty> list = service.listAll();
		assertThat(list).size().isEqualTo(0);
	}

	@Test
	@Order(2)
	public void tesfaf(){
		Faculty alex = new Faculty();
        alex.setName("bob");
        alex.setActive(true);
        service.createFaculty(alex);
		Iterable<Faculty> list = service.listAll();
		assertThat(list).size().isGreaterThan(0);
		}
}
