import java.awt.*;   
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.*;
/*
 * @date November 2021
 * @author Jonathan Zhu
 */
public class GameFrame extends JFrame implements ActionListener{
	//Initiate variables
	public static GamePanel gamePanel;
	private JTextArea moneyTitle, chipCounterTitle;
	private static JTextArea reward1, reward2, reward3, reward4, reward5, reward6, reward7, reward8, reward9;
	public static JTextArea chipCounter, money, endText;
	public static JButton exit, playAgain;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameFrame();
	}
	//Constructor
	public GameFrame(){
		//Sets title at the top of the JFrame
		super("PLINKO!");
		//Sets the size of the JFrame
		setSize(800, 600);
		
		//Creates an instance of the GamePanel class
		gamePanel = new GamePanel();
		
		//Setting up the title for the winnings text box
		moneyTitle = new JTextArea("Winnings:");
		moneyTitle.setBounds(670, 10, 140, 35);
		moneyTitle.setBackground(Color.decode("#66B2FF"));
		moneyTitle.setFont(new Font("Georgia", Font.PLAIN, 20));
		moneyTitle.setVisible(true);
		moneyTitle.setEditable(false);
        
		//Setting up the winnings text box
		money = new JTextArea("0");
		money.setBounds(670, 35, 130, 50);
		money.setBackground(Color.decode("#66B2FF"));
		money.setFont(new Font("Georgia", Font.PLAIN, 40));
		money.setVisible(true);
		money.setEditable(false);
		
		//Setting up title for chip counter
		chipCounterTitle = new JTextArea("Chip Counter:");
        chipCounterTitle.setBounds(10, 10, 125, 30);
        chipCounterTitle.setBackground(Color.decode("#66B2FF"));
        chipCounterTitle.setFont(new Font("Georgia", Font.PLAIN, 20));
        chipCounterTitle.setVisible(true);
        chipCounterTitle.setEditable(false);
        
        //Setting up chip counter which tallies the chips earned
        chipCounter = new JTextArea("");
        chipCounter.setBounds(60, 30, 110, 45);
        chipCounter.setBackground(Color.decode("#66B2FF"));
        chipCounter.setFont(new Font("Georgia", Font.PLAIN, 40));
        chipCounter.setVisible(true);
        chipCounter.setEditable(false);
		
        //Setting up text box to display how much landing in each box will give
		reward1 = new JTextArea("500");
		reward1.setBounds(180+10, 510, 48, 30);
		reward1.setBackground(Color.decode("#66B2FF"));
		reward1.setFont(new Font("Georgia", Font.PLAIN, 20));
		reward1.setVisible(true);
		reward1.setEditable(false);
		
		reward2 = new JTextArea("100");
		reward2.setBounds(180+48+10, 510, 40, 30);
		reward2.setBackground(Color.decode("#66B2FF"));
		reward2.setFont(new Font("Georgia", Font.PLAIN, 20));
		reward2.setVisible(true);
		reward2.setEditable(false);
		
		reward3 = new JTextArea("1000");
		reward3.setBounds(180+2*48+5, 510, 48, 30);
		reward3.setBackground(Color.decode("#66B2FF"));
		reward3.setFont(new Font("Georgia", Font.PLAIN, 20));
		reward3.setVisible(true);
		reward3.setEditable(false);
		
		reward4 = new JTextArea("0");
		reward4.setBounds(180+3*48+20, 510, 20, 30);
		reward4.setBackground(Color.decode("#66B2FF"));
		reward4.setFont(new Font("Georgia", Font.PLAIN, 20));
		reward4.setVisible(true);
		reward4.setEditable(false);
		
		reward5 = new JTextArea("5000");
		reward5.setBounds(180+4*48+5, 510, 48, 30);
		reward5.setBackground(Color.decode("#66B2FF"));
		reward5.setFont(new Font("Georgia", Font.PLAIN, 20));
		reward5.setVisible(true);
		reward5.setEditable(false);
		
		reward6 = new JTextArea("0");
		reward6.setBounds(180+5*48+20, 510, 20, 30);
		reward6.setBackground(Color.decode("#66B2FF"));
		reward6.setFont(new Font("Georgia", Font.PLAIN, 20));
		reward6.setVisible(true);
		reward6.setEditable(false);
		
		reward7 = new JTextArea("1000");
		reward7.setBounds(180+6*48+5, 510, 48, 30);
		reward7.setBackground(Color.decode("#66B2FF"));
		reward7.setFont(new Font("Georgia", Font.PLAIN, 20));
		reward7.setVisible(true);
		reward7.setEditable(false);
		
		reward8 = new JTextArea("100");
		reward8.setBounds(180+7*48+10, 510, 40, 30);
		reward8.setBackground(Color.decode("#66B2FF"));
		reward8.setFont(new Font("Georgia", Font.PLAIN, 20));
		reward8.setVisible(true);
		reward8.setEditable(false);
		
		reward9 = new JTextArea("500");
		reward9.setBounds(180+8*48+5, 510, 48, 30);
		reward9.setBackground(Color.decode("#66B2FF"));
		reward9.setFont(new Font("Georgia", Font.PLAIN, 20));
		reward9.setVisible(true);
		reward9.setEditable(false);
		
		//Setting up exit button
		exit = new JButton("Exit Game");
		exit.setBounds(630, 500-70-20, 150, 50);
		exit.setBackground(Color.decode("#ffffff"));
		exit.setFont(new Font("Georgia", Font.PLAIN, 20));
		exit.setVisible(true);
		exit.setEnabled(false);
		exit.addActionListener(this);
        
		//Setting up play again button
        playAgain = new JButton("Play Again");
        playAgain.setBounds(630, 550-70-20, 150, 50);
        playAgain.setBackground(Color.decode("#ffffff"));
        playAgain.setFont(new Font("Georgia", Font.PLAIN, 20));
        playAgain.setVisible(true);
        playAgain.setEnabled(false);
        playAgain.addActionListener(this);
        
        endText = new JTextArea("");
        endText.setBounds(230, 250, 500, 100);
        endText.setFont(new Font("IMPACT", Font.BOLD, 50));
        endText.setBackground(Color.decode("#66B2FF"));
        endText.setEditable(false);
        endText.setVisible(false);
        
        //Add all elements to the GameFrame(JFrame)
		Container c = getContentPane();
        c.setLayout(null);
		c.setBackground(Color.decode("#66B2FF"));
		c.add(endText);
        c.add(gamePanel);
        c.add(money);
        c.add(moneyTitle);
        c.add(reward1);
        c.add(reward2);
        c.add(reward3);
        c.add(reward4);
        c.add(reward5);
        c.add(reward6);
        c.add(reward7);
        c.add(reward8);
        c.add(reward9);
        c.add(chipCounter);
        c.add(chipCounterTitle);
        c.add(exit);
        c.add(playAgain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
	}
	//Calling this method will set the text for the endText text box
	public static void setEndText() {
		String[] text1000 = {"Well Done!", "Awesome!"};
		String[] text3000 = {"YOU GOT IT!", "It's the bonus prize!"};
		String[] text5000 = {"YES! It is a ", "Light It Up!", "Nice job!", "YOU GOT IT!"};
		String[] textLarger5000 = {"A New Car!", "A New House!", "STRIKE!", "YOU WIN!"};
		if (Integer.parseInt(money.getText()) <= 100) {
			endText.setText("Better Luck Next Time!");
		}else if (Integer.parseInt(money.getText()) <= 1000) {
			int rand = randomNumber(0, 1);
			endText.setText(text1000[rand]);
		}else if (Integer.parseInt(money.getText()) <= 3000) {
			int rand = randomNumber(0, 1);
			endText.setText(text3000[rand]);
		}else if (Integer.parseInt(money.getText()) <= 5000) {
			int rand = randomNumber(0, 3);
			endText.setText(text5000[rand]);
		}else {
			int rand = randomNumber(0, 3);
			endText.setText(textLarger5000[rand]);
		}
	}
	//Calling this method generates a random number between the min and the max (inclusive)
	public static int randomNumber(int min, int max) {
		return (int)Math.floor((max+1-min)*Math.random()+min);
	}
	//Sets up end screen for when all balls have fallen
	public static void setUpEndScreen() {
		setEndText();
		endText.setVisible(true);
		gamePanel.setVisible(false);
		reward1.setVisible(false);
		reward2.setVisible(false);
		reward3.setVisible(false);
		reward4.setVisible(false);
		reward5.setVisible(false);
		reward6.setVisible(false);
		reward7.setVisible(false);
		reward8.setVisible(false);
		reward9.setVisible(false);
		exit.setEnabled(true);
		playAgain.setEnabled(true);
	}
	
	
	//Action listener
	@Override
	public void actionPerformed(ActionEvent e) {
		//Action listener for when the exit button is pressed
		if (e.getSource() == exit) {
			//Retrieved from https://stackoverflow.com/questions/1234912/how-to-programmatically-close-a-jframe/1235994
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
		//Action listener for when the play again button is pressed
		if(e.getSource() == playAgain) {
			try {
				//Creates new menu
				new Menu();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			playAgain.setEnabled(false);
			exit.setEnabled(false);
			setVisible(false);
		}	
	}
}
