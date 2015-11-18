//OOP(Object Oriented Programming)
//2 types of class
//1. Create class to use in another class. i.e. Class Person (use in another class)
//2. Drive class (has a main method) i.e. all the class
public class Person {
	//characteristics (attributes) variables
	//encapsulate the attributes by adding private modifiers
	private String name;
	private int age;
	
	//constructor: is a method that initialize the value of the attributes. Constructor has the name as class
	public Person() {
		this.name = "";
		this.age = 0;
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	//behaviors
	public String getName(){
		return name;
		
	}
	
	public void setName(String name){
		this.name = name;
		
	}
	public int getAge() {
		return this.age;
		
	}
	public void setAge(int age) {
		this.age = age;
		
	}
	
	public String toString() {
		return "\nPerson name is : " + this.name + "\nHis/Her age is : " + this.age;
	}
}
