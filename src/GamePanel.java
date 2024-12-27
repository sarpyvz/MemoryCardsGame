import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
public class GamePanel extends JPanel {
	


	public GamePanel(int level){
		
		//Level level = new Level();
	    JMenuBar menuBar = new JMenuBar();
		JFrame frame = new JFrame();

		JPanel comboPanel = new JPanel();
        JMenu gameMenu = new JMenu ("Game");
        
        //TOP MENU---------------------------------
        JMenuItem restart = new JMenuItem ("Restart");
        gameMenu.add (restart);
        JMenuItem highScores = new JMenuItem ("High Scores");
        gameMenu.add(highScores);
        menuBar.add(gameMenu);
        JMenu aboutMenu = new JMenu ("About");
        JMenuItem aboutTheDeev = new JMenuItem ("About The Developer");
        aboutTheDeev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Sarp Yavuz 20220702064", "About The Developer", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        aboutMenu.add(aboutTheDeev);
        JMenuItem aboutTheGame = new JMenuItem ("About The Game");
        aboutTheGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Memory Cards Game There are 3 leves and each level has its own tries count and images.", "About The Game", JOptionPane.INFORMATION_MESSAGE);

            }
        });

        highScores.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HighScoreFrame highscorewindow = new HighScoreFrame();
			}
        	
        });
        aboutMenu.add(aboutTheGame);
        menuBar.add(aboutMenu);
        JMenu exit = new JMenu("Exit");
        JMenuItem exitItem = new JMenuItem("Exit");
       
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the action event here
                System.exit(0);
            	try {
					MainMenu newMenu = new MainMenu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        
      
        exit.add(exitItem);
        menuBar.add(exit);
        ///_----------------------------------______________---
        
        
//        JPanel gamePanel = new JPanel(new GridLayout(4,4));
//        Game game = new Game(1,gamePanel,triesLabel);
        
        //-------------------------------------
        JPanel infoPanel = new JPanel(new FlowLayout());
        //infoPanel.setLayout(new GridLayout(1, 2));
        
        JLabel triesLabel = new JLabel("Tries Left: ");
        JLabel levelLabel = new JLabel("Level:            ");
        
        JPanel gamePanel = new JPanel(new GridLayout(4,4));
        Game game = new Game(level,gamePanel,triesLabel,levelLabel, infoPanel,frame);
        
        triesLabel.setText("Tries Left: " + game.getTriesLeft() + "     ");
        triesLabel.setFont(new Font("Arial",Font.BOLD,30));
        triesLabel.setForeground(Color.WHITE); 
        levelLabel.setText("Level " + game.getCurrentLevel().getLevel()+ "    ");
        levelLabel.setForeground(Color.WHITE); 

        levelLabel.setFont(new Font("Arial",Font.BOLD,30));
        infoPanel.setBackground(Color.CYAN);

        infoPanel.add(levelLabel);
        infoPanel.add(triesLabel);

        
 

        restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		        Game game = new Game(1,gamePanel,triesLabel,levelLabel, infoPanel,frame);
				
			}
        	
        });

        
        
        //setLayout(new BorderLayout());
		frame.setLayout(new BorderLayout());

		infoPanel.add(levelLabel);
        infoPanel.add(triesLabel);

        frame.add(gamePanel,BorderLayout.SOUTH);
        frame.add(menuBar,BorderLayout.NORTH);

        frame.add(infoPanel,BorderLayout.CENTER);
        
		//frame.setLayout(new BorderLayout());
        frame.setSize(600, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);	

	}
	
}
