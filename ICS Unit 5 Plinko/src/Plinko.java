import java.util.*;

//Method testing file, not used in GUI
public class Plinko {
	public static void main(String[] args) {
		/*
		 * - Welcome to Plinko page
		 * - Plinko rules page
		 * - Play button
		 * - Pressing the play button brings you to another swing tab, while closing the home page
		 * - In the Play tab, there will be a method called "createProblem" that creates math problems for the player to solve. 
		 * There will also be a counter for their chip count.
		 * - If the problem is solved correctly, their chip count increases by 1
		 * - at the end of the 4 problems, not matter correctness, they will be brought to a tab that allows them to spend their tokens.
		 * - In this tab, their they will introduced to an options that allows them to put their tokens, 
		 * and they will have a counter that counts how much money they earned
		 * - Tokens dropped will be simulated to see where they drop to, increasing the money counter accordingly
		 */
		
		//Generating random questions
		System.out.println(randomNumber(1,3));
		
		

	}
	public ArrayList<Integer> greaterThanSum(int value, ArrayList<Integer> array) {
		ArrayList<Integer>greaterThan = new ArrayList<Integer>();
		for(int i: array) {
			if (value >= i) {
				greaterThan.add(i);
			}
		}
		return greaterThan;
	}
	public static String generateProblem(int rand1, int rand2, int chooseType) {
		if (chooseType == 1) {		
			return String.format("%d*%d+%d", rand1, rand2, rand1);
		}else if (chooseType == 2) {
			return String.format("%d*%d-%d", rand1, rand2, rand1);
		}else if (chooseType == 3) {
			return String.format("%d^%d+%d", rand1, rand2, rand1);
		}else {
			return String.format("%d^%d-%d", rand1, rand2, rand1);
		}
	}
	public static String generateChoices(int rand1, int rand2, int chooseType) {
		if (chooseType == 1) {	
			String a1 = String.valueOf((int)(rand1*rand2)+rand1+10);
			String a2 = String.valueOf((int)(rand1*rand2)+rand1-5);
			String a3 = String.valueOf((int)(rand1*rand2)+rand1+17);
			String a4 = String.valueOf((int)(rand1*rand2)+rand1);
			ArrayList<String>answers = new ArrayList<String>();
			answers.add(a1);
			answers.add(a2);
			answers.add(a3);
			answers.add(a4);
			Collections.shuffle(answers);
			return String.format("a)%s\nb)%s\nc)%s\nd)%s", answers.get(0), answers.get(1), answers.get(2), answers.get(3));
		}else if (chooseType == 2) {
			String a1 = String.valueOf((int)(rand1*rand2)-rand1+10);
			String a2 = String.valueOf((int)(rand1*rand2)-rand1-5);
			String a3 = String.valueOf((int)(rand1*rand2)-rand1+17);
			String a4 = String.valueOf((int)(rand1*rand2)-rand1);
			ArrayList<String>answers = new ArrayList<String>();
			answers.add(a1);
			answers.add(a2);
			answers.add(a3);
			answers.add(a4);
			Collections.shuffle(answers);
			return String.format("a)%s\nb)%s\nc)%s\nd)%s", answers.get(0), answers.get(1), answers.get(2), answers.get(3));
		}else if (chooseType == 3) {
			String a1 = String.valueOf((int)Math.pow(rand1, rand2)+rand1+10);
			String a2 = String.valueOf((int)Math.pow(rand1, rand2)+rand1-5);
			String a3 = String.valueOf((int)Math.pow(rand1, rand2)+rand1+17);
			String a4 = String.valueOf((int)Math.pow(rand1, rand2)+rand1);
			ArrayList<String>answers = new ArrayList<String>();
			answers.add(a1);
			answers.add(a2);
			answers.add(a3);
			answers.add(a4);
			Collections.shuffle(answers);
			return String.format("a)%s\nb)%s\nc)%s\nd)%s", answers.get(0), answers.get(1), answers.get(2), answers.get(3));
		}else {
			String a1 = String.valueOf((int)Math.pow(rand1, rand2)-rand1+10);
			String a2 = String.valueOf((int)Math.pow(rand1, rand2)-rand1-5);
			String a3 = String.valueOf((int)Math.pow(rand1, rand2)-rand1+17);
			String a4 = String.valueOf((int)Math.pow(rand1, rand2)-rand1);
			ArrayList<String>answers = new ArrayList<String>();
			answers.add(a1);
			answers.add(a2);
			answers.add(a3);
			answers.add(a4);
			Collections.shuffle(answers);
			return String.format("a)%s\nb)%s\nc)%s\nd)%s", answers.get(0), answers.get(1), answers.get(2), answers.get(3));
		}
		
		
	}
	public static int randomNumber(int min, int max) {
		return (int)Math.floor((max+1-min)*Math.random()+min);
	}
	public static int closest(int value, int[] array) {
		int closestIndex = 0;
		for (int i=1; i<array.length;i++) {
			if (Math.abs(value - array[i]) < Math.abs(value - array[closestIndex])){
				closestIndex = i;
			}
			
		}
		return closestIndex;
	}

}
