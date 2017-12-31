package employee_crud_converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import employee_crud.Department;
import employee_crud.Employee;

@Component
public class EmployeeConverter implements Converter<String, Employee> {

	@Override
	public Employee convert(String arg0) {

		try {
			if (arg0 != null) {
				String[] arg0s = arg0.split("-");
				if (arg0s != null && arg0s.length == 4) {
					String lastName = arg0s[0];
					String email = arg0s[1];
					String gender = arg0s[2];

					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
					Date birth = dateFormat.parse(arg0s[3]);

					Department department = new Department(Integer.parseInt(arg0s[3]), "ц╩сп");
					Employee employee = new Employee(null, lastName, email, gender, birth, department);
					return employee;
				}
			} else {
				throw new converterException("your input is not legal");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
