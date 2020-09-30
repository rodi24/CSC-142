/*
 * Rodas T. Gebreslassie
 * 
 * isbna.java
 * 
 * 2 / 18 / 18
 * 
 * This program check if a given ISBN number is Valid or invalid by evaluating different
 * conditions. If a given number is invalid the program will display error messages.
 */
import java.util.*;

public class isbna {
	public static void main(String[] args) {
		boolean error = false;
		System.out.println("This program validates user-entered ISBN’s.");
		System.out.println("ISBN input shouldn’t contain a space or a small x character.");
		System.out.println("  * Press Q to terminate the program.");
		System.out.println();
		String prompt = "Please enter ISBN digit: ";
		String input = getInput(prompt);             // Call the function getInput to get input from the user.
		int dashNumber = 0;
		
		while(Character.toLowerCase(input.charAt(0)) != 'q') {    // If the user input is not q 
			while(error == false) {                               // or Q the while loop will continue to run.
				dashNumber = countDash(input);
				error = compareDashes(dashNumber);
				if(error == false) {
					error = tooCloseDashes(input);
				}
				if(error == false) {
					error = sequentialDashes(input);
					//error = tooCloseDashes(input);
					if(error == false) {
						error = evsb(input);       // beginning or ending dash.
					}
				}
				
				String modifiedInput = replaceDash(input);
				int numberOfDigits = modifiedInput.length();
				if(error == false) {
					error = countDigits(modifiedInput);
				}
				String input0 = checkX(modifiedInput);
				
				if(numberOfDigits == 10 && error == false) {
					
					error = baddigit(modifiedInput);
					
				}
				if(numberOfDigits == 10 && error == false) {
					error = checksum(modifiedInput, input0, numberOfDigits);
				}
					
				if(error == false) {
					System.out.println("Valid ISBN");
				}
				
				error = true;
			}
			
			
			
			
			
			System.out.println();
			prompt = "Please enter ISBN digit: ";
			input = getInput(prompt);
			error = false;
			
			
		}
		
		
		
	}
	
	// The method getInput() will accept user-entered input. 
	public static String getInput(String prompt) {
		Scanner console = new Scanner(System.in);
		System.out.print(prompt);
		String input = console.next();
		
		if(Character.toLowerCase(input.charAt(0)) == 'q') {
			System.out.println("Thank you for using this program.");
		}
		
		return input;
		
	}
	
	//The method countDash() will count the number of dashes in an ISBN number, if any.
	public static int countDash(String input) {
		char dash = '-';
		int dashNum = 0;
		
		for(int i = 0; i < input.length(); i++) {                 // For loop is used to count the number of dashes.
			if(input.charAt(i) == dash) {                         
				dashNum = dashNum + 1;
				
			}
			
		}
		return dashNum;
	}
	
	// The method compareDahses will evaluate if the number of dashes in a given ISBN number
	// makes the ISBN valid or invalid.
	//This method accept a parameter that is returned from the previous method, countDash().
	public static boolean compareDashes(int dashNum) {                 
		boolean error = false;                                 
		if(dashNum == 0 || dashNum == 3) {                 
			error = false;
		}else if(dashNum < 3) {
			System.out.println("Invalid ISBN");
			System.out.println("ERROR  -  Not enough dashes.");
			error = true;
		}else if(dashNum > 3) {
			System.out.println("Invalid ISBN");
			System.out.println("ERROR  -  Too many dashes.");
			error = true;
		}
		
		return error;
	}
	
	// The method sequentialDashes() check if their are sequential dashes in a given ISBN number.
	public static boolean sequentialDashes(String input) {
		boolean error = false;
		char dash = '-';
		for(int i = 0; i < input.length() - 1; i++) {
			if(input.charAt(i) == dash && input.charAt(i + 1) == dash) {
				
				error = true;
			}
		}
		
		if(error == true) {
			System.out.println("Invalid ISBN");
			System.out.println("ERROR  -  Sequential dashes.");
			
		}
		
		return error;
	}
	
	// The method tooCloseDashes() make sure if the dashes in a given ISBN are placed at least two characters apart.
	public static boolean tooCloseDashes(String input) {
		boolean error = false;
	
		for(int i = 0; i < input.length() - 2; i++) {                                    // For loop is used to rum from 
			if(input.charAt(i) == input.charAt(i + 2) && input.charAt(i) == '-') {       // 0 to input.length()-2 times.
				System.out.println("Invalid ISBN");                                      //input.length() - 2 eliminate 
				System.out.println("ERROR  -  Dash after one character.");               //index out of range error.
				error = true;
				
			}
		}
		
		return error;
		
	}
	
