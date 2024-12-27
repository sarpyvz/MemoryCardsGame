import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Card extends JButton {
    ImageIcon frontImage;
    ImageIcon backImage;
    private boolean isFlipped;
    
    
    
    public Card(ImageIcon frontImage, ImageIcon backImage) {
        this.frontImage = frontImage;
        this.backImage = backImage;
        this.isFlipped = false;
        setIcon(backImage);
//        addActionListener(e -> flip());
    }

    public void flip() {
        if (isFlipped) {
            setIcon(backImage);
        } else {
            setIcon(frontImage);
        }
        isFlipped = !isFlipped;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public boolean matches(Card other) {
        return this.frontImage.equals(other.frontImage);
    }

    public void reset() {
        if (isFlipped) {
            flip();
        }
    }
    
//    public ArrayList<Card> createCards(int level){
//    	ArrayList<Card> cards = new ArrayList<Card>();
//    	if (level == 1) {
//    		for (String path : levelOnePaths) {
//    			ImageIcon back = new ImageIcon("img/Level1/0.png");
//    			ImageIcon front = new ImageIcon(path);
//
//    			cards.add(new Card(front,back));
//    			cards.add(new Card(front,back));
//
//    		}
//    	}
//    	else if (level == 2) {
//    		for (String path : levelTwoPaths) {
//    			ImageIcon back = new ImageIcon("img/Level2/0.png");
//    			ImageIcon front = new ImageIcon(path);
//
//    			cards.add(new Card(front,back));
//    			cards.add(new Card(front,back));
//
//    		}
//    	}
//    	else if (level == 3 ) {
//    		for (String path : levelThreePaths) {
//    			ImageIcon back = new ImageIcon("img/Level3/0.png");
//    			ImageIcon front = new ImageIcon(path);
//
//    			cards.add(new Card(front,back));
//    			cards.add(new Card(front,back));
//    			
//    		}
//    	}    	
//		return cards;
//
//    }
    
}












