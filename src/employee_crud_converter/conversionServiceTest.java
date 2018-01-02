package employee_crud_converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	
}
