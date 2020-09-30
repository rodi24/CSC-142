//SpaceNeedle.java

//Rodas T Gebreslassie

//This program print out a space Needle by utilizing 
//nested loop to print the image one character at a time.


public class SpaceNeedle {
	
	public static final int size = 4;
	
	
	public static void main(String[] args) {
		//Draw a Space Needle by using 3 static methods.
		
		
		upperSection();
		
		middleSection();
		
		lowerSection();
		
	}
	
	
	
	
	
    public static void upperSection() {
    	//The method <upperSection()> will call
    	//4 different static methods to draw the upper portion of the Space Needle.
    	
		needle();
		upperDome();
		quotationline();
		lowerdome();
		
	}
    
     
    
    
    
	public static void middleSection() {
		//The method <middleSection()> will call
		//2 static methods to draw the middle portion of the Space Needle 
		
		needle();
		
		strightsection();
		
	}
    
    
    
	
	public static void lowerSection() {
		//The method <lowerSection()>  
	    //print out the lower portion of the Space Needle by using 2 methods .
	    //The methods <upperDome()> and <quotationline()> 
		
		upperDome();
		
		quotationline();
		
	}
	
	
	
	

	public static void needle() {
		//The method  <needle()> draw the  <||> part of the Space Needle.
		
		
		
		for(int line = 1; line <= size; line ++) {
			
			for(int space = 1; space <= size * 3; space ++) {
				System.out.print(" ");
			}
			
			
			doublebar();
			
			System.out.println();
		}
	}
	
	public static void doublebar() {
		//The method <doublebar()> print <||> part of the Space Needle.
		
		for(int bar = 1; bar <= 2; bar++ ) {
			System.out.print("|");
		}
		
	}
	
	
	
	
	
	
	public static void upperDome() {
		//The method <upperDome()> draw the top half  of the dome.
		
		
		for(int line = 1; line <= size; line ++) {
			
			for(int space = 1; space <= (size * 3) - (3 * line); space++ ) {
				System.out.print(" ");
				
			}
			
			System.out.print("__/");
			
			
			for(int colon = 1; colon <= (3 * line) - 3; colon++) {
				System.out.print(":");
				
			}
			
	
			doublebar();
			
			for(int colon = 1; colon <= (3 * line) - 3; colon ++) {
				System.out.print(":");
			}
			
			System.out.print("\\__");
			System.out.println();
		}
	}
	
	
		
	public static void quotationline() {
		//The method <quotationline()> draw the <|""""""""""""""""""""""""|> part.
		
		bar();
		
		for(int quotation = 1; quotation <= size * 6; quotation++) {
			System.out.print("\"");
		}
		
		bar();
		
		System.out.println();
			
			
			
		}
		

	
	public static void bar() {
		//The method <bar()> print out a single bar.
		
		System.out.print("|");
		
	}
	

	

	public static void lowerdome() {
		//The method <lowerdome()> draw the lower half of the dome.
		for(int line = 1; line <= size; line++) {
			
			for (int space = 1; space <= (2 * line)-2; space++) {
				System.out.print(" ");
			}
			
			System.out.print("\\_");
			
			for(int slash = 1; slash <= (-2 * line) + (3 * size) + 1; slash++) {
				System.out.print("/\\");
			}
			
			System.out.print("_/");
			System.out.println();
			}
	}
	
	
	
	
	
	
	
	public static void strightsection() {
		//The method <straightsection()> draw the <  |%%||%%|  > part of the Space Needle.
		for(int line = 1; line <= (size * 4); line++) {
			
			for(int space = 1; space <= ((2 * size) + 1); space++) {
				System.out.print(" ");
				
				
			}
			
			bar();
			
			percentLine();
			
			
			doublebar();
			
			
			percentLine();
			
			
			bar();
			
			
			System.out.println();
			
		}
			
	}
	
	public static void percentLine() {
		//The method <PercentLine()> print out <%>.
		for(int percent= 1; percent <= size - 2; percent++) {
			System.out.print("%");
		}
		
	}
	
	
	

}
