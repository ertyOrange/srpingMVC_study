package employee_crud_converter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.IOP.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@ResponseBody
	@RequestMapping(value="/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body){
		System.out.println(body);
		return "hellworld"+new Date();
	}
	
	@RequestMapping(value="/testtestResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
		byte[] body=null;
		InputStream in=session.getServletContext().getResourceAsStream("/files/test.sql");
		body=new byte[in.available()];
		in.read(body);
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=test.sql");
		ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers,HttpStatus.OK);
		return response;
	}
	
	
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	} 

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	
}
