import java.util.*;

public class DoLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1)
		 * Do loops are usually used in situations where we know that we want to perform the loop at least once.
		 * 
		 * 2)
		 * 25
		 * 
		 */
		
		//3)
		
		Scanner console = new Scanner(System.in);
		/*
		String want_continue = "";
		System.out.println("Continue? Respond with a y or n");
		do {
			want_continue = console.nextLine();
			System.out.println(want_continue);
			if (want_continue.equals("y")==false && want_continue.equals("n")==false) {
				System.out.println("Respond with a y or n");
			}
		}while (want_continue.equals("y")==false && want_continue.equals("n")==false);
		*/
		//4
		/*
		String alphabet = "";
		System.out.println("Enter an alphabet: ");
		do {
			alphabet = console.nextLine();
			if (Character.isLetter(alphabet.charAt(0)) == false) {
				System.out.println("Enter an alphabet: ");
			}
		}while (Character.isLetter(alphabet.charAt(0)) == false);
		*/
		//5
		/*
		int sum = 0;
		int posNum = 0;
		System.out.println("Enter a positive integet");
		do {
			posNum = console.nextInt();
			if(posNum <= 0) {
				System.out.println("Enter a positive integet");
			}
		}while(posNum <= 0);
		for (int i = 0; i<String.valueOf(posNum).length();i++) {
			sum += Integer.parseInt(String.valueOf(String.valueOf(posNum).charAt(i)));
		}
		System.out.println(sum);
		*/
		//6
		int secretPW = 123;
		int input = 0;
		System.out.println("Enter the secret PW: ");
		do {
			input = console.nextInt();
			if (input != secretPW) {
				System.out.println("Enter the secret PW: ");
			}
		}while (input != secretPW);
		
	}

}
