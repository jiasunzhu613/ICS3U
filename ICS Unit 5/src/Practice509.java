import java.util.*;
public class Practice509 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		char oldChar = console.nextLine().charAt(0);
		char newChar = console.nextLine().charAt(0);
		String s = console.nextLine();
		System.out.println(replace(s, oldChar, newChar));

	}
	
	public static String replace(String s, char oldChar, char newChar) {
		String newS = "";
		int occ = 0;
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i) == oldChar && occ >= 1) {
				newS += newChar;
				occ = 0;
			}else if (s.charAt(i) == oldChar && occ < 1) {
				newS += s.charAt(i);
				occ++;
			}else {
				newS += s.charAt(i);
			}
		}
		return newS;
	}

}
