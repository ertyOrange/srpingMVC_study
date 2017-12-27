package employee_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class conversionServiceTest {
	@Autowired
	private EmployeeDao  employeeDao;
	
	@RequestMapping(value="/testConversionserviceConnerter")
	public String   testConverter(@RequestParam("employee") Employee employee){
		
		
		System.out.println("save:"+employee);
		employeeDao.save(employee);
		
		return "emps";
	}
}
