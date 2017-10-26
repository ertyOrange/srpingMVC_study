/**
 * 
 */
/**
 * @author yy263
 *
 */
package springMV.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import springMV.dao.EmployeeDao;

@Controller
public class EmployeeHandlers {

	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping("/emps")
	public String list(Map<String , Object> empsMap) {
		empsMap.put("employees",employeeDao.getAll());
		return "test";
	}
}