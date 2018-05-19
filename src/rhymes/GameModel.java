package rhymes;
import java.util.ArrayList;

public class GameModel {

	private RhymingDictionary dic;
	private int score;
	private String givenWord;
	private ArrayList<String> choices;
	
	public GameModel(String filename) {	
		this.dic = new RhymingDictionary(filename);
		this.score =0;
		this.givenWord = dic.randomWord();
		this.choices = dic.getChoices(this.givenWord);
	}
	
	public void makeChoice(String str) {
		System.out.println("make choice !");
		if(dic.isRhyme(str, this.givenWord)) {
			this.score+=1;
			this.givenWord = dic.randomWord();
			this.choices = dic.getChoices(this.givenWord);
		}else {
			this.score-=1;
			this.givenWord = dic.randomWord();
			this.choices = dic.getChoices(this.givenWord);
		}
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getGivenWord() {
		return givenWord;
	}

	public void setGivenWord(String givenWord) {
		this.givenWord = givenWord;
	}

	public ArrayList<String> getChoices() {
		return this.choices;
	}	
	
	
}
