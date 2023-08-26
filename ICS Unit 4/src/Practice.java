import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		char c = console.nextLine().charAt(0);
		int w = console.nextInt();
		int h = console.nextInt();
		printRect(c, w ,h);
	}

	public static void printHeading() {
		System.out.println("*******************************");
		System.out.println("* Colonel By Secondary School *");
		System.out.println("* ICS3U                       *");
		System.out.println("*******************************");
		
	}
	public static void printChorus () { 
	      System.out.println(); 
	      System.out.println("Ee-igh, ee-igh, oh!");   //1 
	      System.out.println(); 
	} 
	public static int dieRoll() {
		int roll = (int) Math.floor((7-1)*Math.random()+1);
		return roll;
	}
	public static void twoDieRoll() {
		int roll1 = (int) Math.floor((7-1)*Math.random()+1);
		int roll2 = (int) Math.floor((7-1)*Math.random()+1);
		int total = roll1 + roll2;
		System.out.println(roll1 + " and " + roll2 + " ==> total " + total);
	}
	public static void printRollDice(int numDice) {
		for (int i = 1; i <= numDice; i++) {
			int roll = dieRoll();
			System.out.println("Roll " + i + " is a " + roll );
		}
	}
	public static void printRect (char c, int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	public static void printHollowRect (char c, int width, int height) {
		for (int i = 0; i < height; i++) {
			if (i == 0 || i == height -1) {
				for (int j = 0; j < width; j++) {
					System.out.print(c);
				}
			}else {
				for (int j = 0; j < width; j++) {
					if (j == 0 || j == width -1) {
						System.out.print(c);
					}else {
						System.out.print(" ");
					}
					
				}
			}
			
			System.out.println();
		}
	}
	public static int randomNumber() {
		int rand = (int) Math.floor((7-1)*Math.random()+1);
		return rand;
	}
	public static int randomNumber(int max) {
		int rand = (int) Math.floor((max+1-1)*Math.random()+1);
		return rand;
	}
	public static int randomNumber(int min, int max) {
		int rand = (int) Math.floor((max+1-min)*Math.random()+min);
		return rand;
	}
	public static int randomNumber(int min, int max, int step) {
		int rand = (int) Math.floor((max-min)*Math.random()+min);
		return (rand % ((max+1 - min) / step)) * step + min;
	}
	public static double findLargest(double num1, double num2, double num3) {
		double largest = num1;
		if (num2 > largest) {
			largest = num2;
		}
		if (num3 > largest) {
			largest = num3;
		}
		return largest;
		
	}
	public static boolean isDivisible(int num1, int num2) {
		if (num1 % num2 == 0) {
			return true;
		}
		return false;
	}
	public static int findGcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
	    if (a == 0)
	        return b;

	    while (b != 0) {
	        if (a > b)
	            a = a - b;
	        else
	            b = b - a;
	    }
	    
	    return a;
	}
	public static boolean isLetter(String s) {
		if((s.length() == 1 && (int)s.charAt(0) >=97 && (int)s.charAt(0) <=122) || (s.length() == 1 && (int)s.charAt(0) >=65 && (int)s.charAt(0) <=90)) {
			return true;
		}
		return false;
	}
	
	
}
