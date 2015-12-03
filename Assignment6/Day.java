/**
 * This is the class for the day of the week
 * @author Mason Nousain
 * 
 */
public class Day {
	private String day;
	private String [] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	public Day(String day){
		super();
		this.day = day;
		
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	public String calculateDay(int numOfDays) {
		String message = "";
		int dayIndex = getDayIndex(this.day);
		if(dayIndex!=-1){
			message = days[(dayIndex+numOfDays)%7];
			
		} else {
			message = "Invalid day!";
		}
		return message;
	}
	public String nextDay() {
		String message = "";
		int dayIndex = getDayIndex(this.day);
		if(dayIndex!=-1){
			message = days[(dayIndex+1)%7];
			
		} else {
			message = "Invalid day!";
		}
		return message;
	}
	public String previousDay() {
		String message = "";
		int dayIndex = getDayIndex(this.day);
		if(dayIndex==0){
			message = days[7-Math.abs(dayIndex-1)];
	
		} else {
			message = days[dayIndex-1%7];
		}
		return message;
	}
	private int getDayIndex(String day) {
		for(int i=0; 1<days.length; i++){
			if(days[i]==this.day){
				return i;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Current day is " + this.day;
	}

}
