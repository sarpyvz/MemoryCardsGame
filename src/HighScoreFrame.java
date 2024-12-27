import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HighScoreFrame extends JFrame{

	
	public static JTextArea scoreArea;
	public HighScoreFrame() {
        List<HighScore> highScores = HighScore.Scores();
        
        JFrame frame =  new JFrame();
        
		setTitle("High Scores");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		scoreArea = new JTextArea();
		
		for (HighScore highScore : highScores) {
            scoreArea.append(highScore.getName() + " : " + highScore.getScore() + "\n");
        }
		
		JScrollPane scrollPane = new JScrollPane(scoreArea);

		scoreArea.setEditable(false); 
		scoreArea.setVisible(true);
		add(scrollPane);
		setVisible(true);
        frame.setLocationRelativeTo(null); // Center the frame

	}
}
