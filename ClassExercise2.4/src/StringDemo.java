
public class StringDemo {

	public static void main(String[] args) {
		char letter;
		boolean a;
		String b;
		String c;
		boolean d;
		int e;
		int f;
		String g;
		String h;
		String i;
		String j;
		String k; 
		
	
		String firstName  = new String("Mason");
		String firstName2 = new	String("mason");
		
		
		//1. returns character at index
		letter = firstName.charAt(3);
		System.out.println("1. " + letter);
		
		//2. returns new string with this string concatenated
		c = firstName.concat(" rocks");
		System.out.println("2. " + c);
		
		//3. compares the two names, returns true or false
		d = firstName.equals(firstName2);
		System.out.println("3. " + d);
		
		//4. compares the two names but ignores case, returns true or false 
		a = firstName.equalsIgnoreCase(firstName2);
		System.out.println("4. " + a);
		
		//5. returns the index of the first occurrence of the substring 
		e = firstName.indexOf("a");
		System.out.println("5. " + e);
		
		//6. returns the index of the last occurrence of the substring
		f = firstName.lastIndexOf("n");
		System.out.println("6. " + f);
		
		//7. converts string to lower case
		g = firstName.toLowerCase();
		System.out.println("7. " + g);
		
		//8. converts string to upper case
		h = firstName.toUpperCase();
		System.out.println("8. " + h);
		
		//9. returns a new string with the oldchar replaced with newchar 
		i = firstName.replace('a', 'o');
		System.out.println("9. "  + i);
		
		//10. returns a new string having the same characters as the substring that begins at that index to the end
		j = firstName.substring(3);
		System.out.println("10. " + j);
		
		//11. returns a new string having the same characters as the substring that begins at (index start) and ends at (index end) 
		k = firstName.substring(1, 3);
		System.out.println("11. " + k);
		
		//12. returns new string with whitespace removed
		b = firstName.trim();
		System.out.println("12. " + b);
	}

}
