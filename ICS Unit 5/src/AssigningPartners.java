import java.util.*;

public class AssigningPartners {

	public static void main(String[] args) {
		// Input
		Scanner console = new Scanner(System.in);
		int size = console.nextInt();
		console.nextLine();
		String[] people1 = console.nextLine().split(" ");
		String[] people2 = console.nextLine().split(" ");
		System.out.println(checkPartners(size, people1, people2));
	}

	public static String checkPartners(int size, String[] people1, String[] people2) {
		// Map creation
		Map<String, String> pairings = new HashMap<>();
		// Mapping partners
		/*
		 * for each elements add both partners to map, if we find the people in elements
		 * again we check if they have the same written partners, if not we will return
		 * bad, if iterate over everything return good
		 */
		for (int i = 0; i < size; i++) {
			if (pairings.containsKey(people1[i])) {
				if (!pairings.get(people1[i]).equals(people2[i])) {
					return "bad";
				}
			} else {
				if (!people1[i].equals(people2[i])) {
					pairings.put(people1[i], people2[i]);
				}else {
					return "bad";
				}
			}
			
			if (pairings.containsKey(people2[i])) {
				if (pairings.get(people2[i]).equals(people1[i]) != true) {
					return "bad";
				}
			} else {
				if (!people1[i].equals(people2[i])) {
					pairings.put(people2[i], people1[i]);
				}else {
					return "bad";
				}
			}

		}
		return "good";
	}

}
