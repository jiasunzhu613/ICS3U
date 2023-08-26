import java.util.*;
public class SnowCalls {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int cases = console.nextInt();
		for (int i = 0; i <= cases; i++) {
			String s = console.nextLine();
			System.out.println(generateNum(s));
		}
		/*
		for (char name: dictionary.keySet()) {
		    String value = dictionary.get(name).toString();
		    System.out.println(name + " " + value);
		}
		*/
	}
	
	public static String generateNum(String s) {
		String newNum = "";
		//Get rid of hyphens
		s = s.replace("-", "");
		
		//Map all letters to their corresponding value
		Map<Character, Integer> dictionary = new HashMap<>();
		for (int i = 65; i < 91; i++) {
			if (i <= 67) {
				dictionary.put((char)i, 2);
			}else if (i <= 70) {
				dictionary.put((char)i, 3);
			}else if (i <= 73) {
				dictionary.put((char)i, 4);
			}else if (i <= 76) {
				dictionary.put((char)i, 5);
			}else if (i <= 79) {
				dictionary.put((char)i, 6);
			}else if (i <= 83) {
				dictionary.put((char)i, 7);
			}else if (i <= 86) {
				dictionary.put((char)i, 8);
			}else {
				dictionary.put((char)i, 9);
			}
		}
		
		//Putting everything into new string and removing alphabetic characters
		for (int i = 0; i < s.length(); i++) {
			if ((char)s.charAt(i) >= 65 && (char)s.charAt(i) <= 90 && newNum.length() < 12) {
				if (newNum.length() == 3 || newNum.length() == 7) {
					newNum += "-";
				}
				newNum += String.valueOf(dictionary.get(s.charAt(i)));
			}else if (newNum.length() < 12){
				if (newNum.length() == 3 || newNum.length() == 7) {
					newNum += "-";
				}
				newNum += s.charAt(i);
			}
		}
		return newNum;
	}
	
	

}
