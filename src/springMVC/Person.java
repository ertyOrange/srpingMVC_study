package springMVC;

public class Person {
private String name;
private double age;
private Address address;


public Person() {
	super();
}
public Person(String name, double age) {
	super();
	this.name = name;
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getAge() {
	return age;
}
public void setAge(double age) {
	this.age = age;
}
//@Override
//public String toString() {
//	return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
//}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Person [name=" + name + ", age=" + age + "]";
}

}
