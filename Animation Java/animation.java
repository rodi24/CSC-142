/* Rodas T Gebreslassie
 * 
 * animation.java
 * 
 * CSC 142
 * 
 * This program display 2D motion graphics animation.
 */



import java.awt.*;

public class animation {
	
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(500,500);
		
		Graphics g = panel.getGraphics();
		
		Color green4 = new Color(0,89,46);
		Color burgendy = new Color(128, 0, 32);
		Color purple = new Color( 61, 13, 37);
		Color lightyellow = new Color(	25-25-112);
		Color brown = new Color(101, 67, 33	);
		
		panel.setBackground(purple);
		
		fullScreen(panel, g, Color.black, burgendy);
		rotatePolygon(panel, g , green4, purple );
		drawBox(panel, g, lightyellow, green4);
		drawPhone(panel,g, Color.black, Color.GRAY);
		drawCamera(panel, g, Color.black, brown);
	}
	
	
	//The method <fullScreen(DrawingPanel panel, Graphics g, Color a, Color b)> draw circle 
	//background starting from the center by incrementing the radius of each circles.
	
	public static void fullScreen(DrawingPanel panel, Graphics g, Color a, Color b) {
		for(int i = -4; i <= 15; i++) {
			
			if(i % 2 == 0) {
				g.setColor(b);
			}
			else {
				g.setColor(a);
				
			}
			g.fillOval(25 * i, 25 * i, 500 - 50 * i, 500 - 50 * i);
			
			panel.sleep(70);
			
		}
		panel.sleep(200);
		
		
	}
	
	
	//This method draw rotating polygon.  
	public static void rotatePolygon(DrawingPanel panel, Graphics g, Color a, Color b) {
		for(int i = 1; i <= 20; i++) {
			int p1 = -5 * i + 250;
			int p2 = 5 * i +250; 
			
			g.setColor(b);
			Polygon poly = new Polygon();
			poly.addPoint( 250, p1);
			poly.addPoint(p2, 250);
			poly.addPoint(250, p2);
			poly.addPoint(p1, 250);
			g.fillPolygon(poly);
			panel.sleep(20);
		}
		
		
		for(int i = 1; i <= 53; i++) {
			int p3 = 5 * i + 245;
			int p4 = -5 * i + 255;
			
			Polygon poly = new Polygon();
			poly.addPoint( p3, 0);
			poly.addPoint(500, p3);
			poly.addPoint(p4, 500);
			poly.addPoint(0, p4);
			g.fillPolygon(poly);
			panel.sleep(20);
			
		}
		panel.sleep(100);
		
		
	}
	
	//This method draw photograph by accepting 4 parameters and 
	//by calling 3 static methods <drawScreen()>
	//<mountain()> and <circle()>.
	public static void drawBox(DrawingPanel panel, Graphics g, Color a, Color b) {
		g.setColor(a);
		int p1 = 0;
		int p2 = 0;
		for(int i = 1; i <= 15; i ++) {
			p1 = -10 * i + 240;
			p2 = 20 * i +20;
			
			g.fillRect(230, p1, 40, p2);
			panel.sleep(50);
		}
		panel.sleep(10);
		int p3 = 0;
		int p4 = 0;
		for(int i = 1; i <= 11; i++) {
			p3 = -10 * i + 240;
			p4 = 20 * i + 20;
			g.fillRect(p3, p1, p4, p2);
			panel.sleep(50);
		}
		
		
		panel.sleep(120);
		
		drawScreen(panel, g, b, 22);
		mountain(panel, g, Color.YELLOW, Color.ORANGE);
		circle(panel, g, Color.yellow);
		
		panel.sleep(800);
		
		drawScreen(panel, g, Color.GRAY, 22);
		
		
		
		
		
		
		
		
		
	}
	
	//This method draw mountains that appears in the photograph.
	public static void mountain(DrawingPanel panel,Graphics g, Color a, Color b) {
		g.setColor(a);
		Polygon poly2 = new Polygon();
		poly2.addPoint( 150, 340);
		poly2.addPoint(312, 237);
		poly2.addPoint(350, 270);
		poly2.addPoint(350, 340);
		g.fillPolygon(poly2);
		
		
		g.setColor(b);
		Polygon poly = new Polygon();
		poly.addPoint( 150, 340);
		poly.addPoint(150, 300);
		poly.addPoint(200, 220);
		poly.addPoint(350, 320);
		poly.addPoint(350, 340);
		g.fillPolygon(poly);
		
	}
	
	//This method draw a circle by gradually increasing the radius.
	public static void circle(DrawingPanel panel, Graphics g, Color a) {
		g.setColor(a);
		
		for(int i = 1; i <= 4; i++ ) {
			g.fillOval(-5 * i + 295 , -5 * i + 175 , 10 * i, 10 * i);
			panel.sleep(70);
			
		}
		
	}
	
	//This method draw screen that appears in the photograph and phone.
	public static void drawScreen(DrawingPanel panel, Graphics g, Color b, int value) {
		g.setColor(b);
		int p5 = 0;
		for (int i = 0; i <= value; i++) {
			p5 = i * 10;
			
			g.fillRect(150,120, 200, p5);
			panel.sleep(50);
			
			
		}
		
	}
	
	
	//This method draws a phone by calling 1 static method <drawScreen()>.
	public static void drawPhone(DrawingPanel panel, Graphics g, Color a, Color b) {
		panel.clear();
		
		for(int i = 1; i <= 4; i++) {
			g.setColor(a);
			int y = -10 * i + 100;
			int py = -20 + 400;
			g.fillRect(130, y, 240, py);
			g.setColor(b);
			if(i == 4) {
				g.setColor(b);
			}
			int y2 = -10 * i + 130;
			int yp2 = 20 * i + 220;
			g.fillRect(150, y2, 200, yp2);
			panel.sleep(100);
			
		}
		
		g.setColor(Color.pink);
		g.fillOval(230, 400, 40, 40);
		
		g.setColor(Color.white);
		g.drawLine(200, 70, 300, 70);
		
		
		drawScreen(panel, g, Color.GRAY, 24);
		
		g.setColor(Color.white);
		g.drawLine(200, 70, 300, 70);
		
		
		
	}
	
	//This method draw Camera.
	public static void drawCamera(DrawingPanel panel, Graphics g, Color a, Color b) {
		Color purple = new Color( 61, 13, 37);
		rotatePolygon(panel,g,a,purple);
		panel.clear();
		
		Color lightyellow = new Color(	25-25-112);
		
		for(int i = 1; i <= 19; i++) {
			g.setColor(a);
			g.fillRect(-10 * i + 250, 240, 20 * i, 20);
			panel.sleep(50);
		}
		
		for(int i =1; i <= 10; i++) {
			g.setColor(a);
			g.fillRect(50, -10 * i + 250, 400, 20 * i);
			panel.sleep(50);
		}
		
		for(int i =1 ; i <= 5; i++) {
			g.setColor(b);
			
			
			g.fillRect(50, -10 * i + 250, 400, 20 * i);
			panel.sleep(50);
			
			
		}
		
		for(int i =1 ; i <= 6; i++) {
			g.setColor(Color.GRAY);
			g.fillOval(-10 * i + 320, -10 * i + 240, 20 * i + 20, 20 * i + 20);
			panel.sleep(50);
		}
		
		panel.sleep(30);
		g.setColor(Color.pink);
		g.fillRect(340, 125, 80, 43);
		
		g.setColor(Color.black);
		g.fillRect(80, 167, 120, 25);
		
		g.setColor(Color.blue);
		g.fillRect(100, 135, 80, 15);
		
		panel.sleep(200);
		panel.setBackground(Color.white);
		panel.clear();
		panel.sleep(100);
		panel.setBackground(purple);
		
		
		camera(panel,g,a, b);
		
	}
	//This method draw Camera after the flash.
	public static void  camera(DrawingPanel panel, Graphics g, Color a, Color b) {
		Color lightyellow = new Color(	25-25-112);
		g.setColor(a);
		g.fillRect(50, 150, 400, 200);
		g.setColor(b);
		g.fillRect(50, 200, 400, 100);
		g.setColor(Color.GRAY);
		g.fillOval(260, 190, 120, 120);
		
		g.setColor(lightyellow);
		g.fillRect(340, 125, 80, 43);
		
		g.setColor(Color.GRAY);
		g.fillRect(80, 167, 120, 25);  
		
		g.setColor(b);
		g.fillRect(100, 135, 80, 15);
		
		
	}
		
		
		 
}


