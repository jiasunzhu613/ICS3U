import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
/*
 * @date March 2022
 * @author Jonathan Zhu
 */
public class Menu extends JFrame implements ActionListener {
	// Initiate variables
	private JButton start, howToPlay, home;
	private JTextArea title;
	private JTextField howToPlayTitle;
	private JLabel howToPlayImage;
	private GameFrame gameFrame;

	//Creates a new menu
	public static void main(String[] args) throws IOException {
		/*
		 * PROBLEM WITH THE GAME:
		 * - Typing too fast/not releasing a key before pressing another key will result in the letters to be placed in the same textbox.
		 * This is because the keyReleased method will only run when a key has been released, thus if you keep keeping keys down the method won't run. 
		 */
		new Menu();

	}

	//Constructor
	public Menu() throws IOException {
		//Sets title of the frame
		super("WORDLE");
		
		//Setting up "Wordle" title
		title = new JTextArea("Wordle");
		title.setBounds(140, 200, 800, 200);
		title.setBackground(Color.decode("#121213"));
		title.setForeground(Color.decode("#ffffff"));
		title.setFont(new Font("Rockwell", Font.BOLD, 190));
		title.setVisible(true);
		title.setEditable(false);
		
		//Setting up start button
		start = new JButton("Start");
		start.setBounds(400 + 100+65, 430 + 30, 200, 60);
		start.setForeground(Color.decode("#538e4e"));
		start.setFocusPainted(false);
		start.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
		start.setVisible(true);
		start.addActionListener(this);
		
		//Setting up home button
		home = new JButton("Home");
		home.setBounds(400, 660, 200, 60);
		home.setForeground(Color.decode("#538e4e"));
		home.setFocusPainted(false);
		home.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
		home.setVisible(false);
		home.addActionListener(this);
		
		//Setting up how to play button
		howToPlay = new JButton("How to Play");
		howToPlay.setBounds(50 + 100+75, 430 + 30, 200, 60);
		howToPlay.setForeground(Color.decode("#538e4e"));
		howToPlay.setFocusPainted(false);
		howToPlay.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
		howToPlay.setVisible(true);
		howToPlay.addActionListener(this);
		
		//Setting up textbox to display the title "How To Play"
		howToPlayTitle = new JTextField("How To Play");
		howToPlayTitle.setBounds(335, 20, 400, 100);
		howToPlayTitle.setBackground(Color.decode("#121213"));
		howToPlayTitle.setForeground(Color.decode("#ffffff"));
		howToPlayTitle.setFont(new Font("Rockwell", Font.BOLD, 50));
		howToPlayTitle.setVisible(false);
		howToPlayTitle.setEditable(false);
		
		//Setting up how to play image
		java.net.URL resource = getClass().getResource("HowToPlayImage.png");
        BufferedImage myPicture = ImageIO.read(resource);
        howToPlayImage = new JLabel(new ImageIcon(myPicture.getScaledInstance(524, 489, BufferedImage.SCALE_SMOOTH)));
        howToPlayImage.setBounds(165, 50, 689, 661);
        howToPlayImage.setVisible(false);
		
		//Setting up GameFrame
		gameFrame = new GameFrame();
		gameFrame.setVisible(false);
		
		//Adding everything to Menu frame
		Container c = getContentPane();
		c.add(start);
		c.add(howToPlay);
		c.add(title);
		c.add(howToPlayTitle);
		c.add(howToPlayImage);
		c.add(home);
        c.setLayout(null);
		c.setBackground(Color.decode("#121213"));
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
	}

	//Helper method to display the game
	public void displayGame() {
		this.setVisible(false);
		gameFrame.setVisible(true);
	}
	
	//Helper method to display the rules
	public void displayRules() {
		title.setVisible(false);
		start.setVisible(false);
		howToPlay.setVisible(false);
		
		howToPlayTitle.setVisible(true);
		howToPlayImage.setVisible(true);
        home.setVisible(true);
	}
	
	//Helper method to display the home screen
	public void displayHome() {
		title.setVisible(true);
		start.setVisible(true);
		howToPlay.setVisible(true);
		
		howToPlayTitle.setVisible(false);
		howToPlayImage.setVisible(false);
        home.setVisible(false);
	}
	
	//Method that checks if a button has been pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		//If the start button has been pressed, display the gameFrame
		if (e.getSource() == start) {
			displayGame();
		}
		
		//If the how to play button has been pressed, display the rules of the game
		if (e.getSource() == howToPlay) {
			displayRules();
		}
		
		//If the home button has been pressed, display the home screen
		if (e.getSource() == home) {
			displayHome();
		}
	}
}
