
public class CalcDriver {

	public static void main(String[] args) {
		double [] num = new double [3];
		num[0] = 3.0;
		num[1] = 3.0;
		num[2] = 3.0;
		
		int [] fact = new int [3];
		fact[0]=1;
		fact[1]=2;
		fact[2]=3;
		
		System.out.println("The average is: " + Calculator.getAvg(num));
		System.out.println("The sum is: " + Calculator.getSum(num));
		System.out.println("The product is: " + Calculator.getProduct(num));
		System.out.println("The array factorial is: " + Calculator.getFactorial(fact));
	}

}
