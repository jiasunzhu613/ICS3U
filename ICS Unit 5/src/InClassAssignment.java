import java.util.*;
public class InClassAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		int N = console.nextInt();
		console.nextLine();
		for (int i = 0; i < N; i++) {
			String input = console.nextLine();
			String[] split = separateColour(input);
			//System.out.println(Arrays.toString(split));
			if (checkValid(input)) {
				System.out.println(getHexProper(input) + " is valid");
				printColour(split);
				setIntensity(split);
			}else {
				System.out.println(input + " is invalid");
			}
			System.out.println();
		}
	}

	public static boolean checkCode(String hex) {
		String hexChars = "0123456789ABCDEF";
		boolean check = true;
		for (int i = 0; i < hex.length(); i++) {
			if (hexChars.contains(String.valueOf(hex.charAt(i)))) {
				check = false;
				return check;
			}
		}
		if (hex.length() > 2 || hex.length() <= 0) {
			check = false;
		}
		return check;
	}

	public static int getValue(String hex) {
		String letters = "ABCDEF";
		int[] letterValues = {10, 11, 12, 13, 14, 15};
		int value = 0;
		
		if (hex.length() == 2) {
			if (isNumeric(String.valueOf(hex.charAt(0)))) {
				value += Integer.parseInt(String.valueOf(hex.charAt(0))) * 16;
				//System.out.println(value);
			}else {
				int ind = letters.indexOf(hex.charAt(0));
				if (ind != -1) {
					value += letterValues[ind] * 16;
				}else {
					return -1;
				}
				//System.out.println(value);
			}
			if (isNumeric(String.valueOf(hex.charAt(1)))) {
				value += Integer.parseInt(String.valueOf(hex.charAt(1)));
			}else {
				int ind = letters.indexOf(hex.charAt(1));
				if (ind != -1) {
					value += letterValues[ind];
				}else {
					return -1;
				}
			}
		}else if (hex.length() == 1) {
			if (isNumeric(String.valueOf(hex.charAt(0)))) {
				value += Integer.parseInt(String.valueOf(hex.charAt(0))) * 16;
			}else {
				int ind = letters.indexOf(hex.charAt(0));
				if (ind != -1) {
					value += letterValues[ind];
				}else {
					return -1;
				}
			}
		}
		return value;
	}

	//Helper method
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static String[] separateColour(String hex) {
		if (hex.length() == 6) {
			return splitString(hex);
		}else if (hex.length() == 5) {
			hex = "0" + hex;
			return splitString(hex);
		}else if (hex.length() == 4) {
			hex = "0" + hex.charAt(0) + "0" + hex.substring(1, 5);
			return splitString(hex);
		}else if (hex.length() == 3) {
			hex = "0" + hex.charAt(0) + "0" + hex.charAt(1) + "0" + hex.charAt(2); 
			return splitString(hex);
		}else if (hex.length() == 2) {
			hex = "000" + hex.charAt(0) + "0" + hex.charAt(1); 
			return splitString(hex);
		}else if (hex.length() == 1) {
			hex = "00000" + hex;
			return splitString(hex);
		}else {
			return splitString("000000");
		}
	}
	
	public static String getHexProper(String hex) {
		if (hex.length() == 6) {
			return hex;
		}else if (hex.length() == 5) {
			hex = "0" + hex;
			return hex;
		}else if (hex.length() == 4) {
			hex = "0" + hex.charAt(0) + "0" + hex.substring(1, 5);
			return hex;
		}else if (hex.length() == 3) {
			hex = "0" + hex.charAt(0) + "0" + hex.charAt(1) + "0" + hex.charAt(2); 
			return hex;
		}else if (hex.length() == 2) {
			hex = "000" + hex.charAt(0) + "0" + hex.charAt(1); 
			return hex;
		}else if (hex.length() == 1) {
			hex = "00000" + hex;
			return hex;
		}else {
			return "000000";
		}
	}
	
	//Helper Method
	public static String[] splitString(String hex) {
		String[] arr = new String[3];
		int ind = 0;
		for (int i = 0; i < 6; i+=2) {
			arr[ind] = hex.substring(i, i+2);
			ind++;
		}
		return arr;
	}
	
	public static void printColour(String[] splitHex) {
		int colour1 = getValue(splitHex[0]);
		int colour2 = getValue(splitHex[1]);
		int colour3 = getValue(splitHex[2]);
		System.out.println("R: " + colour1);
		System.out.println("G: " + colour2);
		System.out.println("B: " + colour3);
	}
	
	public static void setIntensity(String[] splitHex) {
		int size = 0;
		String[] colourArr = {"red", "green", "blue"};
		int[] values = returnColour(splitHex);
		int[] maxArr = new int[3];
		for (int i = 0; i < 3; i++) {
			maxArr[i] = -1;
		}
		int maxValue = -1;
		
		for (int i : values) {
			maxValue = Math.max(maxValue, i);
		}
		
		for (int i = 0; i < 3; i++) {
			if (values[i] == maxValue) {
				maxArr[i] = maxValue;
			}
		}
		/*
		 * 0 : black
1-50 : dark grey 
51-150: medium
151-254: light grey
255: white
		 */
		for (int i : maxArr) {
			if (i != -1) {
				size++;
			}
		}
		if (size == 3) {
			if (maxValue == 0) {
				System.out.println("black");
			}else if (maxValue >= 1 && maxValue <= 50) {
				System.out.println("dark grey ");
			}else if (maxValue >= 51 && maxValue <= 150) {
				System.out.println("medium");
			}else if (maxValue >= 151 && maxValue <= 254) {
				System.out.println("light grey");
			}else if (maxValue == 255) {
				System.out.println("white");
			}
		}else {
			String colours = "";
			for (int i = 0; i < 3; i++) {
				if (maxArr[i] != -1) {
					colours += " " + colourArr[i];
				}
			}
			if (maxValue >= 0 && maxValue <= 50) {
				System.out.println("light" + colours);
			}else if (maxValue >= 51 && maxValue <= 150) {
				System.out.println("medium" + colours);
			}else {
				System.out.println("dark" + colours);
			}
		}
	}
	
	public static int[] returnColour(String[] splitHex) {
		int[] values = new int[3];
		values[0] = getValue(splitHex[0]);
		values[1] = getValue(splitHex[1]);
		values[2] = getValue(splitHex[2]);
		return values;
	}
	
	public static boolean checkValid(String hex) {
		String hexChars = "0123456789ABCDEF";
		for (int i = 0; i < hex.length(); i++) {
			if (!hexChars.contains(String.valueOf(hex.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	

}
