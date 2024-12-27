import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class HighScore {

	private static final String fileName = "highscores.txt";
	private static List<HighScore> scores = new ArrayList<>();
    private static final int MAX_HIGH_SCORES = 10;

	private  String name;
    private  int score;
    
    public HighScore(String name, int score) {
    	this.name = name;
    	this.score = score;
    	
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

	

    public static List<HighScore> Scores() {
        List<HighScore> highScores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int score = Integer.parseInt(parts[1].trim());
                    highScores.add(new HighScore(name, score));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        scores = highScores;
		return highScores;
    }
	
	public void saveScore(int score, String name) {

		if (scores.size() > MAX_HIGH_SCORES) {
            scores = scores.subList(0, MAX_HIGH_SCORES);
        }
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(name + " , " + score);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
