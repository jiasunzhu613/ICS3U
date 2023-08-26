import java.util.Scanner;

public class Practice604 {

	public static void main(String[] args) {
		class Fraction {
			int num; // numerator
			int den; // denominator
			public Fraction() {
				this.num = 0;
				this.den = 1;
			}
			
			public Fraction(int num, int den) {
				this.num = num;
				this.den = den;
			}
			
			public Fraction(Fraction f) {
				this.num = f.num;
				this.den = f.den;
			}
			
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
			
			public boolean equals (Fraction other) {
		        if (this.num == other.num && this.den == other.den) {
		            return true;
		        } else {
		            return false;
		        }
		    }
		}
		
		Fraction def = new Fraction();
        def.print();
        System.out.println("Default value check: " + def.equals(new Fraction(0, 1)));

        Fraction f1 = new Fraction(53, 54);
        f1.print();

        Fraction f2 = new Fraction(f1);
        f2.print();

        System.out.println("Assigned value check: " + f1.equals(f2));
	}

}
