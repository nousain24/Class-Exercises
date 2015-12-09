
public class Car {
	private String color;
	private int horsepower;
	private int engineSize;
	
	public Car() {
		this.color = "";
		this.horsepower = 0;
		this.engineSize = 0;
		
	}
	
	public Car(String color, int horsepower, int engineSize) {
		this.color = color;
		this.horsepower = horsepower;
		this.engineSize = engineSize;
		
	}
	
	public void setNewHorsepower(){
		//local variable
		int newHorsepower;
		newHorsepower = this.horsepower*2;
		this.horsepower = newHorsepower;
		
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getHorsepower() {
		return this.horsepower;
	}
	
	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
	
	public int getEngineSize() {
		return engineSize;
	}
	
	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}
	
	public String toString() {
		return "Car color is " + this.color + "." + "\nHorsepower is " + this.horsepower + "." + "\nEngine size is " + this.engineSize + ".";
		
	}
}
