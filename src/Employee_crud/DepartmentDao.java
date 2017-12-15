package Employee_crud;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public class DepartmentDao {
	private static Map<Integer,Department> departments=null;
	
	static {
		departments= new HashMap<Integer, Department>();
		departments.put(1,new Department(1,"科技"));
		departments.put(2,new Department(2,"技术"));
		departments.put(3,new Department(3,"质量"));
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartmentById(Integer id){
		return departments.get(id);
	}
}

