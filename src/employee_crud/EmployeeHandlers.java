/**
 * 
 */
/**
 * @author yy263
 *
 */
package employee_crud;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeHandlers {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false)Integer id ,Map<String, Object> map){ 
		if(id!=null){
			map.put("employee", employeeDao.get(id));
		}
	}
	
	@RequestMapping(value="/emps")
	public String list(Map<String , Object> empsMap) {
		empsMap.put("employees",employeeDao.getAll());
		return "Employee_crud/list";
	}
	
	@RequestMapping(value="/emp" ,method=RequestMethod.POST)
	public String save(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}" ,method=RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String , Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "Employee_crud/input";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String input(@PathVariable(value = "id") Integer id,Map<String , Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", employeeDao.get(id));
		return "Employee_crud/input";
	}
	
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
}