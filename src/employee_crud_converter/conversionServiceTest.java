package employee_crud_converter;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import employee_crud.Employee;
import employee_crud.EmployeeDao;

@Controller
public class conversionServiceTest {
	@Autowired
	private EmployeeDao  employeeDao;
	
	@RequestMapping(value="/testConversionserviceConnerter")
	public String   testConverter(@RequestParam("employee") Employee employee){
		
		
		System.out.println("save:"+employee);
		employeeDao.save(employee);
		
		return "redirect:/emps";
	}
	
	@ResponseBody
	@RequestMapping(value="/testJson")
	public Collection<Employee> testJson(){
	return employeeDao.getAll();
	}
	
	
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	
}
