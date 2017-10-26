/**
 * 
 */
/**
 * @author yy263
 *
 */
package springMVC.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springMVC.dao.DepartmentDao;
import springMVC.dao.EmployeeDao;
import springMVC.entities.Employee;

@Controller
public class EmployeeHandlers {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping("/emps")
	public String list(Map<String , Object> empsMap) {
		empsMap.put("employees",employeeDao.getAll());
		return "list";
	}
	
	@RequestMapping(value="/emp" ,method=RequestMethod.POST)
	public String save(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="emp",method=RequestMethod.GET)
	public String input(Map<String , Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
}