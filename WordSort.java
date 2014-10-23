import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class  WordSort{
	
	public static void main(String[] args){

		if(args.length > 0){
			if(args[0].equals("-sensitive")){
				WordSort ws = new WordSort(true);
			}
		}

		else{
			WordSort ws = new WordSort(false);
		}

	}

	//public constructor
	public WordSort(boolean isSensitive){
		if(isSensitive){
			try{
				String[] s = alphabetize(seperateWords(input()));
				int[] i = wordCount(s);
				s = noRepeats(s);
				output(s,i);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		else{
			try{
				String[] s = alphabetize(upperCase(seperateWords(input())));
				int[] i = wordCount(s);
				s = noRepeats(s);
				output(s,i);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	/** Takes input and breaks it up into seperate lines. */
	public ArrayList input() throws java.io.IOException{
		ArrayList lineList = new ArrayList();
		java.io.BufferedReader stdIn = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String s = stdIn.readLine();
		while(s != null){
			lineList.add(lineList.size(), s);
			s = stdIn.readLine();
		}
		return lineList;
	}

	/** Breaks up lines into array of words. */
	public String[] seperateWords(ArrayList  lineList){
		ArrayList wordList = new ArrayList();
		String[] wordArray;
		for(int i = 0; i < lineList.size(); i++){
			String s = ""+lineList.get(i);
			s = s.replaceAll("[^\\w]", " ");
			String[] words = s.split("[\\s+]");
			for(int k = 0; k < words.length; k++){
				wordList.add(wordList.size(), words[k]);
			}
		}

		wordArray = new String[wordList.size()];
		for(int i = 0; i < wordArray.length; i++){
			wordArray[i] = ""+wordList.get(i);
		}
		return wordArray;
	}

	/** Changes all words to upper case. */
	public String[] upperCase(String[] wordArray){
		String[] wordsCapped = new String[wordArray.length];
		for(int i = 0; i < wordArray.length; i++){
			wordsCapped[i] = wordArray[i].toUpperCase();
		}
		return wordsCapped;
	}

	/** Alphabetizes all words. */
	public String[] alphabetize(String[] wordArray){
		String[] sortedWords = new String[wordArray.length];
		String tmp;
		for (int i = 0;i < wordArray.length;i++)
		{
  			tmp = wordArray[i];
  			for (int j = 0; j < wordArray.length; j++)
  			{
    			if (i == j) continue;
    			int x = tmp.compareToIgnoreCase(wordArray[j]);
    			if (x < 0){
      				tmp = wordArray[j];
      				wordArray[j] = wordArray[i];
      				wordArray[i] = tmp;
    			}
  			}
		}

		sortedWords = wordArray;
		return  sortedWords;
	}

	/** Tallies the words and organizes the frequencies into a corresponding array. */
	public int[] wordCount(String[] wordArray){
		String[] words = new String[wordArray.length];
		ArrayList wordCount = new ArrayList();
		wordCount.add(1);
		int j = 0;
		for(int i = 0; i < wordArray.length-1; i++){
			if(wordArray[i].equals(wordArray[i+1])){
				wordCount.set(j, (int)wordCount.get(j) + 1);
			}
			else{
				j++;
				wordCount.add(j, 1);
			}
		}
    	int[] tallyArray = new int[wordCount.size()];
    	for(int k = 0; k < wordCount.size(); k++){
    		tallyArray[k] = (int)wordCount.get(k);
    	}
    	return tallyArray;
	}

	/** Removes repeating words from the word array. */
	public String[] noRepeats(String[] wordArray){
		String[] noRepeats;
		ArrayList tempList = new ArrayList();
		for(int i = 0; i < wordArray.length; i++){
			tempList.add(tempList.size(), wordArray[i]);
		}
		for(int i = 0;  i < tempList.size()-1; i++){
			if(tempList.get(i).equals(tempList.get(i+1))){
				tempList.remove(i+1);
				i--;
			}
		}
		noRepeats = new String[tempList.size()];
		for(int i = 0; i < noRepeats.length; i++){
			noRepeats[i] = ""+tempList.get(i);
		}
		return noRepeats;
	}

	/** Prints out alphabetized word list with frequencies. */
	public void output(String[] wordArray, int[] wordCount){
		for(int i = 0; i < wordCount.length; i++){
			System.out.println(wordArray[i] + " : " + wordCount[i]);
		}
	}

}