/**
 * This program test creating a new user
 * @author Mason
 *
 */
public class UserDriver {
	/**
	 * 
	 * @param args This is the main method
	 */
	public static void main(String[] args) {
		
		User [] user = new User[10];
		
		user[0] = new User("Mason", "Nousain", "nousain@vccs.com", "nousain24", "1", "1", "Student");
	

		int i=0;
		while(i<user.length) {
			System.out.println(user[i]);
			i++;
		}
	
	
	}
	

}
