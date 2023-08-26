import java.util.*;

public class Practice603 {

	public static void main(String[] args) {
		// Q1
		/*
		 * a) r represents 4/5 b) r represents 7/-5 c) r represents 5/6 d) r represents
		 * -9/-12 e) r represents 13/20
		 */

		// Q2

		class Fraction {
			int num, den;

			public void plusEquals(Fraction other) {
				this.num = (this.num * other.den) + (other.num * this.den);
				this.den *= other.den;
			}

			public Fraction plus(Fraction other) {
				Fraction sum = new Fraction();
				sum.num = (this.num * other.den) + (other.num * this.den);
				sum.den = this.den * other.den;
				return sum;
			}

			public int gcd(int a, int b) {
				while (b != 0) {
					if (a > b)
						a = a - b;
					else
						b = b - a;
				}
				return a;
			}

			public void reduce() {
				int gcd = gcd(this.num, this.den);
				this.num /= gcd;
				this.den /= gcd;
			}

			public void print() {
				System.out.println(String.valueOf(this.num) + "/" + String.valueOf(this.den));
			}
		}

		Scanner s = new Scanner(System.in);
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		Fraction d = new Fraction();

		// set fractions with user input
		a.num = s.nextInt();
		a.den = s.nextInt();
		b.num = s.nextInt();
		b.den = s.nextInt();
		c.num = s.nextInt();
		c.den = s.nextInt();

		// call instance methods
		a.plusEquals(b);
		d = a.plus(c);
		d.reduce();

		// print fractions with instance method
		a.print();
		b.print();
		c.print();
		d.print();

	}

}
