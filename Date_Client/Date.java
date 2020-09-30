/*
 * Rodas T. Gebreslassie
 * 
 * Date.java
 * 
 * CSC 142
 * 
 * 3 / 16 / 2018
 * 
 * The class Date.java serve as a blue print to create objects in the program DateCleint.java.
 * 
 */
public class Date {
	int dateyear;
	int datemonth;
	int dateday;
	
	//Constructor to create new Date object once the user enter year, month and day.
	public Date(int year, int month, int day) {
		dateyear = year;
		datemonth = month;
		dateday = day;
		
		
	}
	
	//Default constructor to create a date object with date (1753, 1, 1).
	public Date() {
		dateyear = 1753;
		datemonth = 1;
		dateday = 1;
	}
	
	// Accessor method to return this Date object’s year.
	public int getYear() {
		return dateyear;
	}
	
	
	//Accessor method to return this Date object’s month.
	public int getMonth() {
		return datemonth;
	}
	
	
	//Accessor method to return this Date object’s day.
	public int getDay() {
		return dateday;
	}
	
	
	//Accessor method to return String of this Date object’s field in form Year/Month/Day.
	public String toString() {
		return(dateyear + "/" + datemonth + "/" + dateday);
	}
	
	
	//accessor method to return true if this Date object equals otherDate object
	public boolean equals(Date otherDate) {
		boolean equals = false;
		
		if(otherDate.getYear() == dateyear && otherDate.getMonth()== datemonth && otherDate.getDay() == dateday) {
			equals = true;
			
		}
		
		return equals;
		
	}
	
	
	//accessor method to return true if this Date object’s year field is leap year
	public Boolean isLeapYear() {
		boolean leapyear = false;
		if(dateyear % 4 == 0) {
			leapyear = true;
			if(dateyear % 100 == 0) {
				leapyear = false;
				if(dateyear % 400== 0) {
					leapyear = true;
				}
			}
		}
		
		else {
			leapyear = false;
		}
		
		return leapyear;
	}
	
	
	//mutator method that advances this Date object’s fields to represent the next date
	public void nextDay() {
		int[] daysinmonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(this.isLeapYear() == true) {
			daysinmonth[1] = 29;
		}
		
		int a = daysinmonth[datemonth - 1];
		
		if(dateday == a) {
			if(datemonth == 12) {
				dateday = 1;
				datemonth = 1;
				dateyear = dateyear + 1;
				
				
			}
			else {
				dateday = 1;
				datemonth = datemonth + 1;
			}
		}
		
		else {
			dateday = dateday + 1;
		}
		
	}
	
	
	//mutator method that advances this Date object’s fields to the
	//endDate object’s fields and returns
	//the number of days between the two dates.
	public int advanceTo(Date endDate) {
		int sum = 0;
		while(this.equals(endDate) != true) {
			nextDay();
			sum = sum + 1;
			
		}
		
		
		return sum;
	}
	
	
	//accessor method that returns a string giving the day of
	//the week this Date object’s date falls on
	//(Sunday thru Saturday).
	public String getDayOfWeek() {
		String[] daysInWeek = {"Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday", "Sunday"};
		Date monday = new Date(1753, 1, 1);
		int dayDiffrence = monday.advanceTo(this);
		int numberInWeek = dayDiffrence % 7;
		
		return(daysInWeek[numberInWeek]);
	}
} 
