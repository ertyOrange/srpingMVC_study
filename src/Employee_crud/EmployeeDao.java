package Employee_crud;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmployeeDao {
	private static Map<Integer,Employee> employees=null;
	
	private static Integer initId=0;
	@Autowired
	private DepartmentDao departmentDao;
	static {
		employees= new  HashMap<Integer, Employee>(); 
		employees.put(1, new Employee(1,"chen","email", "1",new Department(1,"科技")));
		employees.put(2, new Employee(2,"chen2","email2", "2",new Department(3,"质量")));
		employees.put(3, new Employee(3,"chen3","email3", "1",new Department(1,"科技")));
		employees.put(4, new Employee(4,"chen4","email4", "1",new Department(2,"技术")));
		employees.put(5, new Employee(5,"chen5","email5", "2",new Department(3,"质量")));
		employees.put(6, new Employee(6,"chen6","email6", "2",new Department(2,"技术")));
	}
	
	public Collection<Employee> getAll(){
		return  employees.values();
	}
	
	public void save (Employee employee){
		if(employee.getId()==null){
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
		
	}
	
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	public void delete(Integer id){
		employees.remove(id);
	}
}

