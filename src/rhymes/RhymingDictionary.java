package rhymes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RhymingDictionary {

	@SuppressWarnings("unused")
	private String filename;
	private HashMap<String, String> wordToChars;
	private ArrayList<String> words;
	private ArrayList<String> chars;


	public RhymingDictionary(String filename) {
		this.filename = filename;
		this.words = new ArrayList<String>();
		this.wordToChars = new HashMap<String, String>();
		this.chars = new ArrayList<String>();
		try {
			for(String line:Files.readAllLines(Paths.get(filename))) {
				words.add(line.split("  ")[0]);
				chars.add(line.split("  ")[1]);
				wordToChars.put(line.split("  ")[0], line.split("  ")[1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isRhyme(String word,String word1) {
		ArrayList<String> firstPro = new ArrayList<String>();
		ArrayList<String> secPro = new ArrayList<String>();
		for(String s: wordToChars.get(word.toUpperCase()).split(" ")) {
			firstPro.add(s);
		}	
		for(String i: wordToChars.get(word1.toUpperCase()).split(" ")) {
			secPro.add(i);
		}

		Collections.reverse(firstPro);
		Collections.reverse(secPro);

		String firstCheck="";
		String secCheck="";
		for(int i=0;i<firstPro.size();i++) {
			if(isVowel(firstPro.get(i))) {
				firstCheck=firstCheck+firstPro.get(i).split("")[0] + firstPro.get(i).split("")[1];
				break;
			}else{
				firstCheck= firstCheck+firstPro.get(i);
			}
		}
		
		for(int i=0;i<secPro.size();i++) {
			if(isVowel(secPro.get(i))) {
				secCheck=secCheck+secPro.get(i).split("")[0] + secPro.get(i).split("")[1];
				break;
			}else{
				secCheck= secCheck+secPro.get(i);
			}
		}
		
		if(firstCheck.equals(secCheck)) {
			return true;
		}
		
		return false;
	}
	//Check if a string is a vowel 
	public boolean isVowel(String str) {

		String last = str.split("")[str.split("").length-1];
		if(last.equals("1") || last.equals("2") || last.equals("0")) {
			return true;
		}
		return false;
	}
	//check if to strings match 
	public boolean itMatch(String str, String str1) {
		if(str.equals(str1)) {
			return true;
		}
		return false;
	}
	//Check if two vowels match 
	public boolean vowelMatch(String str,String str1) {

		String first = str.split("")[0];
		String first1 = str1.split("")[0];
		String sec = str.split("")[1];
		String sec1 = str1.split("")[1];

		if(first.equals(first1) && sec.equals(sec1)) {
			return true;
		}
		return false;
	}
	//Get a random word
	public String randomWord() {
		Collections.shuffle(this.words);
		return this.words.get(0);
	}
	//Get choices to put in the buttons 
	public ArrayList<String> getChoices(String reference){
		ArrayList<String> choices = new ArrayList<String>();

		String rhymes =randomWord();
		String word=randomWord();
		String word1=randomWord();
		String word2=randomWord();

		while(!isRhyme(rhymes, reference) && !rhymes.equals(reference)) {
			rhymes = randomWord();
		}
		while(isRhyme(word, reference)) {
			word = randomWord();
		}
		while(isRhyme(word1, reference)) {
			word1 = randomWord();
		}
		while(isRhyme(word2, reference)) {
			word2 = randomWord();
		}
		choices.add(rhymes);
		choices.add(word);
		choices.add(word1);
		choices.add(word2);

		Collections.shuffle(choices);
		return choices;
	}

//	public static void main(String[] args) {
//		RhymingDictionary dic = new RhymingDictionary("src/rhymingDictionary.txt");
//
//		System.out.println(dic.isRhyme("MODEL","PURRPLE"));
//
//	}
}