	// The method evsb() look for beginning or ending dash.
	public static boolean evsb(String input) {
		boolean error = false;
		char dash = '-';
		if(input.charAt(0) == dash) {
			System.out.println("Invalid ISBN");
			System.out.println("ERROR  -  Beginning dash.");
			error = true;
			
			
		}
		
		if(input.charAt(input.length() - 1) == dash) {
			System.out.println("Invalid ISBN");
			System.out.println("ERROR  -  Ending dash.");
			error = true;
			
		}
		
		return error;
	}
	
	// The method replaceDash() replace all the dashes in a given ISBN, if any.
	public static String replaceDash(String input) {
		input = input.replaceAll("-","" );
		return input;
		
	}
	
	//The method countDigits count the number of digits in a given ISBN.
	//The number of digits are counted once the previous method replaceDash()
	//return a string of numbers without dashes.
	public static boolean countDigits(String input) {
		boolean error = false;
		int numberOfDigits = input.length();
		if(numberOfDigits == 10) {
			error = false;
			
		}else if(numberOfDigits < 10) {
			System.out.println("Invalid ISBN");
			System.out.println("ERROR  -  Too few digits.");
			error = true;
		}else {
			System.out.println("Invalid ISBN");
			System.out.println("ERROR  -  Too many digits.");
			error = true;
		}
		
			
		return error;
		
	} 
	
	
	//The method checkX() will check if their is an X in a given ISBN number 
	//and replace it with 0 for to make it suitable further calculation.
	//This method returns the string of numbers once the last digit or x is changed to 0.
	public static String checkX(String input) {
		int num = input.length();
		if(num == 10) {
			input = input.substring(0, 9) + '0';
		}
		else {
			for(int i = num; i < 10; i++) {
				input = input.substring(0, i) + '0';
			}
			
		}
		
		return input;
	}
	
	//The method baddigit() will check if a given ISBN number have letters other than X.
	public static boolean baddigit(String input) {
		boolean error = false;
		for(int i = 0; i <= 8; i++) {
			if(Character.isDigit(input.charAt(i)) == false) {
				System.out.println("Invalid ISBN");
				System.out.println("ERROR  -  bad digit.");
				error = true;
				
			}
		}
		
		return error;
	}
	//The method checksum() will evaluate a checksum of ISBN numbers.
	public static boolean checksum(String modifiedinput, String input0, int num ) {
		boolean error = false;
		
		int isbn = Integer.parseInt(input0);                     // Type conversion string to int.
		int n1 = isbn / 1000000000;                              // Isbn / 1000000000 will give us the first
		int remaining = isbn % 1000000000;                       // digit.
		
		int n2 = remaining/ 100000000;
		remaining = remaining % 100000000;
		
		int n3 = remaining / 10000000;
		remaining = remaining % 10000000;
		
		int n4 = remaining / 1000000;
		remaining = remaining % 1000000;
		
		int n5 = remaining / 100000;
		remaining = remaining % 100000;
		
		int n6 = remaining / 10000;
		remaining = remaining % 10000;
		
		int n7 = remaining / 1000;
		remaining = remaining % 1000;
		
		
		
		int n8 = remaining / 100;
		remaining = remaining % 100;
		
		int n9 = remaining / 10;
		remaining = remaining % 10;
		
		int n10 = remaining;
		
		int multiple = n1 * 1 + n2 * 2 + n3 * 3 + n4 * 4 + n5 * 5 + n6 * 6 + n7 * 7 + n8 * 8 + n9 * 9;
		
		int mod = multiple % 11;
		String modString = Integer.toString(mod);
		
		
		if(mod == 10 && modifiedinput.charAt(9) == 'X') {
			
			error = false;
		}
		else if ( modifiedinput.charAt(9) == modString.charAt(0)) {
			
			error = false;
			
		}else {
			System.out.println("Invalid ISBN");
			System.out.println("ERROR  -  Wrong check sum.");
			error = true;
		}
		
		return error;
		
		
	}
	
	
	
	
		
		
		

}

