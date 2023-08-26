import javax.imageio.ImageIO; 
import javax.swing.*;     
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/*
 * @date November 2021
 * @author Jonathan Zhu
 */
public class Menu extends JFrame implements ActionListener{
	//Initiate variables
	public GameFrame gameFrame;
	private JButton rules, start, option1, option2, option3, option4, nextProblem, useChips, home;
	private JLabel logo;
	public JTextArea problem, correct, incorrect, chipCounterTitle, rulesText, stepRightUp;
	public static JTextArea chipCounter;
	private ArrayList<JButton> options;
	private String correctAnswer;
	private int timesAnswered = 0;

	public static void main(String[] args) throws IOException {
		//Creates new menu
		new Menu();
	}
	//Constructor
	public Menu() throws IOException {
		//Sets title at the top of the created JFrame
		super("PLINKO!");
		//Sets JFrame size
		setSize(800, 600);
		
		//Add an instance of the GameFrame class
		gameFrame = new GameFrame();
		gameFrame.setVisible(false);
		
		//Setting up go to home button
		home = new JButton("Home");
		home.setBounds(320, 440, 140, 45);
		home.setBackground(Color.decode("#ffffff"));
		home.setFont(new Font("Georgia", Font.PLAIN, 20));
		home.setVisible(false);
		home.addActionListener(this);
		
		//Setting up the text box for the rules
		rulesText = new JTextArea(
		"Welcome to PLINKO!"
		+ "\n\nIn this simple game, you will be tested on simple arithmatic concepts with 4 different math"
		+ "\nproblems. By correctly answering problems, you will be rewarded with a \"playing chip\" "
		+ "\nwhich you will be able to turn in for \"prize money\" at the end of the game by dropping them"
		+ "\ninto the plinko board."
		+ "\n\nIn the end, the more you play, the more you earn! Have fun!");
		rulesText.setBounds(50, 50, 750, 550);
		rulesText.setBackground(Color.decode("#66B2FF"));
		rulesText.setFont(new Font("IMPACT", Font.BOLD, 20));
		rulesText.setEditable(false);
		rulesText.setVisible(false);

		//Setting up rules button
		rules = new JButton("Rules");
		rules.setBounds(50+100, 430+30, 150, 80);
        rules.setBackground(Color.decode("#ffffff"));
        rules.setFont(new Font("Georgia", Font.PLAIN, 30));
        rules.setVisible(true);
        rules.addActionListener(this);
        
        //Setting up start button
        start = new JButton("Start");
        start.setBounds(400+100, 430+30, 150, 80);
        start.setBackground(Color.decode("#ffffff"));
        start.setFont(new Font("Georgia", Font.PLAIN, 30));
        start.setVisible(true);
        start.addActionListener(this);
        
        //Create image
        java.net.URL resource = getClass().getResource("plinkoLogo.png");
        BufferedImage myPicture = ImageIO.read(resource);
        logo = new JLabel(new ImageIcon(myPicture.getScaledInstance(542, 407, BufferedImage.SCALE_SMOOTH)));
        logo.setBounds(0, 0, 800, 480);
        logo.setVisible(true);
        
        //Setting up the text box to display the Step Right Up! text
        stepRightUp = new JTextArea("Step Right Up!");
        stepRightUp.setBounds(340-55, 30, 450, 100);
        stepRightUp.setBackground(Color.decode("#66B2FF"));
        stepRightUp.setFont(new Font("IMPACT", Font.BOLD, 40));
        stepRightUp.setEditable(false);
        stepRightUp.setVisible(false);
        
        //Setting up the text box to display the arithmetic problem
        problem = new JTextArea("");
        problem.setBounds(340-45, 100, 450, 100);
        problem.setBackground(Color.decode("#66B2FF"));
        problem.setFont(new Font("IMPACT", Font.BOLD, 60));
        problem.setEditable(false);
        problem.setVisible(false);
        
        //Creates an ArrayList to store all the multiple choice options
        options = new ArrayList<JButton>();
        
        //Setting up buttons for the multiple  choice answers
        option1 = new JButton("");
        option1.setBounds(170+50, 220, 140, 45);
        option1.setBackground(Color.decode("#ffffff"));
        option1.setFont(new Font("Georgia", Font.PLAIN, 20));
        option1.setVisible(false);
        option1.addActionListener(this);
        options.add(option1);
        
        option2 = new JButton("");
        option2.setBounds(170+50, 290, 140, 45);
        option2.setBackground(Color.decode("#ffffff"));
        option2.setFont(new Font("Georgia", Font.PLAIN, 20));
        option2.setVisible(false);
        option2.addActionListener(this);
        options.add(option2);
        
        option3 = new JButton("");
        option3.setBounds(370+50, 220, 140, 45);
        option3.setBackground(Color.decode("#ffffff"));
        option3.setFont(new Font("Georgia", Font.PLAIN, 20));
        option3.setVisible(false);
        option3.addActionListener(this);
        options.add(option3);
        
        option4 = new JButton("");
        option4.setBounds(370+50, 290, 140, 45);
        option4.setBackground(Color.decode("#ffffff"));
        option4.setFont(new Font("Georgia", Font.PLAIN, 20));
        option4.setVisible(false);
        option4.addActionListener(this);
        options.add(option4);

        //Setting up button to go to the next math problem
        nextProblem = new JButton("Next Problem");
        nextProblem.setBounds(320, 440, 140, 45);
        nextProblem.setBackground(Color.decode("#ffffff"));
        nextProblem.setFont(new Font("Georgia", Font.PLAIN, 20));
        nextProblem.setVisible(false);
        nextProblem.addActionListener(this);
        
        //Setting up title for chip counter
        chipCounterTitle = new JTextArea("Chip Counter:");
        chipCounterTitle.setBounds(660, 10, 130, 30);
        chipCounterTitle.setBackground(Color.decode("#66B2FF"));
        chipCounterTitle.setFont(new Font("Georgia", Font.PLAIN, 20));
        chipCounterTitle.setVisible(false);
        chipCounterTitle.setEditable(false);
        
        //Setting up chip counter which tallies the chips earned
        chipCounter = new JTextArea("1");
        chipCounter.setBounds(710, 30, 130, 45);
        chipCounter.setBackground(Color.decode("#66B2FF"));
        chipCounter.setFont(new Font("Georgia", Font.PLAIN, 40));
        chipCounter.setVisible(false);
        chipCounter.setEditable(false);
        
        //Setting up button to use the chips earned after answering all questions
        useChips = new JButton("Use Chips");
        useChips.setBounds(650, 520, 130, 45);
        useChips.setBackground(Color.decode("#ffffff"));
        useChips.setFont(new Font("Georgia", Font.PLAIN, 20));
        useChips.setVisible(false);
        useChips.addActionListener(this);
        
        
        //Setting up correct and incorrect text box
        correct = new JTextArea("Correct");
        correct.setBounds(325, 360, 200, 50);
        correct.setForeground(Color.decode("#009116"));
        correct.setBackground(Color.decode("#66B2FF"));
        correct.setFont(new Font("Georgia", Font.PLAIN, 40));
        correct.setEditable(false);
        correct.setVisible(false);
        
        incorrect = new JTextArea("Incorrect");
        incorrect.setBounds(310, 360, 300, 50);
        incorrect.setForeground(Color.decode("#AD0003"));
        incorrect.setBackground(Color.decode("#66B2FF"));
        incorrect.setFont(new Font("Georgia", Font.PLAIN, 40));
        incorrect.setEditable(false);
        incorrect.setVisible(false);
		
        //Add all elements to the Menu (JFrame)
        Container c = getContentPane();
	        c.setLayout(null);
			c.setBackground(Color.decode("#66B2FF"));
	        c.add(rules);
	        c.add(start);
	        c.add(logo);
	        c.add(problem);
	        c.add(correct);
	        c.add(incorrect);
	        c.add(nextProblem);
	        c.add(option1);
	        c.add(option2);
	        c.add(option3);
	        c.add(option4);
	        c.add(chipCounterTitle);
	        c.add(chipCounter);
	        c.add(useChips);
	        c.add(home);
	        c.add(rulesText);
	        c.add(stepRightUp);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setResizable(false);
	        setVisible(true);
	        setLocationRelativeTo(null);
	}

