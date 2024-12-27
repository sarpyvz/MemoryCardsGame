import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

public class Level {
	
	private int triesLeft;
	private ImageIcon frontImg;
	private ImageIcon backImg;
	private int level;
	public Level[] levels;

	
	String[] levelOnePaths = new String[]{
	    	"img/Level1/0.png",
	    	"img/Level1/1.png",
	    	"img/Level1/2.png",
	    	"img/Level1/3.png",
	    	"img/Level1/4.png",
	    	"img/Level1/5.png",
	    	"img/Level1/6.png",
	    	"img/Level1/7.png",
	    	"img/Level1/8.png",    	
	    };
	    
	    String[] levelTwoPaths = new String[]{
	        	"img/Level2/0.png",
	        	"img/Level2/1.png",
	        	"img/Level2/2.png",
	        	"img/Level2/3.png",
	        	"img/Level2/4.png",
	        	"img/Level2/5.png",
	        	"img/Level2/6.png",
	        	"img/Level2/7.png",
	        	"img/Level2/8.png",    	
	        };
	    
	    String[] levelThreePaths = new String[]{
	        	"img/Level3/0.png",
	        	"img/Level3/1.png",
	        	"img/Level3/2.png",
	        	"img/Level3/3.png",
	        	"img/Level3/4.png",
	        	"img/Level3/5.png",
	        	"img/Level3/6.png",
	        	"img/Level3/7.png",
	        	"img/Level3/8.png",    	
	        };
	
	public Level(int triesLeft, int lvl) {
		this.setTriesLeft(triesLeft);
		this.setLevel(lvl);

	}
	
	public ArrayList<Card> createCards(int level){
    	ArrayList<Card> cards = new ArrayList<Card>();
    	if (level == 1) {
        	List<String> paths = Arrays.asList(levelOnePaths);
        	Collections.shuffle(paths);
    		for (int i = 0; i <8; i++) {

    			ImageIcon back = new ImageIcon("img/Level1/no_image.png");
    			ImageIcon front = new ImageIcon(paths.get(i));

    			cards.add(new Card(front,back));
    			cards.add(new Card(front,back));
    		}
    	}
    	else if (level == 2) {
        	List<String> paths = Arrays.asList(levelTwoPaths);
        	Collections.shuffle(paths);
    		for (int i = 0; i < 8; i++) {
    			ImageIcon back = new ImageIcon("img/Level2/no_image.png");
    			ImageIcon front = new ImageIcon(paths.get(i));

    			cards.add(new Card(front,back));
    			cards.add(new Card(front,back));
    		}
    	}
    	else if (level == 3 ) {
    		List<String> paths = Arrays.asList(levelThreePaths);
        	Collections.shuffle(paths);
    		for (int i = 0; i< 8; i++) {
    			ImageIcon back = new ImageIcon("img/Level3/no_image.png");
    			ImageIcon front = new ImageIcon(paths.get(i));

    			cards.add(new Card(front,back));
    			cards.add(new Card(front,back));

    		}
    	}    	
		return cards;

    }

	public int getTriesLeft() {
		return triesLeft;
	}

	public void setTriesLeft(int triesLeft) {
		this.triesLeft = triesLeft;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
    
}