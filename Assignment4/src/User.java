/**
 * This program creates the get and set methods for creating a new user
 * @author Mason
 *
 */
public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String confirmPassword;
	private String accountType;
	
	//constructor
	public User() {
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.username = "";
		this.password = "";
		this.confirmPassword = "";
		this.accountType = "";
	}
	// Overloaded constructor
	public User(String firstName, String lastName, String email, String username, String password, String confirmPassword, String accountCombo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.accountType = accountType;
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastname() {
		return this.lastName;
	}
	
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
		
	}
	
	public String getPassword() {
		return this.password;
		
	}
	
	public void setPassword(String password) {
		this.password = password;
		
	}
	
	public String getConfirmPassword() {
		return this.confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getAccountType() {
		return this.accountType;
		
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String toString() {
		return "First name is : " + this.firstName + "\nLast name is : " + this.lastName + "\nEmail is : " + this.email + "\nUsername is : " + this.username
				+ "\nPassword is : " + this.password + "\nConfirm password is : " + this.confirmPassword + "\nAccount type is : " + this.accountType + "\n";
	}
	
}
