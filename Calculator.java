import javax.swing.JOptionPane;

public class Calculator {

	public static double getSum(double first, double second){
		return (first + second);
	}
	public static double getSum(double [] num){
		double sum = 0.0;
		for(int i=0;i<num.length; i++){
			sum+=num[i];
		}
		return(sum);		
	}
	public static double getAvg(double first, double second){
		return (first + second)/2.0;
	}
	public static double getAvg(double [] num){
		double sum = 0.0;
		for(int i=0;i<num.length; i++){
			sum+=num[i];
		}
		return(sum/num.length);		
	}
	public static double getProduct(double first, double second){
		return (first * second);
	}
	public static double getProduct(double [] num){
		double product = 1.0;
		for(int i=0; i<num.length; i++)
		{
			product*=num[i];
		}
		return (product);
	}
	public static int getFactorial(int[] fact){
		int factorial = 1;
		for(int i=1; i<=fact.length; i++)
		{
			factorial*=i;
		}
		return (factorial);
	}
	}