import java.util.*;

public class Practice606 {

	public static void main(String[] args) {
		class Fraction {
			private int num; // numerator
			private int den; // denominator

			public Fraction() {
				this.num = 0;
				this.den = 1;
			}

			public Fraction(int num, int den) {
				if (den == 0) {
					this.den = 1;
					this.num = num;
				} else if (num < 0 && den < 0) {
					this.num = num * -1;
					this.den = den * -1;
				} else if (den < 0) {
					this.num = num * -1;
					this.den = den * -1;
				} else {
					this.num = num;
					this.den = den;
				}
			}

			public void setNumerator(int n) {
				if (n < 0 && this.den < 0) {
					this.num = n * -1;
					this.den *= -1;
				} else {
					this.num = n;
				}
				
			}

			public void setDenominator(int newDen) {
				if (newDen > 0) {
					this.den = newDen;
				} else if (newDen == 0) {
					this.den = 1;
				} else {
					this.den = -newDen; // force positive denominator
					this.num = -this.num; // change sign of numerator
				}
			}

			public int getNumerator() {
				return this.num;
			}

			public int getDenominator() {
				return this.den;
			}

			public void invert() {
//				Fraction temp = new Fraction();
//				temp.setDenominator(this.num);
//				temp.setNumerator(this.den);
//				this.den = temp.den;
//				this.num = temp.num;
				int temp = this.num;
				this.num = this.den;
				this.den = temp;
				if (this.den < 0) {
					this.den = -this.den;
					this.num = -this.num;
				}
			}

			public void print() {
				System.out.println(String.valueOf(this.num) + "/" + String.valueOf(this.den));
			}

		}
		
		Scanner s = new Scanner(System.in);
		// read in integer values
		int[] nums = new int[4];
		int[] dens = new int[4];
		for (int i = 0; i < 4; i++) {
			nums[i] = s.nextInt();
			dens[i] = s.nextInt();
		}
		
		// set fractions with user input
		Fraction a = new Fraction(nums[0], dens[0]);
		Fraction b = new Fraction(nums[1], dens[1]);
		Fraction c = new Fraction();
		Fraction d = new Fraction();

		// call getters/setters
		System.out.println(a.getNumerator());
		System.out.println(a.getDenominator());
		System.out.println(b.getNumerator());
		System.out.println(b.getDenominator());

		c.setNumerator(nums[2]);
		c.setDenominator(dens[2]);
		d.setNumerator(nums[3]);
		d.setDenominator(dens[3]);

		d.invert();
		// print fractions
		a.print();
		b.print();
		c.print();
		d.print();
//-1 0
//-1 0
//-1 0
//-1 0
	}
	
	

}
