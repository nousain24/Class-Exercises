
public class LoopThree {

	public static void main(String[] args) {
		for (int a = 1; a < 10; a += 2) {
			for (int b = 0; b < 9 - a / 2; b++)
				System.out.print(" ");

			for (int b = 0; b < a; b++)
				System.out.print("*");

			System.out.print("\n");
		}

		for (int a = 7; a > 0; a -= 2) {
			for (int b = 0; b < 9 - a / 2; b++)
				System.out.print(" ");

			for (int b = 0; b < a; b++)
				System.out.print("*");

			System.out.print("\n");
		}
		
	}

}
