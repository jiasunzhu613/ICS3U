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
/*
 * @date March 2022
 * @author Jonathan Zhu
 */
public class StatsPanel extends JPanel{
	// Initiate variables
	public int played, winPercent, currStreak, maxStreak, wins, previous;
	public int[] guessDistribution;
	private JTextArea playedTitle, winTitle, currStreakTitle, maxStreakTitle, statsLabel, distributionLabel;
	public JTextField playedValue, winValue, currStreakValue, maxStreakValue; 
	public ArrayList<Integer> streaks;
	
	//Constructor
	public StatsPanel() {
		//Creating an ArrayList to store streaks 
		streaks = new ArrayList<>();
		
		//Setting value for variable that tracks the number of games played
		played = 0;
		
		//Setting value for variable that tracks the number of games won
		wins = 0; 
		
		//Setting value for variable that tracks the win percentage
		winPercent = 0; 
		
		//Setting value for variable that tracks the current streak
		currStreak = 0;
		streaks.add(currStreak);
		
		//Setting value for variable that tracks the max streak 
		maxStreak = 0;
		
		//Creating an integer array that stores the # of guesses in order for the player to get the word correct
		guessDistribution = new int[7];
		
		//Setting value for variable that tracks which guess the player of the word on
		previous = -1;
		
		//Setting up the textbox to display "Played"
		playedTitle = new JTextArea("Played");
		playedTitle.setBounds(130, 100, 50, 20);
		playedTitle.setBackground(Color.decode("#363836"));
		playedTitle.setForeground(Color.decode("#ffffff"));
		playedTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		playedTitle.setEditable(false);
		playedTitle.setFocusable(false);
		playedTitle.setBorder(BorderFactory.createEmptyBorder());
		playedTitle.setVisible(true);
		this.add(playedTitle);
		
		//Setting up the textbox to display "Win%"
		winTitle = new JTextArea("Win%");
		winTitle.setBounds(230, 100, 50, 20);
		winTitle.setBackground(Color.decode("#363836"));
		winTitle.setForeground(Color.decode("#ffffff"));
		winTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		winTitle.setEditable(false);
		winTitle.setFocusable(false);
		winTitle.setBorder(BorderFactory.createEmptyBorder());
		winTitle.setVisible(true);
		this.add(winTitle);
		
		//Setting up the textbox to display "Current Streak"
		currStreakTitle = new JTextArea("Current\n Streak");
		currStreakTitle.setBounds(330, 100, 70, 40);
		currStreakTitle.setBackground(Color.decode("#363836"));
		currStreakTitle.setForeground(Color.decode("#ffffff"));
		currStreakTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		currStreakTitle.setEditable(false);
		currStreakTitle.setFocusable(false);
		currStreakTitle.setBorder(BorderFactory.createEmptyBorder());
		currStreakTitle.setVisible(true);
		this.add(currStreakTitle);
		
		//Setting up the textbox to display "Max Streak"
		maxStreakTitle = new JTextArea("  Max\nStreak");
		maxStreakTitle.setBounds(430, 100, 70, 40);
		maxStreakTitle.setBackground(Color.decode("#363836"));
		maxStreakTitle.setForeground(Color.decode("#ffffff"));
		maxStreakTitle.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
		maxStreakTitle.setEditable(false);
		maxStreakTitle.setFocusable(false);
		maxStreakTitle.setBorder(BorderFactory.createEmptyBorder());
		maxStreakTitle.setVisible(true);
		this.add(maxStreakTitle);
		
		//Setting up the textbox to display the number of games played
		playedValue = new JTextField(String.valueOf(played));
		playedValue.setBounds(120, 60, 70, 40);
		playedValue.setBackground(Color.decode("#363836"));
		playedValue.setForeground(Color.decode("#ffffff"));
		playedValue.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
		playedValue.setEditable(false);
		playedValue.setFocusable(false);
		playedValue.setHorizontalAlignment(JTextField.CENTER);
		playedValue.setBorder(BorderFactory.createEmptyBorder());
		playedValue.setVisible(true);
		this.add(playedValue);
		
		//Setting up the textbox to display the win percentage
		winValue = new JTextField(String.valueOf(winPercent));
		winValue.setBounds(220, 60, 70, 40);
		winValue.setBackground(Color.decode("#363836"));
		winValue.setForeground(Color.decode("#ffffff"));
		winValue.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
		winValue.setEditable(false);
		winValue.setFocusable(false);
		winValue.setHorizontalAlignment(JTextField.CENTER);
		winValue.setBorder(BorderFactory.createEmptyBorder());
		winValue.setVisible(true);
		this.add(winValue);
		
		//Setting up the textbox to display the current streak
		currStreakValue = new JTextField(String.valueOf(currStreak));
		currStreakValue.setBounds(320, 60, 70, 40);
		currStreakValue.setBackground(Color.decode("#363836"));
		currStreakValue.setForeground(Color.decode("#ffffff"));
		currStreakValue.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
		currStreakValue.setEditable(false);
		currStreakValue.setFocusable(false);
		currStreakValue.setHorizontalAlignment(JTextField.CENTER);
		currStreakValue.setBorder(BorderFactory.createEmptyBorder());
		currStreakValue.setVisible(true);
		this.add(currStreakValue);
		
		//Setting up the textbox to display the maximum streak the player has gotten
		maxStreakValue = new JTextField(String.valueOf(maxStreak));
		maxStreakValue.setBounds(420, 60, 70, 40);
		maxStreakValue.setBackground(Color.decode("#363836"));
		maxStreakValue.setForeground(Color.decode("#ffffff"));
		maxStreakValue.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
		maxStreakValue.setEditable(false);
		maxStreakValue.setFocusable(false);
		maxStreakValue.setHorizontalAlignment(JTextField.CENTER);
		maxStreakValue.setBorder(BorderFactory.createEmptyBorder());
		maxStreakValue.setVisible(true);
		this.add(maxStreakValue);
		
		//Setting up the textbox to display the title "STATISTICS"
		statsLabel = new JTextArea("STATISTICS");
		statsLabel.setBounds(240, 15, 120, 20);
		statsLabel.setBackground(Color.decode("#363836"));
		statsLabel.setForeground(Color.decode("#ffffff"));
		statsLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		statsLabel.setEditable(false);
		statsLabel.setFocusable(false);
		statsLabel.setBorder(BorderFactory.createEmptyBorder());
		statsLabel.setVisible(true);
		this.add(statsLabel);

		//Setting up the textbox to display the title "GUESS DISTRIBUTION"
		distributionLabel = new JTextArea("GUESS DISTRIBUTION");
		distributionLabel.setBounds(190, 190, 250, 20);
		distributionLabel.setBackground(Color.decode("#363836"));
		distributionLabel.setForeground(Color.decode("#ffffff"));
		distributionLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		distributionLabel.setEditable(false);
		distributionLabel.setFocusable(false);
		distributionLabel.setBorder(BorderFactory.createEmptyBorder());
		distributionLabel.setVisible(true);
		this.add(distributionLabel);
		
		//Settings for the panel
		this.setBounds(0, 0, 600, 450);
		this.setLayout(null);
		this.setBackground(Color.decode("#363836"));
	}
	
