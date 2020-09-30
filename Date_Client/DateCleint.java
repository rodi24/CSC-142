/*
 * Rodas T. Gebreslassie
 *  
 *  DateCleint.java
 *  
 *  CSC 142
 *  
 *  3 / 16 / 2018
 *  
 *   This program use Date.java class to create a date object after 
 *   the user enter todays's date and birthday in the form (month day year), 
 *   it will then output age in days and the day of a week.
 */
import java.util.*;
public class DateCleint {

	public static void main(String[] args) {
		System.out.println("This program callculate age in days ");
		System.out.println("and output the day of a week.");
		System.out.println("");
		System.out.print("Please enter today's Date (month day year): ");
		
		
		Date today = getDate();
		
		
		System.out.print("Please enter your birthday(month day year): ");
		
		
		Date birthday = getDate();
		
		printReults(today, birthday);
		
			
			
		}
		

	//The method getInput will accept string input from the user and then 
	//returns an array.
	public static String[] getInput() {
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		String[] a = input.split("\\s+");
		return a;
	}
	
	// The method getDate() will call the method getInput() to get the date in the form of an array
	// it will then assign individual elements of the array to month day and year respectively,
	//which will be used to create a date object.
	public static Date getDate() {
		String[] todaysdate = getInput();
		int tmonth = Integer.parseInt(todaysdate[0]);
		int tday = Integer.parseInt(todaysdate[1]);
		int tyear = Integer.parseInt(todaysdate[2]);
		Date date = new Date(tyear, tmonth , tday);
		
		return date;
		
	}
	
	//The method printResults() accept two parameters today's date and birthday
	//and print age in days and day of a week.
	public static void printReults(Date today, Date birthday) {
		System.out.println();
		System.out.println("You were born on " + birthday.toString() + ", which was " + birthday.getDayOfWeek() + ".");
		System.out.println("You are " + birthday.advanceTo(today) + " days old.");
		
	
		
	}
	
	
}
