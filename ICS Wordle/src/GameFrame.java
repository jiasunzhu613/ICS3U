import java.awt.*;       
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
/*
 * @date March 2022
 * @author Jonathan Zhu
 */
public class GameFrame extends JFrame {
	// Initiate variables
	public static GamePanel gamePanel;
	
	//Constructor
	public GameFrame() {
		//Title of the frame
		super("WORDLE");
		
		//Creates an instance of the GamePanel class
		gamePanel = new GamePanel();
		
		//Add all elements to the GameFrame
		Container c = getContentPane();
		c.add(gamePanel);
        c.setLayout(null);
		c.setBackground(Color.decode("#121213"));
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
	}
}
