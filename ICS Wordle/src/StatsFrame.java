import java.awt.*;      
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;
/*
 * @date March 2022
 * @author Jonathan Zhu
 */
public class StatsFrame extends JFrame implements ActionListener{
	// Initiate variables
	public StatsPanel statsPanel;
	private JButton playAgain, exit;
	
	//Constructor
	public StatsFrame() {
		//Set title of the frame
		super("WORDLE Statistics");
		
		//Creates an instance of the StatsPanel class
		statsPanel = new StatsPanel();
		
		//Setting up play again button
		playAgain = new JButton("Play Again");
		playAgain.setBounds(50, 480, 150, 50);
		playAgain.addActionListener(this);
		playAgain.setFocusable(false);
		playAgain.setForeground(Color.decode("#538e4e"));
		playAgain.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		playAgain.setVisible(true);
		
		//Setting up exit button
		exit = new JButton("Exit");
		exit.setBounds(400, 480, 150, 50);
		exit.addActionListener(this);
		exit.setFocusable(false);
		exit.setForeground(Color.decode("#538e4e"));
		exit.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		exit.setVisible(true);
		
		//Adding everything to the StatsFrame
		Container c = getContentPane();
		c.add(statsPanel);
		c.add(playAgain);
		c.add(exit);
        c.setLayout(null);
		c.setBackground(Color.decode("#363836"));
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
	}
	
	//Method that checks if a button has been pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		//If the play again button has been pressed, reset the board
		if (e.getSource() == playAgain) {
			GamePanel.reset();
		}
		
		//If the exit button has been pressed, exit all windows
		if (e.getSource() == exit) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}

