
public class Car {
	private  String color;
	private  int horsepower;
	private  int engineSize;
	private static int count;
	
	public Car() {
		this.color = "";
		this.horsepower = 0;
		this.engineSize = 0;
		Car.count++;
	}
	
	public Car(String color, int horsepower, int engineSize) {
		this.color = color;
		this.horsepower = horsepower;
		this.engineSize = engineSize;
		Car.count++;
	}
	
	public void setNewHorsepower(){
		//local variable
		int newHorsepower;
		newHorsepower = this.horsepower;
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
	
	public static int getCount() {
		return count;
	}
	
	public boolean equals(Car otherObject) {
		return (this.color == otherObject.color)&&(this.horsepower == otherObject.horsepower)&&
				(this.engineSize == otherObject.engineSize);
	}

	public String toString() {
		return "Car color is " + this.color + "." + "\nHorsepower is " + this.horsepower + "." + "\nEngine size is " + this.engineSize + ".";
		
	}
}