	//Method used to paint the guess distribution onto the panel
	public void paintComponent(Graphics g) {
		//Gets the total number of correct guesses
		int sum = findSum(guessDistribution);
		
		//place to start painting the bar graph
		int yAxis = 240;
		
		//For loop that loops through the indices of the array guessDistribution
		for (int i = 1; i < guessDistribution.length; i++) {
			//Gets the ratio of the # of correct guesses at each number of guesses to the total number of correct guesses
			double ratio = guessDistribution[i] / (double) sum;
			
			//Draws the number on the left of each bar
			g.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
			g.setColor(Color.decode("#ffffff"));
			g.drawString(String.valueOf(i), 60, yAxis + 16);
			
			//Draws the bars of each # of guesses
			//Bar will be gray if the ratio is 0.0 or if it isn't the # of guesses needed to get the previous word
			//Bar will be green if it is the # of guesses needed to get the previous word
			if (ratio == 0.0) {
				g.setColor(Color.decode("#8e9190"));
				g.fillRect(80, yAxis, 30, 20);
				g.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
				g.setColor(Color.decode("#ffffff"));
				g.drawString(String.valueOf(guessDistribution[i]), 90, yAxis + 15);
				yAxis += 30;
			}else if (i != previous) {
				g.setColor(Color.decode("#8e9190"));
				g.fillRect(80, yAxis, (int) (470 * ratio), 20);
				g.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
				g.setColor(Color.decode("#ffffff"));
				g.drawString(String.valueOf(guessDistribution[i]), 90, yAxis + 15);
				yAxis += 30;
			}else {
				g.setColor(Color.decode("#538e4e"));
				g.fillRect(80, yAxis, (int) (470 * ratio), 20);
				g.setFont(new Font("Helvetica Neue", Font.BOLD, 15));
				g.setColor(Color.decode("#ffffff"));
				g.drawString(String.valueOf(guessDistribution[i]), 90, yAxis + 15);
				yAxis += 30;
			}
		}
		previous = -1;
	}
	
	//Method that calculates the win percentage
	public static int calculateWin(int wins, int played) {
		return (int)(((double)wins / played) * 100);
	}
	
	//Method that finds the maximum value in an array
	public static int findMax(ArrayList<Integer> arr) {
		int max = arr.get(0);
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}
	
	//Method that finds the index of the maximum value in an array
	public static int findMaxIndex(int[] arr) {
		int max = arr[0];
		int ind = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = i;
				ind = i;
			}
		}
		return ind;
	}
	
	//Method that finds the sum of an array
	public static int findSum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		if (sum == 0) {
			return 1;
		}
		return sum;
	}

	//Method that updates the variables of the panel
	public void update() {
		playedValue.setText(String.valueOf(played));
		
		winPercent = calculateWin(wins, played);
		winValue.setText(String.valueOf(winPercent));
		
		currStreakValue.setText(String.valueOf(currStreak));
		
		maxStreak = findMax(streaks);
		maxStreakValue.setText(String.valueOf(maxStreak));	
	}
}
