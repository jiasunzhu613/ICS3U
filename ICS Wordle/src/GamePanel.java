import java.awt.*;      
import java.awt.event.*;
import java.io.*;
import javax.print.attribute.AttributeSet;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;
import javax.swing.text.NavigationFilter;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
/*
 * @date March 2022
 * @author Jonathan Zhu
 */
public class GamePanel extends JPanel implements Runnable{
	// Initiate variables
	private Thread panelThread;
	private static JTextField[] letters;
	private static int currInd, currWordIndEnd, currWordIndStart, currCheck;
	private int ind;
	private int indAdd;
	private static Font f, k, k2;
	private static ArrayList<String> wordList;
	private static ArrayList<Character> unique;
	private static Map<Character, Integer> occurences;
	private String[] keyboardLabels = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", 
								       "ENTER", "DELETE", "Z", "X", "C", "V", "B", "N", "M"};
	private ArrayList<Dimension> dimensions; 
	private static Color[] keyboardColours;
	private static String ansWord;
	private ClickListener clickListener;
	public static StatsFrame stats;
	private boolean running;
	
	//Constructor
	public GamePanel() {
		//Setting value to track which textbox is currently being edited
		currInd = 0;
		
		//Setting value to track the end index of the current word able to be inputed
		currWordIndEnd = 4;
		
		//Setting value to track the start index of the current word able to be inputed
		currWordIndStart = 0;
		
		//Setting up JTextField array to store the textboxes where letters will be inputed
		letters = new JTextField[31];
		
		//Setting up Color array to store the colours used for the on-screen keyboard
		keyboardColours = new Color[28];
		
		//Setting up different font variables
		f = new Font("Helvetica Neue", Font.BOLD, 35);
		k = new Font("Helvetica Neue", Font.BOLD, 20);
		k2 = new Font("Helvetica Neue", Font.BOLD, 15);
		
		//Setting value for the counter used as indexes to store the textboxes
		ind = -1;
		indAdd = 0;
		
		//Creating an instance of the ClickListener class
		clickListener = new ClickListener();
		
		//Creating an Arraylist to store the dimensions of the rectangles for the on-screen keyboard
		dimensions = new ArrayList<>();
		
		//Setting value for the variable used to track the number of valid word checks
		currCheck = 0;
		
		//Retrieved from https://www.youtube.com/watch?v=oLirZqJFKPE at 28:06
		panelThread = new Thread(this);
		panelThread.start();
		running = true;
		
		//Instantiating and setting up the textboxes in the "letters" array
		for (int i = 310; i < 340+310; i += 80) {
			ind = indAdd;
			for (int j = 0; j < 425; j += 80) {
				letters[ind] = new JTextField();
				letters[ind].setText(" ");
				letters[ind].setBounds(i, j, 75, 75);
				letters[ind].setBackground(Color.decode("#121213"));
				letters[ind].setForeground(Color.decode("#ffffff"));
				letters[ind].setBorder(BorderFactory.createLineBorder(Color.decode("#787c7e"), 2));
				letters[ind].addKeyListener(new KeyBoardListener());
				letters[ind].setHorizontalAlignment(JTextField.CENTER);
				letters[ind].setFont(f);
				letters[ind].setVisible(true);
				letters[ind].addMouseListener(clickListener);
				
				this.add(letters[ind]);
				ind += 5;
			}
			indAdd++;
		}
		
		//Creating an extra textbox to store extra letter for the word check for the last word 
		ind-=5;
		ind++;
		letters[ind] = new JTextField();
		letters[ind].setText(" ");
		letters[ind].setBounds(0, 10, 75, 75);
		letters[ind].setBackground(Color.decode("#121213"));
		letters[ind].setForeground(Color.decode("#121213"));
		letters[ind].setBorder(BorderFactory.createLineBorder(Color.decode("#121213"), 2));
		letters[ind].addKeyListener(new KeyBoardListener());
		letters[ind].setHorizontalAlignment(JTextField.CENTER);
		letters[ind].setFont(f);
		letters[ind].setVisible(true);
		letters[ind].addMouseListener(clickListener);
		
		this.add(letters[ind]);
		
		//Adding colours to the "keyBoardColours" array
		for (int i = 0; i < keyboardColours.length; i++) {
			keyboardColours[i] = Color.decode("#808384");
		}
		
		//Reading "words.txt" file and storing all the words in and arrayList
		wordList = new ArrayList<>();
		File file = new File("/Users/jonathanzhu/eclipse-workspace/ICS Wordle/src/words.txt");
		try {
			Scanner console = new Scanner(file);
			while (console.hasNextLine()) {
				wordList.add(console.nextLine());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//Calls setAnsWord method to randomly take a word from the "wordList" arrayList and setting the "ansWord" string variable as the random word
		setAnsWord();
		
		//Instantiating and adding different dimensions to the "dimensions" arrayList
		ind = 0;
		for (int i = 233; i < 535+233; i+=55) {
			dimensions.add(ind, new Dimension(i, 495, 50, 65));
			ind++;
		}
		
		for (int i = 260; i < 495+260; i+=55) {
			dimensions.add(ind, new Dimension(i, 570, 50, 65));
			ind++;
		}
		dimensions.add(ind, new Dimension(233, 645, 77, 65));
		ind++;
		dimensions.add(ind, new Dimension(700, 645, 77, 65));
		ind++;

		for (int i = 315; i < 700; i+=55) {
			dimensions.add(ind, new Dimension(i, 645, 50, 65));
			ind++;
		}
		
		//Creating an instance of the "StatsFrame" class
		stats = new StatsFrame();
		stats.setVisible(false);

		//Creating the settings for the JPanel
		this.setBounds(0, 30, 1000, 800);
		this.setLayout(null);
		this.setBackground(Color.decode("#121213"));
		this.addMouseListener(clickListener);
	}
	
	//A method that will continuously run to repaint the JPanel (unless running is false)
	public void run() {
		//Retrieved from https://www.youtube.com/watch?v=oLirZqJFKPE at 28:06
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				repaint();
				delta--;
			}
		}
	}
	
	//Method that paints the JPanel / draws the on-screen keyboard
	public void paintComponent(Graphics g) {
		//Index counter
		ind = 0;
		
		//Draws first row of keyboard
		for (int i = 233; i < 535+233; i+=55) {
			g.setColor(keyboardColours[ind]);
			g.fillRoundRect(i, 495, 50, 65, 5, 5);
			g.setColor(Color.decode("#ffffff"));
			g.setFont(k);
			g.drawString(keyboardLabels[ind], i + 18, 533);
			ind++;
		}
		
		//Draws second row of keyboard
		for (int i = 260; i < 495+260; i+=55) {
			g.setColor(keyboardColours[ind]);
			g.fillRoundRect(i, 570, 50, 65, 5, 5);
			g.setColor(Color.decode("#ffffff"));
			g.setFont(k);
			g.drawString(keyboardLabels[ind], i + 18, 610);
			ind++;
		}
		
		//Draws enter buttons
		g.setColor(keyboardColours[ind]);
		g.fillRoundRect(233, 645, 77, 65, 5, 5);
		g.setColor(Color.decode("#ffffff"));
		g.setFont(k2);
		g.drawString(keyboardLabels[ind], 233 + 13, 683);
		ind++;
		
		//Draws delete button
		g.setColor(keyboardColours[ind]);
		g.fillRoundRect(700, 645, 77, 65, 5, 5);
		g.setColor(Color.decode("#ffffff"));
		g.setFont(k2);
		g.drawString(keyboardLabels[ind], 700 + 10, 683);
		ind++;

		//Draws third row of keyboard
		for (int i = 315; i < 700; i+=55) {
			g.setColor(keyboardColours[ind]);
			g.fillRoundRect(i, 645, 50, 65, 5, 5);
			g.setColor(Color.decode("#ffffff"));
			g.setFont(k);
			g.drawString(keyboardLabels[ind], i + 18, 683);
			ind++;
		}	
	}
	
	//ClickListener class which checks for on-screen clicks
	private class ClickListener extends MouseAdapter {
		
		//Method that checks if the mouse is pressed
		@Override
		public void mousePressed(MouseEvent e) {
			//Resets focus if user tries to press onto other textboxes 
			for (JTextField i : letters) {
				if (e.getSource() == i) {
					letters[currInd].requestFocus();	
				}
			}
			
			//checks if the on-screen enter button is pressed
			if (isIn(e.getX(), e.getY(), 1, 1, dimensions.get(19).x, dimensions.get(19).y, dimensions.get(19).width, dimensions.get(19).height)) {
				enter();
			}
			
			//checks if the on-screen delete button is pressed
			if (isIn(e.getX(), e.getY(), 1, 1, dimensions.get(20).x, dimensions.get(20).y, dimensions.get(20).width, dimensions.get(20).height)) {
				delete();
			}
			
			//check if all other letter buttons are pressed
			for (int i = 0; i < 28; i++) {
				if (isIn(e.getX(), e.getY(), 1, 1, dimensions.get(i).x, dimensions.get(i).y, dimensions.get(i).width, dimensions.get(i).height) && i != 19 && i != 20) {
					String letter = keyboardLabels[i];
					putText(letter);
				}
			}
		}
	}
	
	//KeyBoardListner class which checks for keyboard clicks
	private class KeyBoardListener extends KeyAdapter {
		
		//Check if a key on keyboard has been released
		@Override
		public void keyReleased(KeyEvent e) {
			//Checks if a key that is not part of the alphabet has been clicked
			if (!((e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') || (e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z'))) {
				String temp = letters[currInd].getText();
				letters[currInd].setText("");
			}
			
			//Checks if a key that is part of the alphabet has been clicked
			if ((e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') || (e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z')) {
				String temp = letters[currInd].getText();
				putText(temp.toUpperCase().replace(" ", ""));
			}
			
			//Checks if a textbox contains more than 1 character, if it does, make the text in the text box equal to the first character in the string
			if (letters[currInd].getText().length() > 1) {
				String temp = letters[currInd].getText();
				System.out.println(letters[currInd].getText());
				letters[currInd].setText(temp.substring(0, 1).toUpperCase());
			}
	    }
		
		//Checks if a key has been pressed
		@Override
		public void keyPressed(KeyEvent e) {
			//Checks if the pressed key is the delete key
			if (e.getKeyCode() == 8) {
				delete();
			}
			if (e.getKeyCode() == 10) {
				enter();
			}	
		}	
	}
	
	//Method that puts characters into textboxess properly
	public void putText(String s) {
		System.out.println("curr index" + currInd);
		letters[currInd].setText(s);
		if (currInd < letters.length && currInd <= currWordIndEnd) {
			increaseInd();	
		}
		if (currInd > currWordIndEnd) {
			letters[currInd].setText("");
		}

	}
	
	//Method that sets up information about the answer word, such as letter occurence
	public static void setAnsWord() {
		ansWord = getAnsWord(wordList);
		
		unique = new ArrayList<>();
		occurences = new HashMap<>();
		for (int i = 0; i < ansWord.length(); i++) {
			if (!unique.contains(ansWord.charAt(i))) {
				unique.add(ansWord.charAt(i));
			}
		}
		for (char i : unique) {
			occurences.put(i, countChar(i, ansWord));
			System.out.println(i + " " +  occurences.get(i));
		}
	}
	
	//Method that is used to check if a word being entered is valid 
	public void enter() {
		String word = getWord(letters, currWordIndStart, currWordIndEnd);
		if (checkWord(word, wordList)) {
			changeFieldColours(word);
			currWordIndStart = currWordIndEnd + 1;
			currWordIndEnd += 5;
			System.out.println("in enter curr indes "+currWordIndStart + " "+ currWordIndEnd);
			//increaseInd();
			System.out.println("VALID:" + word);
		}else {
			//currInd--;
			//letters[currInd].requestFocus();
			JOptionPane.showMessageDialog(null, "Not In Word List");
		}
	}
	
	//Method used to check if the mouse is in a certain position
	public boolean isIn(int px, int py, int pw, int ph, int tx, int ty, int tw, int th) {	
		if (pw <= 0 || ph <= 0 || tw <= 0 || th <= 0) {
			return false;
		}
		pw += px;
		ph += py;
		tw += tx;
		th += ty;
		return ((pw < px || pw > tx) &&
				(ph < py || ph > ty) &&
				(tw < tx || tw > px) &&
				(th < ty || th > py));
	}
	
	//Method that checks if a word is in the wordlist
	public boolean checkWord(String word, ArrayList<String> wordList) {
		return wordList.contains(word);
	}
	
	//Method that joins the characters in textboxes to create a word 
	public String getWord(JTextField[] letters, int start, int end) {
		String word = "";
		try {
			for (int i = start; i <= end; i++) {
				word += letters[i].getText();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return word;
	}
	
	//Method that is used to increase the currInd counter which is used to count which textbox is currently being edited
	public void increaseInd() {
		currInd++;
		letters[currInd].requestFocus();
	}
	
	//Method used to delete characters in textboxes
	public void delete() {
		if (currInd > currWordIndStart) {
			letters[currInd - 1].setText("");
			currInd--;
			letters[currInd].requestFocus();
		}
	}
	
	//Method that randomly gets a word from the wordlist
	public static String getAnsWord(ArrayList<String> wordList) {
		int rand = generateNum(wordList.size() - 1);
		return wordList.get(rand);
	}
	
	//Method that generates a random number from 0 to int max
	public static int generateNum(int max) {
		int rand = (int) (Math.floor((max+1) * Math.random()));
		return rand;
	}
	
	//Method that changes the colours of the textboxes and the on-screen keyboard after a valid word has been inputed
	public void changeFieldColours(String word) {
		ArrayList<Integer> changed = new ArrayList<>();
		Map<Character, Integer> occurencesInput = new HashMap<>();
		char wordChar;
		char ansChar;
		int checkWin = 0;
		boolean flag = false;
		
		//For loop to check if characters are in the correct position compared to characters in the answer word
		for (int i = 0; i < word.length(); i++) {
			wordChar = word.charAt(i);
			ansChar = ansWord.charAt(i);	
			if (!occurencesInput.containsKey(wordChar)) {
				occurencesInput.put(wordChar, 0);
			}
			if (wordChar == ansChar) {
				//Sets textbox colours
				letters[currWordIndStart + i].setBackground(Color.decode("#538e4e"));
				letters[currWordIndStart + i].setBorder(null);
				int temp = occurencesInput.get(wordChar) + 1;
				occurencesInput.put(wordChar, temp);
				changed.add(i);
				
				//Sets on-screen keyboard colour
				int keyboardInd = Arrays.asList(keyboardLabels).indexOf(String.valueOf(wordChar));
				keyboardColours[keyboardInd] = Color.decode("#538e4e");
				
				//Checks if the word is the answer word
				checkWin++;
				if (checkWin == 5) {
					gameWon();
					stats.setVisible(true);
					flag = true;
				}
			}
		}
		
		//For loop to check if characters are not in the answer word or are not in the correct position in the answer word
		for (int i = 0; i < word.length(); i++) {
			wordChar = word.charAt(i);
			ansChar = ansWord.charAt(i);
			
			//Checks if the character has already been changed in the previous for loop
			if (changed.contains(i)) {
				continue;
			}
			
			//Checks if the character is in the answer word but not in the right position
			if (ansWord.contains(String.valueOf(wordChar)) && occurencesInput.get(wordChar) < occurences.get(wordChar)) {
				//Sets textbox colours
				letters[currWordIndStart + i].setBackground(Color.decode("#b59f3a"));
				letters[currWordIndStart + i].setBorder(null);
				int temp = occurencesInput.get(wordChar) + 1;
				occurencesInput.put(wordChar, temp);
				
				//Sets on-screen keyboard colour
				int keyboardInd = Arrays.asList(keyboardLabels).indexOf(String.valueOf(wordChar));
				keyboardColours[keyboardInd] = Color.decode("#b59f3a");
			}else { //else statement to check all other cases (character not in answer word) 
				
				//Sets textbox colours
				letters[currWordIndStart + i].setBackground(Color.decode("#3a3a3c"));
				letters[currWordIndStart + i].setBorder(null);
				int keyboardInd = Arrays.asList(keyboardLabels).indexOf(String.valueOf(wordChar));
				
				//Sets on-screen keyboard colour
				keyboardColours[keyboardInd] = Color.decode("#3a3a3c");
			}
		}
		
		//Checks the number of checks that been done so far, if the counter is equal to 6, the game is over
		currCheck++;
		if (!flag && currCheck == 6) {
			gameEnd();
			stats.setVisible(true);
		}
		
		//Repaints the panel
		repaint();
	}
	
	//Method used for when the game is won (adds statistics to StatsFrame)
	public void gameWon() {
		stats.statsPanel.played++;
		stats.statsPanel.wins++;
		stats.statsPanel.currStreak++;
		stats.statsPanel.streaks.set(stats.statsPanel.streaks.size() - 1, stats.statsPanel.streaks.get(stats.statsPanel.streaks.size() - 1) + 1);
		stats.statsPanel.update();
		stats.statsPanel.guessDistribution[(currWordIndEnd + 1)/5]++;
		stats.statsPanel.previous = (currWordIndEnd + 1)/5;
		JOptionPane.showMessageDialog(null, "IMPRESSIVE");
	}
	
	//Method used for when the game is lost/ended (adds statistics to StatsFrame)
	public void gameEnd() {
		stats.statsPanel.played++;
		stats.statsPanel.currStreak = 0;
		stats.statsPanel.streaks.add(0);
		stats.statsPanel.update();
		JOptionPane.showMessageDialog(null, "THE WORD WAS: " + ansWord);
	}
	
	//Method that resets the panel
	public static void reset() {
		resetBoard();
		stats.setVisible(false);
		for (int i = 0; i < keyboardColours.length; i++) {
			keyboardColours[i] = Color.decode("#808384");
		}
	}
	
	//Helper method to reset the panel
	public static void resetBoard() {
		for (int i = 0; i < letters.length - 1; i++) {
			letters[i].setText(" ");
			letters[i].setBackground(Color.decode("#121213"));
			letters[i].setEditable(true);
			letters[i].setBorder(BorderFactory.createLineBorder(Color.decode("#787c7e"), 2));
		}
		
		currInd = 0;
		currWordIndEnd = 4;
		currWordIndStart = 0;
		letters[currInd].requestFocus();
		
		for (int i = 0; i < keyboardColours.length; i++) {
			keyboardColours[i] = Color.decode("#808384");
		}
		
		setAnsWord();
		currCheck = 0;
	}
	
	//Counts # of characters in a string
	public static int countChar(char c, String input) {
		int cnt = 0;
		for (int i = 0; i<input.length(); i++) {
			if (input.charAt(i) == c || (char)(input.charAt(i)-32) == c || (char)(input.charAt(i)+32) == c) {
				cnt++;
			}
		}
		return cnt;
	}
}