	//ActionListener method
	@Override
	public void actionPerformed(ActionEvent e) {
		//Action listener for when the user clicks the start button
		if (e.getSource() == start) {
			setUpProblem();
			enableButtons();
			nextProblem.setEnabled(false);
			System.out.println(correctAnswer);
			setStartScreen();
		}
		//Action listener for when the user clicks the nextProblem button
		else if (e.getSource() == nextProblem) {
			setUpProblem();
			enableButtons();
			stepRightUp.setVisible(false);
			nextProblem.setEnabled(false);
			System.out.println(correctAnswer);
		}
		//Action listener for when the user clicks the option1 button
		else if (e.getSource() == option1) {
			//Checks if the text assigned to the option1 button is equal to the correct answer for the math question
			if (option1.getText().equals(correctAnswer)) {
				answeredCorrect();
				//If the user has answered 4 questions, allow the user to use their chips 
				if (timesAnswered == 4) {
					answeredMax();
				}
			}else {
				answeredIncorrect();
				//If the user has answered 4 questions, allow the user to use their chips 
				if (timesAnswered == 4) {
					answeredMax();
				}
			}
		}
		//Same as option1 comments
		else if (e.getSource() == option2) {
			if (option2.getText().equals(correctAnswer)) {
				answeredCorrect();
				if (timesAnswered == 4) {
					answeredMax();
				}
			}else {
				answeredIncorrect();
				if (timesAnswered == 4) {
					answeredMax();
				}
			}
			
		}
		//Same as option1 comments
		else if (e.getSource() == option3) {
			if (option3.getText().equals(correctAnswer)) {
				answeredCorrect();
				if (timesAnswered == 4) {
					answeredMax();
				}
			}else {
				answeredIncorrect();
				if (timesAnswered == 4) {
					answeredMax();
				}
			}
		}
		//Same as option1 comments
		else if (e.getSource() == option4) {
			if (option4.getText().equals(correctAnswer)) {
				answeredCorrect();
				if (timesAnswered == 4) {
					answeredMax();
				}
			}else {
				answeredIncorrect();
				if (timesAnswered == 4) {
					answeredMax();
				}
			}
		}
		//Action listener for when the user clicks the use chips button
		else if (e.getSource() == useChips) {
			//Displays the instance of the GameFrame class
			gameFrame.setVisible(true);
			//Sets the chip counter tally in the gameFrame and the gamePanel in the gameFrame
			gameFrame.chipCounter.setText(chipCounter.getText());
			gameFrame.gamePanel.numBall = Integer.parseInt(gameFrame.chipCounter.getText());
			setVisible(false);
			 gameFrame.playAgain.setEnabled(false);
		}
		//Action listener for when the user clicks the home button
		else if (e.getSource() == home) {
			//Displays home screen
			setHome();
		}
		//Action listener for when the user clicks the rules button
		else if(e.getSource() == rules) {
			//Displays the rules screen
			setRules();
		}	
	}
	//Calling this method displays the rules screen
	public void setRules() {
		rulesText.setVisible(true);
		rules.setVisible(false);
		start.setVisible(false);
		logo.setVisible(false);
		home.setVisible(true);
		problem.setVisible(false);
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		option4.setVisible(false);
		nextProblem.setVisible(false);
		chipCounter.setVisible(false);
		chipCounterTitle.setVisible(false);
	}
	//Calling this method displays the home screen
	public void setHome() {
		rulesText.setVisible(false);
		rules.setVisible(true);
		start.setVisible(true);
		logo.setVisible(true);
		home.setVisible(false);
		problem.setVisible(false);
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		option4.setVisible(false);
		nextProblem.setVisible(false);
		chipCounter.setVisible(false);
		chipCounterTitle.setVisible(false);
	}
	//Calling this method displays the start screen
	public void setStartScreen() {
		rules.setVisible(false);
		start.setVisible(false);
		logo.setVisible(false);
		problem.setVisible(true);
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(true);
		option4.setVisible(true);
		nextProblem.setVisible(true);
		chipCounter.setVisible(true);
		chipCounterTitle.setVisible(true);
		stepRightUp.setVisible(true);
	}
	//Calling this method generates one of four problems using 3 random integers
	public static String generateProblem(int rand1, int rand2, int rand3, int chooseType) {
		if (chooseType == 1) {		
			return String.format("%d*%d+%d", rand1, rand2, rand3);
		}else if (chooseType == 2) {
			return String.format("%d*%d-%d", rand1, rand2, rand3);
		}else if (chooseType == 3) {
			return String.format("%d^%d+%d", rand1, rand2, rand3);
		}else {
			return String.format("%d^%d-%d", rand1, rand2, rand3);
		}
	}
	//Calling this method generates the multiple choice options and formats them into a string that is in a split-able by space
	public static String generateChoices(int rand1, int rand2, int rand3, int rand4, int chooseType) {
		if (chooseType == 1) {	
			ArrayList<String>answers = generateQ(rand1, rand2, rand3, rand4, chooseType);
			return String.format("%s %s %s %s %s", answers.get(0), answers.get(1), answers.get(2), answers.get(3), answers.get(4));
		}else if (chooseType == 2) {
			ArrayList<String>answers = generateQ(rand1, rand2, rand3, rand4, chooseType);
			return String.format("%s %s %s %s %s", answers.get(0), answers.get(1), answers.get(2), answers.get(3),answers.get(4));
		}else if (chooseType == 3) {
			ArrayList<String>answers = generateQ(rand1, rand2, rand3, rand4, chooseType);
			return String.format("%s %s %s %s %s", answers.get(0), answers.get(1), answers.get(2), answers.get(3), answers.get(4));
		}else {
			ArrayList<String>answers = generateQ(rand1, rand2, rand3, rand4, chooseType);
			return String.format("%s %s %s %s %s", answers.get(0), answers.get(1), answers.get(2), answers.get(3),answers.get(4));
		}	
	}
	//Calling this method generates a random number between the min and the max (inclusive)
	public static int randomNumber(int min, int max) {
		return (int)Math.floor((max+1-min)*Math.random()+min);
	}
	//Calling this method sets the text for the math questions and its multiple choice answers
	public void setUpProblem() {
		int rand1 = randomNumber(1,50);
		int rand2 = randomNumber(1,5);
		int rand3 = randomNumber(0, 100);
		int rand4 = randomNumber(-50, 50);
		int chooseType = randomNumber(1,4);
		problem.setText(generateProblem(rand1, rand2, rand3, chooseType));
		String[] choices = generateChoices(rand1, rand2, rand3, rand4, chooseType).split(" ");
		correctAnswer = choices[4];
		for (int i=0; i<4; i++) {
			options.get(i).setText(choices[i]);
		}
		correct.setVisible(false);
		incorrect.setVisible(false);
	}
	//Calling this method disables the multiple choice answer buttons so that the user isn't able to answer a question more than once
	public void disableButtons() {
		option1.setEnabled(false);
		option2.setEnabled(false);
		option3.setEnabled(false);
		option4.setEnabled(false);
	}
	//Calling this method enables the multiple choice answer buttons 
	public void enableButtons() {
		option1.setEnabled(true);
		option2.setEnabled(true);
		option3.setEnabled(true);
		option4.setEnabled(true);
	}
	//Calling this method generates the multiple choice answers and returns an ArrayList that contains the values
	public static ArrayList<String> generateQ(int rand1, int rand2, int rand3, int rand4, int chooseType) {
		if (chooseType == 1) {	
			String a1 = String.valueOf((int)(rand1*rand2)+rand1+rand3);
			String a2 = String.valueOf((int)(rand1*rand2)+rand1-rand3);
			String a3 = String.valueOf((int)(rand1*rand2)+rand1+rand4);
			String a4 = String.valueOf((int)(rand1*rand2)+rand3);
			ArrayList<String>answers = new ArrayList<String>();
			answers.add(a1);
			answers.add(a2);
			answers.add(a3);
			answers.add(a4);
			String correctAnswer = a4;
			Collections.shuffle(answers);
			answers.add(correctAnswer);
			return answers;
		}else if (chooseType == 2) {
			String a1 = String.valueOf((int)(rand1*rand2)-rand1+rand3);
			String a2 = String.valueOf((int)(rand1*rand2)-rand1-rand3);
			String a3 = String.valueOf((int)(rand1*rand2)-rand1+rand4);
			String a4 = String.valueOf((int)(rand1*rand2)-rand3);
			ArrayList<String>answers = new ArrayList<String>();
			answers.add(a1);
			answers.add(a2);
			answers.add(a3);
			answers.add(a4);
			String correctAnswer = a4;
			Collections.shuffle(answers);
			answers.add(correctAnswer);
			return answers;
		}else if (chooseType == 3) {
			String a1 = String.valueOf((int)Math.pow(rand1, rand2)+rand1+rand3);
			String a2 = String.valueOf((int)Math.pow(rand1, rand2)+rand1-rand3);
			String a3 = String.valueOf((int)Math.pow(rand1, rand2)+rand1+rand4);
			String a4 = String.valueOf((int)Math.pow(rand1, rand2)+rand3);
			ArrayList<String>answers = new ArrayList<String>();
			answers.add(a1);
			answers.add(a2);
			answers.add(a3);
			answers.add(a4);
			String correctAnswer = a4;
			Collections.shuffle(answers);
			answers.add(correctAnswer);
			return answers;
		}else {
			String a1 = String.valueOf((int)Math.pow(rand1, rand2)-rand1+rand3);
			String a2 = String.valueOf((int)Math.pow(rand1, rand2)-rand1-rand3);
			String a3 = String.valueOf((int)Math.pow(rand1, rand2)-rand1+rand4);
			String a4 = String.valueOf((int)Math.pow(rand1, rand2)-rand3);
			ArrayList<String>answers = new ArrayList<String>();
			answers.add(a1);
			answers.add(a2);
			answers.add(a3);
			answers.add(a4);
			String correctAnswer = a4;
			Collections.shuffle(answers);
			answers.add(correctAnswer);
			return answers;
		}	
	}
	//Displays the correct text box if the user answered the question correctly
	public void answeredCorrect() {
		chipCounter.setText(String.valueOf(Integer.parseInt(chipCounter.getText())+1));
		correct.setVisible(true);
		incorrect.setVisible(false);
		disableButtons();
		nextProblem.setEnabled(true);
		timesAnswered+=1;
	}
	//Displays the incorrect text box if the user answered the question incorrectly
	public void answeredIncorrect() {
		incorrect.setVisible(true);
		correct.setVisible(false);
		disableButtons();
		nextProblem.setEnabled(true);
		timesAnswered+=1;
	}
	//Displays useChips button
	public void answeredMax() {
		nextProblem.setEnabled(false);
		useChips.setVisible(true);
	}
}
