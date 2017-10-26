package springMVC.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import springMVC.entities.Department;
@Repository
public class DepartmentDao {
	private static Map<Integer,Department> departments=null;
	
	static {
		departments= new HashMap<Integer, Department>();
		departments.put(1,new Department(1,"aa"));
		departments.put(2,new Department(2,"bb"));
		departments.put(3,new Department(1,"cc"));
		departments.put(4,new Department(2,"dd"));
		departments.put(5,new Department(1,"ee"));
		
	}
	
	public Collection<Department> getDepartments(){
		return departments.values();
	}
	
	public Department getDepartmentById(Integer id){
		return departments.get(id);
	}
}

