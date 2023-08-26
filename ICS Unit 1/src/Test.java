import java.util.Arrays;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String input = console.nextLine().toLowerCase().replaceAll("\\s+","");
		String flipInput = "";
		for (int i = input.length()-1;i>=0;i--) {
			flipInput += String.valueOf(input.charAt(i));
		}
		if (input.equals(flipInput)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		
		/*
		int num = console.nextInt();
		for (int i = 1; i <= num;i++) {
			int result = i * num;
			System.out.println(num + " x " + i + " = " + result);
		}
		
		double partA = 0;
		for (int i = 1; i<=1000;i++) {
			partA += 1.0/i;
		}
		System.out.println(partA);
		double partB = 0;
		for (int i = 100;i<=5000;i+=100) {
			partB += (double) Math.sqrt(i);
		}
		System.out.println(partB);
		long partC = 1L;
		for (int i = 1; i<=20;i++) {
			partC *= i;
		}
		System.out.println(partC);
		long partD = 0L;
		for (int i = -12;i<=20;i++) {
			partD += Math.pow(i, 3);
		}
		System.out.println(partD);
		double partE = 0;
		for (int i = 1;i<=25;i++) {
			partE += Math.pow(i, (double)1.0/i);
		}
		System.out.println(partE);
		
		System.out.println("Enter integer 1:");
		int num1 = console.nextInt();
		System.out.println("Enter integer 2:");
		int num2 = console.nextInt();
		int[] arr = new int[2];
		if (num1 > num2) {
			arr[0]=num1;
			arr[1]=num2;
		}else {
			arr[0]=num2;
			arr[1]=num1;
		}
		System.out.println("Print asterisks: ");
		for (int i = arr[1]; i<arr[0];i++) {
			System.out.print("*");
		}
		System.out.println("\nCountdown seconds:");
		for (int i = arr[0];i>=arr[1];i--) {
			System.out.println(i + " seconds");
		}
		console.nextLine();
		System.out.println("Enter a letter: ");
		String letter1 = console.nextLine();
		System.out.println("Enter a letter: ");
		String letter2 = console.nextLine();
		int ascii1 = letter1.charAt(0);
		int ascii2 = letter2.charAt(0);
		for (int i = ascii1; i <= ascii2; i++) {
			System.out.println("Give me a " + String.valueOf((char)i));
		}
		System.out.println("Output multiples - start at integer 1 and multiply by integer 2 stop when greater than 1000");
		for (int i = num1; i<1000;i*=num2) {
			System.out.println(i);
		}
		
		System.out.println("Part a");
		for (int i = 6; i>=0;i--) {
			int ans = 2*i+5;
			System.out.println(i + " --> " + ans);
		}
		System.out.println("Part b");
		for (int i = 0; i<=30;i+=3) {
			int ans = 2*i+5;
			System.out.println(i + " --> " + ans);
		}
		System.out.println("Part c");
		for (int i = -15; i<=15;i+=5) {
			int ans = 2*i+5;
			System.out.println(i + " --> " + ans);
		}
		System.out.println("Part d");
		for (int i = 1; i<=1024;i*=2) {
			int ans = 2*i+5;
			System.out.println(i + " --> " + ans);
		}
		
		
		System.out.println("Enter integer 1:");
		int num1 = console.nextInt();
		System.out.println("Enter integer 2:");
		int num2 = console.nextInt();
		System.out.println("Print asterisks: ");
		for (int i = num1; i<num2;i++) {
			System.out.print("*");
		}
		System.out.println("\nCountdown seconds:");
		for (int i = num2;i>=num1;i--) {
			System.out.println(i + " seconds");
		}
		console.nextLine();
		System.out.println("Enter a letter: ");
		String letter1 = console.nextLine();
		System.out.println("Enter a letter: ");
		String letter2 = console.nextLine();
		int ascii1 = letter1.charAt(0);
		int ascii2 = letter2.charAt(0);
		for (int i = ascii1; i <= ascii2; i++) {
			System.out.println("Give me a " + String.valueOf((char)i));
		}
		System.out.println("Output multiples - start at integer 1 and multiply by integer 2 stop when greater than 1000");
		for (int i = num1; i<1000;i*=num2) {
			System.out.println(i);
		}
		
		
		
		
		Scanner console = new Scanner(System.in);
		System.out.println("Enter Password:");
		
		System.out.println("Enter Password:");
		String input = console.nextLine();
		while(!input.equals("coded")) {
			System.out.println("Enter Password:");
			input = console.nextLine();
		}
		System.out.println("Access Granted!");
		
		System.out.println("Enter a positive integer:");
		String num = console.nextLine();
		int sum = 0;
		while (Integer.parseInt(num) <= 0) {
			System.out.println("Enter a positive integer:");
			num = console.nextLine();
		}
		for (int i = 0; i<num.length();i++) {
			sum += Integer.parseInt(String.valueOf(num.charAt(i)));
		}
		System.out.println("Sum of " + num + "'s digits is " + sum);
		
		System.out.println("Enter a letter: ");
		String letter = console.nextLine();
		while (Character.isLetter(letter.charAt(0)) == false) {
			System.out.println("Not a letter. Enter a letter:");
			letter = console.nextLine();
		}
		System.out.println("Done.");
		
		System.out.println("Continue (y or n):");
		String ans = console.nextLine();
		while (ans.equals("y") == false && ans.equals("n") == false) {
			System.out.println("Continue (y or n):");
			ans = console.nextLine();
		}
		System.out.println("done");
		
		String numbers = console.nextLine();
		String[] numbersSplit = numbers.split(" ");
		//System.out.println(Arrays.toString(numbersSplit));
		int i = 0;
		int count = 0;
		while (numbersSplit[i].equals("0") == false) {
			if (numbersSplit[i+1].equals(numbersSplit[i])) {
				count++;
			}
			i++;
		}
		System.out.println("There are " + count + " cases of consecutive values");
		
		
		System.out.println("Enter a positive number (or negative number to quit):");
		double num = console.nextDouble();
		while (num >= 0) {
			double root = Math.round(Math.sqrt(num) * Math.pow(10, 3)) /Math.pow(10, 3);
			System.out.println("Square root is: " + root);
			System.out.println("Enter a positive number (or negative number to quit):");
			num = console.nextDouble();
		}
		
		System.out.println("Enter N: ");
		int n = console.nextInt();
		int sum = 0;
		while (n <= 0) {
			System.out.println("Invalid input.");
			System.out.println("Enter N: ");
			n = console.nextInt();
		}
		for (int i = 1; i<=n; i++) {
			sum += i;
		}
		System.out.println("The sum of the first " + n + " integers is " + sum);
		
		int guess;

		// System.out.println("This can result in an infinite loop - Fix it!");

		System.out.println("Enter your guess between 1 and 10: ");
		guess = userInput.nextInt();

		while (guess < 1 || guess > 10) {
			System.out.println("Invalid guess");
			guess = userInput.nextInt();
		}
		System.out.println("Valid guess entered");
		
		System.out.println("Enter a sentinel value:");
		int senValue = console.nextInt();
		System.out.println("Enter an integer: ");
		int num = console.nextInt();
		while(num != senValue) {
			System.out.println("Enter an integer: ");
			num = console.nextInt();
		}
		System.out.println("Stop");
		*/
		
	}

}
