import java.awt.Color;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;


public class Game {
    private int levelIndex;
    private Card first = null;
    private Card second = null;
    private Timer flipBackTimer;
    private Level currentLevel;
    ArrayList<Card> Cards;
    private JPanel gamePanel;
    private int triesLeft;
    private JLabel tryLabel;
    private JLabel levelLabel;
    private JPanel infoPanel;
    private int playerScore = 0;
    private HighScore highScore;
    private JFrame gameFrame;
    
    public Game(int levelIndex, JPanel gamePanel, JLabel tryLabel,JLabel levelLabel , JPanel infoPanel,JFrame gameFrame) {
    	this.gamePanel = gamePanel;
    	this.levelIndex = levelIndex;
    	this.tryLabel = tryLabel;
    	this.levelLabel = levelLabel;
    	this.infoPanel = infoPanel;
    	this.gameFrame = gameFrame;
//        currentLevel = new Level(18,levelIndex);
//        ArrayList<Card> Cards = currentLevel.createCards(levelIndex);
//    	Collections.shuffle(Cards);
//    	components = gamePanel.getComponents();
//        for (Card card : Cards) {
//        	gamePanel.add(card);
//        	card.addActionListener(e -> handleClick(card));
//        }
        startGame(levelIndex);


    }
    	
   

	public void startGame(int levelIndex) {
		gamePanel.removeAll();
    	currentLevel = new Level(-3*levelIndex + 21 ,levelIndex);
        Cards = currentLevel.createCards(levelIndex);
    	triesLeft = currentLevel.getTriesLeft();
    	tryLabel.setText("Tries : " + triesLeft);
    	levelLabel.setText("Level " + levelIndex+ "     ");
    	infoPanel.setBackground(new Color(128, 0, 128));
    	infoPanel.setBackground(levelIndex == 2 ? new Color(128, 0, 128) : (levelIndex == 3 ? Color.RED : Color.BLUE));
    	
    	Collections.shuffle(Cards);
    	for (Card card : Cards) {
        	gamePanel.add(card);
        	card.addActionListener(e -> handleClick(card));
        }
//    	components = gamePanel.getComponents();

    	 gamePanel.revalidate();
         gamePanel.repaint();

    }
    
    
    public void handleClick(Card card) {
    	if (card.isFlipped()) {
    		return;
    	}
    	
    	card.flip();
    	if (first == null) {
    		first = card;
   		}
   		else if (second == null) {
   			second = card;
   			checkMatch();
    	}
    	
    	
    }
    
    
    public void checkMatch() {
    	if(first.matches(second)) {
    		
    		int points = switch (levelIndex) {
            case 1 -> 5;
            case 2 -> 4;
            case 3 -> 3;
            default -> 0;
    		};
    		
            playerScore += points;

    		
    		first = null;
    		second = null;
    		/// YERİ AŞAĞI GELEBİLİR
    		if(levelCompleted()) {

    			levelIndex++;
                JOptionPane.showMessageDialog(null, "Congrats You won!");
                startGame(levelIndex);
    		}
    	}
    	else {
    		
    		int penalty = switch (levelIndex) {
            	case 1 -> 1;
            	case 2 -> 2;
            	case 3 -> 3;
            	default -> throw new IllegalArgumentException("Unexpected value: " + levelIndex);
    		};
        
        	playerScore -= penalty;
        	
        	triesLeft--;
        	tryLabel.setText("Tries : " + triesLeft);

    		flipBackTimer = new Timer(300, (ActionListener) new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				first.flip();
                    second.flip();
                    first = null;
                    second = null;
                    flipBackTimer.stop();
                    if (levelIndex == 3) { // Check if we are in Level 3
                        shuffleCloseCards();
                    }
    			}
            });
            flipBackTimer.setRepeats(false);
    		flipBackTimer.start();
    		
    		
    		
    	}
    	
  //    	currentLevel.setTriesLeft(triesLeft);
    	if (triesLeft == 0) {
    		
            JOptionPane.showMessageDialog(null, " You lost, try again!");
			String name = JOptionPane.showInputDialog("Username for highscores");
			HighScore highScore = new HighScore(name,playerScore);
			highScore.saveScore(playerScore, name);
            
            currentLevel = new Level(-3*levelIndex + 21 -3,levelIndex);
            try {
            	gameFrame.dispose();
				MainMenu newMenu = new MainMenu();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //System.exit(0);
    	}
    
    }
    
    public void shuffleCloseCards() {
        ArrayList<Card> closeCards = new ArrayList<>();
        ArrayList<Card> flippedCards = new ArrayList<>();
        
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (Card card : Cards) {
                    if (!card.isFlipped()) {
                        closeCards.add(card);
                    }
                    else {
                    	flippedCards.add(card);
                    }
                }
                Collections.shuffle(closeCards);
                return null;
            }

            @Override
            protected void done() {
                gamePanel.removeAll();
                int flippedIndex = 0;
                int nonFlippedIndex = 0;

                for (Card card : Cards) {
                    if (card.isFlipped()) {
                        gamePanel.add(flippedCards.get(flippedIndex++));
                    } else {
                        gamePanel.add(closeCards.get(nonFlippedIndex++));
                    }
                }
//                for (Card card : closeCards) {
//                    gamePanel.add(card);
//                    card.addActionListener(e -> handleClick(card));
//                }
                gamePanel.revalidate();
                gamePanel.repaint();
            }
        };

        worker.execute();
    }
    
    public int getTriesLeft() {
		return triesLeft;
	}



	public void setTriesLeft(int triesLeft) {
		this.triesLeft = triesLeft;
	}



	public boolean levelCompleted() {
    	int count = 0;
    	for (Card card : Cards) {
    		if( (card).isFlipped()) {
    			count++;
    		}
    	}
    	if (count == 16) {
    		return true;
    	}
    	return false;
    }
    
    public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}
}


