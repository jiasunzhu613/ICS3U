import java.util.*;

public class Practice600 {

	public static void main(String[] args) {
		class Fraction {
			int num; // numerator
			int den; // denominator
		}
		
		// Question 1
		Fraction f = new Fraction();
		f.num = 2;
		f.den = 7;
		
		//Question 2
		/*
		Fraction p; // Fractions class hasn't been instantiated
					// p = new Fraction(); is needed 
					 * or Fraction p = new Fraction();

		p.num = 7; 
		p.den = 8;
		*/
		
		//Question 3
		Fraction p, q, r; 

		p = new Fraction(); 
		q = new Fraction(); 
		r = q; // reference to the same memory location 
	
		p.num = p.den = 2; //p.den = 2 and p.num = 2
		q.num = 2*p.den; // q.num = 4 and r.num = 4
		p.den++;  // p.den = 3
		p.num--;  // p.num = 1
		r.den = p.num + 2; // r.den = 3 and q.den = 3
		
		//Question 4
		Fraction f1 = new Fraction();
		Fraction f2 = new Fraction();
		
		Scanner console = new Scanner(System.in);
		String[] line1 = console.nextLine().split(" ");
		String[] line2 = console.nextLine().split(" ");
		
		f1.num = Integer.parseInt(line1[0]);
		f1.den = Integer.parseInt(line1[1]);
		f2.num = Integer.parseInt(line2[0]);
		f2.den = Integer.parseInt(line2[1]);
		
		f1.num *= 2;
		System.out.println(String.valueOf(f1.num) + "/" + String.valueOf(f1.den));
		
		int temp = f2.num;
		f2.num = f2.den;
		f2.den = temp;
		System.out.println(String.valueOf(f2.num) + "/" + String.valueOf(f2.den));
		
		f1.num = f1.num * f2.num;
		f1.den = f1.den * f2.den;
		System.out.println(String.valueOf(f1.num) + "/" + String.valueOf(f1.den));
		
		f2.num = (f1.num * f2.den) + (f2.num * f1.den);
		f2.den = f1.den * f2.den;
		System.out.println(String.valueOf(f2.num) + "/" + String.valueOf(f2.den));
		
		f1.num = Math.abs(f1.num);
		f1.den = Math.abs(f1.den);
		System.out.println(String.valueOf(f1.num) + "/" + String.valueOf(f1.den));
		
		

	}

}
