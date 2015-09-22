import java.util.Scanner;
public class Numbers {
public static void main(String[]args){
	int num1=0,num2=0,num3=0,num4=0,num5=0;
	int sum=0,average=0;
		System.out.println("Enter 5 numbers seperated by space ");
		Scanner keyboard = new Scanner(System.in);
		
		num1 = keyboard.nextInt();
		num2 = keyboard.nextInt();
		num3 = keyboard.nextInt();
		num4 = keyboard.nextInt();
		num5 = keyboard.nextInt();

		sum = num1+num2+num3+num4+num5;
		average = ((num1+num2+num3+num4+num5)/5);

		System.out.println("The sum is " + sum + ".");
		System.out.println("The average is " + average + ".");
		

}


}

