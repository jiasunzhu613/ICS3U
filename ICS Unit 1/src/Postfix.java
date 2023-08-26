import java.util.*;

public class Postfix {

	public static void main(String[] args) {

		// Problem
		//ArrayList<String> problems = new ArrayList<>();
		Scanner console = new Scanner(System.in);
		
		while (console.hasNextLine()){
			String read = console.nextLine();
			if (read.equals("0")) {
				break;
			}
			String[] problemSplit = read.split(" ");
			System.out.println(toPostfix(problemSplit));
				
			
			//System.out.println(problems);
		}
		/*
		String[] problemsArray = new String[problems.size()];
		problemsArray = problems.toArray(problemsArray);
		System.out.println(Arrays.toString(problemsArray));
		*/
		//String problem = console.nextLine();
		/*
		for (String i : problems) {
			System.out.println(Arrays.toString(i.split(" ")));
		}
		*/
		/*
		for (String i : problems) {
			String[] problemSplit = i.split(" ");
			System.out.println(toPostfix(problemSplit));
			System.out.println();
			
		}
		*/
      
		//System.out.println(problems);
		//String[] problemSplit = problem.split(" ");
		//console.close();

	}

	public static String toPostfix(String[] problemSplit) {
		// variable
		String answerFinal = "";
		ArrayList<String> answer = new ArrayList<>();
		int counter = 0;
		boolean initial = false;
		// System.out.println(answer.size());
		ArrayList<String> operators = new ArrayList<>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		for (int i = 0; i < problemSplit.length; i++) {
			if (dictionary.containsKey(problemSplit[i])) {
				int temp = dictionary.get(problemSplit[i]) + 1;
				dictionary.put(problemSplit[i], temp);
			} else {
				dictionary.put(problemSplit[i], 1);
			}

		}

		// System.out.println(Arrays.toString(problemSplit));
		for (int i = 0; i < problemSplit.length; i++) {
			if (operators.contains(problemSplit[i])) {
				if (Character.isDigit(problemSplit[i + 1].charAt(0))
						&& Character.isDigit(problemSplit[i + 2].charAt(0))) {
					if (i == 0 || initial) {
						answer.add(0, problemSplit[i]);
						answer.add(0, problemSplit[i + 2]);
						answer.add(0, problemSplit[i + 1]);
						initial = false;
					} else {
						answer.add(answer.size() - (answer.size() - i + 1 + counter), problemSplit[i]);
						answer.add(answer.size() - (answer.size() - i + 1 + counter), problemSplit[i + 2]);
						answer.add(answer.size() - (answer.size() - i + 1 + counter), problemSplit[i + 1]);
					}
				} else if (Character.isDigit(problemSplit[i + 1].charAt(0))) {
					if (i == 0 || initial) {
						answer.add(0, problemSplit[i]);
						answer.add(0, problemSplit[i + 1]);
						initial = false;
					} else {
						answer.add(answer.size() - (answer.size() - i + 1 + counter), problemSplit[i]);
						answer.add(answer.size() - (answer.size() - i + 1 + counter), problemSplit[i + 1]);
					}
				} else {
					if (i == 0) {
						answer.add(0, problemSplit[i]);
						counter++;
						initial = true;
					} else {
						answer.add(answer.size() - (answer.size() - i), problemSplit[i]);
						counter++;
						//initial = true;
					}

				}
			}else {
				int occurences = Collections.frequency(answer, problemSplit[i]);
				List<String> problemSplit1 = new ArrayList<String>(Arrays.asList(problemSplit));
				problemSplit1.remove(problemSplit[i]);
				if (dictionary.get(problemSplit[i]) > occurences && problemSplit1.contains(problemSplit[i]) == false) {
					answer.add(answer.size() - (answer.size()- i + counter), problemSplit[i]);
					counter--;
				}
			}
			/*
			 * else { answer.add(answer.size()-(answer.size()-i-1),problemSplit[i]); }
			 
			System.out.println(answer);
			System.out.println(answer.size());
			System.out.println(i);
			System.out.println(counter);
			System.out.println(initial);
			*/
		}
		for (String i : answer) {
			answerFinal += i + " ";
		}
		return answerFinal;
	}

}
