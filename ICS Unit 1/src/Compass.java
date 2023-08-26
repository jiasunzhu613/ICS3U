import java.util.*;

public class Compass {

	public static void main(String[] args) {
		// variables
		int bearingEquivalent = 0;
		String compassEquivalent = "";
		boolean invalid = false;
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		dictionary.put("N", 0);
		dictionary.put("E", 90);
		dictionary.put("S", 180);
		dictionary.put("W", 270);

		// Scanner
		Scanner console = new Scanner(System.in);

		// User input for choice
		System.out.println("Choose: ");
		int choice = console.nextInt();

		
		if (choice == 2) { // choice 2
			// User input for compass direction
			console.nextLine();
			System.out.println("Enter a compass direction: ");
			String input = console.nextLine();

			// Splitting given compass direction into the directions and and angle
			String direction = "";
			String angle = "";
			for (int i = 0; i < input.length(); i++) {
				if (Character.isDigit(input.charAt(i))) {
					angle += String.valueOf(input.charAt(i));//taken from https://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string
				} else if (Character.isLetter(input.charAt(i))) {
					direction += String.valueOf(input.charAt(i));
				}
			} // end for loop
			
			if (angle == "") {//checks if compass is a bearing that is exactly between 2 directions
				if (String.valueOf(direction.charAt(0)).equals("N") && direction.length() == 2) {
					if (String.valueOf(direction.charAt(1)).equals("W")) {
						bearingEquivalent = (360 + 270) / 2;
					}else if (String.valueOf(direction.charAt(1)).equals("E")) {
						bearingEquivalent = (0 + 90) / 2;
					}else {
						invalid = true;
					}
				} else if (String.valueOf(direction.charAt(0)).equals("S") && direction.length() == 2) {
					if (String.valueOf(direction.charAt(1)).equals("W")) {
						bearingEquivalent = (180 + 270) / 2;
					} else if (String.valueOf(direction.charAt(1)).equals("E")) {
						bearingEquivalent = (180 + 90) / 2;
					}else {
						invalid = true;
					}
		
				}else if(direction.length() == 1 && dictionary.containsKey(direction)){
					bearingEquivalent = dictionary.get(direction);
				}else {
					invalid = true;
				}

			} else {
				
				if (String.valueOf(direction.charAt(0)).equals("N")) {//if initial direction is N
					if (String.valueOf(direction.charAt(1)).equals("W")) {
						bearingEquivalent = 360 - Integer.parseInt(angle);
					} else if (String.valueOf(direction.charAt(1)).equals("E")) {
						bearingEquivalent = 0 + Integer.parseInt(angle);
					}else {
						invalid = true;
					}
				} else if (String.valueOf(direction.charAt(0)).equals("S")) {//if initial direction is S
					if (String.valueOf(direction.charAt(1)).equals("W")) {
						bearingEquivalent = 180 + Integer.parseInt(angle);
					} else if (String.valueOf(direction.charAt(1)).equals("E")) {
						bearingEquivalent = 180 - Integer.parseInt(angle);
					}else {
						invalid = true;
					}
				} else if (String.valueOf(direction.charAt(0)).equals("W")) {//if initial direction is W
					if (String.valueOf(direction.charAt(1)).equals("N")) {
						bearingEquivalent = 270 + Integer.parseInt(angle);
					} else if (String.valueOf(direction.charAt(1)).equals("S")) {
						bearingEquivalent = 270 - Integer.parseInt(angle);
					}else {
						invalid = true;
					}
				} else {//if initial direction is E
					if (String.valueOf(direction.charAt(1)).equals("N")) {
						bearingEquivalent = 90 - Integer.parseInt(angle);
					} else if (String.valueOf(direction.charAt(1)).equals("S")) {
						bearingEquivalent = 90 + Integer.parseInt(angle);
					}else {
						invalid = true;
					}
				}
			}
			//checks invalid inputs and outputs valid inputs
			if (bearingEquivalent > 360 || bearingEquivalent < 0 || invalid) {
				System.out.println("Invalid");
			} else {
				System.out.println("Compass " + input + " is a bearing of " + bearingEquivalent);
			}

		} else {//choice 1
			System.out.println("Enter a bearing: ");
			int bearing = console.nextInt();
			if (bearing >= 0 && bearing <= 90) {//checks if compass equivalent of bearing is in NE quadrant
				if (bearing == 45) {
					compassEquivalent = "NE";
				}else if(bearing == 0) {
					compassEquivalent = "N";
				}else if(bearing == 90) {
					compassEquivalent = "E";
				}else if(bearing > 45) {
					compassEquivalent = "E" + (90 - bearing) + "N";
				}else {
					compassEquivalent = "N" + (0 + bearing) + "E";
				}
			}else if (bearing >= 90 && bearing <= 180) {//checks if compass equivalent of bearing is in SE quadrant
				if (bearing == 135) {
					compassEquivalent = "SE";
				}else if(bearing == 90) {
					compassEquivalent = "E";
				}else if(bearing == 180) {
					compassEquivalent = "S";
				}else if(bearing > 135) {
					compassEquivalent = "S" + (180 - bearing) + "E";
				}else {
					compassEquivalent = "E" + (bearing - 90) + "S";
				}
			}else if (bearing >= 180 && bearing <= 270) {//checks if compass equivalent of bearing is in SW quadrant
				if (bearing == 225) {
					compassEquivalent = "SW";
				}else if(bearing == 180) {
					compassEquivalent = "S";
				}else if(bearing == 270) {
					compassEquivalent = "W";
				}else if(bearing > 225) {
					compassEquivalent = "W" + (270 - bearing) + "S";
				}else {
					compassEquivalent = "S" + (bearing - 180) + "W";
				}
			}else if (bearing >= 270 && bearing <= 360) {//checks if compass equivalent of bearing is in NW quadrant
				if (bearing == 315) {
					compassEquivalent = "NW";
				}else if(bearing == 270) {
					compassEquivalent = "W";
				}else if(bearing == 360) {
					compassEquivalent = "N";
				}else if(bearing > 315) {
					compassEquivalent = "N" + (360 - bearing) + "W";
				}else {
					compassEquivalent = "W" + (bearing - 270) + "N";
				}
			}
			//checks invalid inputs and outputs valid inputs
			if (bearing < 0 || bearing > 360) {
				System.out.println("Invalid");
			}else {
				System.out.println("Bearing " + bearing + " is " + compassEquivalent);
			}
			
		} // end if

	}

}
