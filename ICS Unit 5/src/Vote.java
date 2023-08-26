import java.util.*;
public class Vote {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int size = console.nextInt();
		console.nextLine();
		String s = console.nextLine();
		int countA = s.replace("B", "").length();
		int countB = s.replace("A", "").length();
		if (countA > countB) {
			System.out.println("A");
		}else if (countB > countA) {
			System.out.println("B");
		}else {
			System.out.println("Tie");
		}


	}

}
