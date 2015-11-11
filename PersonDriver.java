import java.util.Scanner;

public class PersonDriver {

	public static void main(String[] args) {
		String name1,name2;
		int age1,age2;
		
		Person person = new Person();
		Person person2 = new Person();
		

		 //keyboard is an instance variable
		Scanner keyboard = new Scanner(System.in);
		
		//person1
		System.out.println("Please enter the name of person one");
			name1 = keyboard.next();
			person.setName(name1);
		System.out.println("Please enter the age of " + name1);
			age1 = keyboard.nextInt();
			person.setAge(age1);
		//person2 
		System.out.println("Please enter name of person two");
			name2 = keyboard.next();
			person2.setName(name2);
		System.out.println("Please enter the age of " + name2);
			age2 = keyboard.nextInt();
			person2.setAge(age2);
			
		System.out.println(person);
		System.out.println(person2);
		
		//1. same name and same age
		if (name1.equals(name2) && age1 == age2){
			System.out.println("\nThese two people have the same name and age. ");
		}
		//2. same name
		if(name1.equals(name2) && age1 != age2){
			System.out.println("\nThese two people have the same name. ");
		}
		//3. same age
		if(age1 == age2 && !name1.equals(name2)) {
			System.out.println("\nThese two people are the same age ");
		}
		//4. name1 is older than name2
		if(age1>age2){
			System.out.println("\n" + name1 + " is older than " + name2 + ".");
		}
		//5. name2 is older than name1
		if(age2>age1){
			System.out.println("\n" + name1 + " is younger than " + name2 + ".");
		}
	
	}

}
