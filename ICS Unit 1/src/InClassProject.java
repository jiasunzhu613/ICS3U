import java.util.*;
public class InClassProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		System.out.println("Enter an integer value: ");
		int a = console.nextInt();
		console.nextLine();
		System.out.println("Enter a string: ");
		final String B = console.nextLine();
		System.out.println("Enter a boolean value: ");
		boolean c = console.nextBoolean();
		System.out.println("Enter a double value: ");
		double d = console.nextDouble();
		System.out.println("Enter a long value: ");
		long e = console.nextLong();
		System.out.println("Enter a float value: ");
		float f = console.nextFloat();
		console.nextLine();
		System.out.println("Enter a character: ");
		char g = console.nextLine().charAt(0);
		
		double h = Math.round(d * Math.pow(10, 2)) / Math.pow(10, 2);
		int max = 2000*a+500;
		int min = 1000*a;
		double i = (Math.random() * (max - min +1)) + min;
		int j = (int)i;
		int k = j / 365;
		int l = (j % 365) / 7;
		int m = j % 365 % 7;
		String n = "\"" + i + " days\" is " + k + " y/" + l + " w/" + m + " d";
		double o = 5 * a + Math.sqrt((9*Math.pow(a, 3)) - 4);
		double p = (h / 2) + (Math.pow(f, 2) / 3 * d);
		double q = Math.toDegrees((Math.asin(Math.toRadians(((a % 3) + 1 / (e % 10) + 5)))));
		
		//output to user
	    System.out.println("Twelve days of " + a);
	    System.out.println("On the " + a + " day of " + B);
	    System.out.println("My "+ c +" love game to me:");
	    System.out.println(d + " drummers drumming");
	    System.out.println(e + " pipers piping");
	    System.out.println(f + " lords " + g + "-leaping");
	    System.out.println(h + " ladies dancing");
	    System.out.println(i + " maids " + g + "-milking");
	    System.out.println(j + " swans " + g + "-swimming");
	    System.out.println(k + " geese " + g + "-laying");
	    System.out.println(l +  " golden rings");
	    System.out.println(m +  " calling birds");
	    System.out.println(n + " french hens");
	    System.out.println(o + " turtle doves");
	    System.out.println("And a " + q + " in an \"mixed-up\" tree.");


	}

}
