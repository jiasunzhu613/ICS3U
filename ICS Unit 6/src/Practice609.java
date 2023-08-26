import java.util.Scanner;

public class Practice609 {

	static class Fraction {
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
		
		public static Fraction product(Fraction a, Fraction b) {
			Fraction c = new Fraction();
			c.num = a.num * b.num;
			c.den = a.den * b.den;
			c.reduce();
			return c;
		}
		
		public static Fraction abs(Fraction a) {
			Fraction c = new Fraction();
			c.num = Math.abs(a.num);
			c.den = Math.abs(a.den);
			c.reduce();
			return c;
		}
		
		public static boolean isPositive(Fraction a) {
			if ((a.num > 0 && a.den > 0) || (a.num < 0 && a.den < 0)) {
				return true;
			}
			return false;
		}

		public static int gcd(int a, int b) {
			int initialA = a;
			//int initialB = b;
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
		    
		    if (initialA < 0) {
		    	return a*-1;
		    }
		    return a;
		}

		public void reduce() {
			int gcd = gcd(this.num, this.den);
			this.num /= gcd;
			this.den /= gcd;
			if (this.den < 0) {
				this.den = -this.den;
				this.num = -this.num;
			}
		}

		public void print() {
			System.out.println(String.valueOf(this.num) + "/" + String.valueOf(this.den));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s = new Scanner(System.in);

        Fraction p = new Fraction(s.nextInt(), s.nextInt());
        Fraction q = new Fraction(s.nextInt(), s.nextInt());
        //System.out.println(p.num);
        Fraction.product(p, q).print();
        Fraction.abs(q).print();        // 2

        System.out.println(Fraction.isPositive(p)); // 3
        System.out.println(Fraction.isPositive(q)); // 3

	}

}
