import java.util.*;
public class Practice608 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class Child{
			private int height;
			private double weight;
			public Child(int height, double weight) {
				this.height = height;
				this.weight = weight;
			}
			
			public boolean equals(Child other) {
				int hDiff = Math.abs(this.height - other.height);
				double wDiff = Math.abs(this.weight - other.weight);
				if (hDiff <= 2 && wDiff <= 0.5) {
					return true;
				}
				return false;
			}
			
			public String toString() {
				double inMeters = (double)this.height / 100.0;
				double bmi = this.weight / (inMeters * inMeters);
				if (bmi > 18.0) {
					return "Child - good";
				}return "Child - bad";
			}
		
		}
		
		Scanner s = new Scanner(System.in);
        Child child1 = new Child(s.nextInt(), s.nextDouble());
        Child child2 = new Child(s.nextInt(), s.nextDouble());
        Child child3 = new Child(s.nextInt(), s.nextDouble());
        System.out.println("Child 1 vs Child 2 - " + child1.equals(child2));
        System.out.println("Child 2 vs Child 3 - " + child2.equals(child3));
        System.out.println("Child 3 vs Child 1 - " + child3.equals(child1));

        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

	}

}
