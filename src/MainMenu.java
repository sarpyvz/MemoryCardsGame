import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends JFrame {
	
	
	public MainMenu() throws IOException {
		
		JFrame frame = new JFrame("Memory Card Game");
		
		frame.setSize(700,500);
		
	
		
		
		//HEADER
        JLabel label = new JLabel("Memory Card Game");
        label.setBounds(180, 80, 300, 50);
        Font font = new Font("Arial", Font.PLAIN, 30);
        label.setFont(font);
        label.setForeground(Color.WHITE); 
        frame.add(label);
        
    
		
	   
        //background image
        ImagePanel panel = new ImagePanel("img/background.jpg");
      	panel.setLayout(null);
  		frame.getContentPane().add(panel);
      		
  		//buttons
      	JButton start = new JButton("Start Game");
        start.setBounds(260, 160, 120, 30); // x, y, width, height
      	JButton select = new JButton("Select Level");
        select.setBounds(260, 210, 120, 30); // x, y, width, height
      	JButton instruction = new JButton("Instructions");
        instruction.setBounds(260, 260, 120, 30);
      	JButton exit = new JButton("Exit");
        exit.setBounds(260, 310, 120, 30); // x, y, width, height     	
      	
        
        
        // IF START GAME BUTTON IS PRESSED
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	GamePanel gamepanel = new GamePanel(1);
            	frame.dispose();
            }
        });
        
        // IF SELECT LEVEL IS PRESSED
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame lvlFrame = new JFrame();
                JLabel selectLevel = new JLabel("Select Level:");
                selectLevel.setFont(new Font("Arial", Font.PLAIN, 20));
                JButton level1 = new JButton("Level 1");
                JButton level2 = new JButton("Level 2");
                JButton level3 = new JButton("Level 3");
                ImagePanel lvlPanel = new ImagePanel("img/background.jpg");
                lvlPanel.setLayout(null);

                
                level1.addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						GamePanel game = new GamePanel(1);
						lvlFrame.dispose();

					}
                	
                });

                level2.addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						GamePanel game = new GamePanel(2);
						lvlFrame.dispose();
					}
                	
                });
                
                level3.addActionListener( new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						GamePanel game = new GamePanel(3);
						lvlFrame.dispose();

					}
                	
                });
                lvlFrame.getContentPane().add(lvlPanel);
                level1.setBounds(150, 20, 100, 60);
                level2.setBounds(150, 110, 100, 60);
                level3.setBounds(150, 200, 100, 60);
                selectLevel.setBounds(0,0,150,100);

                
                lvlPanel.add(level1);
                lvlPanel.add(level2);
                lvlPanel.add(level3);
                lvlPanel.add(selectLevel);

                lvlFrame.setSize(400,300);
                lvlFrame.setVisible(true);
                frame.dispose();
                
            }
        });
        
      	
      	// IF INSTRUCTION BUTTON IS PRESSED
      	instruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	JOptionPane.showMessageDialog(frame, "Instructions: \nThere are 3 levels in game.\n It gets gradually harder! Match all pairs of cards to win!");
            }
        });
      	
      	
      	exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            	
            }
        });
      	
      	panel.add(exit);
      	panel.add(instruction);
        panel.add(select);
      	panel.add(start);
      	
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}


