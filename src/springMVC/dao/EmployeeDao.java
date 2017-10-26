package springMVC.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springMVC.entities.Department;
import springMVC.entities.Employee;
@Repository
public class EmployeeDao {
	private static Map<Integer,Employee> employees=null;
	
	private static Integer initId=1000;
	@Autowired
	private DepartmentDao departmentDao;
	static {
		employees= new  HashMap<Integer, Employee>(); 
		employees.put(11, new Employee(111,"chen","email", "1",new Department(111,"科技")));
		employees.put(12, new Employee(112,"chen2","email2", "2",new Department(112,"人事")));
		employees.put(13, new Employee(113,"chen3","email3", "1",new Department(113,"建材")));
		employees.put(14, new Employee(114,"chen4","email4", "1",new Department(114,"教育")));
		employees.put(15, new Employee(115,"chen5","email5", "2",new Department(115,"质量")));
		employees.put(16, new Employee(116,"chen6","email6", "2",new Department(116,"技术")));
	}
	
	public Collection<Employee> getAll(){
		return  employees.values();
	}
	
	public void save (Employee employee){
		if(employee.getId()==null){
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartmentById(employee.getId()));
		employees.put(employee.getId(), employee);
		
	}
	
	
	public Employee get(Integer id){
		return employees.get(id);
	}
	public void delete(Integer id){
		employees.remove(id);
	}
}

