
public class LoopDemoTwo {

	public static void main(String[] args) {
		int i = 1;
		int limit = 100;
		do{
			if (i % 2 == 0){
			    System.out.println(i);
			  }
			i++;
		}while(i<=limit);
	}
}