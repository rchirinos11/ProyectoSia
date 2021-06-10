package pe.edu.pucp.sia;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.pucp.sia.model.Role;
import pe.edu.pucp.sia.model.Person;
import pe.edu.pucp.sia.service.RoleService;
import pe.edu.pucp.sia.service.impl.RoleServiceImpl;
import java.util.List;
import java.util.ArrayList;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class RoleTester {
    @Autowired
	RoleService service = new RoleServiceImpl();
	
	@Test
	@Order(1)
	public void insertRole() {
		Role role = new Role();
        List<Person> personList= new ArrayList<Person>();
        for(int i=0;i<2;i++){
            Person per=new Person();
            per.setId(i+1);
            per.setName("Person Name: "+ Integer.toString(i+1));
            personList.add(per);
        }
        //Sets
        role.setDescription("Example_Description");
        role.setPersonList(personList);
		
		//Create role and assert it is listed
		Integer id = service.createRole(role);
		Iterable<Role> list = service.listAll();
		role= list.iterator().next();
		assertThat(id==role.getId());
        assertThat("Example_Description" == role.getDescription());
        List<Person> personListB=role.getPersonList();
        for(int i=0;i<2;i++){
            assertThat((i+1)==personListB.get(i).getId());
            assertThat(("Person name "+ Integer.toString(i+1))==personListB.get(i).getName());
        }
	}
	
	@Test
	@Order(2)
	public void updateRole() {
		Iterable<Role> listRole = service.listAll();
        Role role=listRole.iterator().next();
		
        role.setDescription("Alt_description");
		List<Person> personList= new ArrayList<Person>();
        for(int i=0;i<2;i++){
            Person per=new Person();
            per.setId(i+2);
            per.setName("Person Alt. Name: "+ Integer.toString(i+2));
            personList.add(per);
        }
        role.setPersonList(personList);
		service.updateRole(role);
		
		listRole = service.listAll();
        role=listRole.iterator().next();
        assertEquals("Alt_Description", role.getDescription());
		List<Person> personListB=role.getPersonList();
        for(int i=0;i<2;i++){
            assertThat((i+2)==personListB.get(i).getId());
            assertThat(("Person Alt. Name: "+ Integer.toString(i+2))==personListB.get(i).getName());
        }
	}
	
	@Test
	@Order(3)
	public void deleteRole() {
		Iterable<Role> list = service.listAll();
        Role role=list.iterator().next();
		service.deleteRole(role.getId());
		list = service.listAll();
		assertThat(list).isEmpty();
	}
}
