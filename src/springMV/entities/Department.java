package springMV.entities;

public class Department {
	private Integer id;
	private String departmantName;

	public Department(Integer id, String departmantName) {
		super();
		this.id = id;
		this.departmantName = departmantName;
	}

	public Department() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmantName() {
		return departmantName;
	}

	public void setDepartmantName(String departmantName) {
		this.departmantName = departmantName;
	}

}
