import java.util.Scanner;
import java.util.ArrayList;

/**
 *	Provides utilities for word games:
 *	1. finds all words in the dictionary that match a list of letters
 *	2. prints an array of words to the screen in tabular format
 *	3. finds the word from an array of words with the highest score
 *	4. calculates the score of a word according to a table
 *
 *	Uses the FileUtils and Prompt classes.
 *	
 *	@author Kate Baccash
 *	@since	10/18/2024
 */
public class WordUtilities
{
	private String[] words;		// the dictionary of words
	
	// File containing dictionary of almost 100,000 words.
	private final String WORD_FILE = "wordList.txt";
	
	/* Constructor */
	public WordUtilities() { }
	
	/**	Load all of the dictionary from a file into words array. */
	private void loadWords ()
	{
		Scanner input = FileUtils.openToRead(WORD_FILE);
		int count = 0;
		while(input.hasNext())
		{
			String line = input.next();
			count++;
		}
		words = new String[count];
		input.close();
		Scanner inFile = FileUtils.openToRead(WORD_FILE);		
		int counter = 0;
		while(inFile.hasNext())
		{
			words[counter] = inFile.next();
			counter++;
		}
		inFile.close();
	}
	
	/**	Find all words that can be formed by a list of letters.
	 *  @param letters	string containing list of letters
	 *  @return			array of strings with all words found.
	 */
	public String [] findAllWords (String letters)
	{
		Scanner input = FileUtils.openToRead(WORD_FILE);
		int count = 0;
		while(input.hasNext()) 
		{
			String word = input.next();
			if(isWordMatch(word, letters))
			{
				count++;
			}
		}
		String[] wordsWithLetters = new String[count];
		input.close();
		
		Scanner inFile = FileUtils.openToRead(WORD_FILE);
		int counter = 0;
		while(inFile.hasNext()) 
		{
			String word = inFile.next();
			if(isWordMatch(word, letters)) 
			{
				wordsWithLetters[counter] = word;
				counter++;
			}
		}
		return wordsWithLetters;
	}
	
	/**
	 *  Decides if a word matches a group of letters.
	 *
	 *  @param word  The word to test.
	 *  @param letters  A string of letters to compare
	 *  @return  true if the word matches the letters, false otherwise
	 */
	public boolean isWordMatch (String word, String letters) 
	{
		for(int a = 0; a < word.length(); a++) 
		{
			char c = word.charAt(a);
			if(letters.indexOf(c) > - 1)
				letters = letters.substring(0, letters.indexOf(c))
							+ letters.substring(letters.indexOf(c) + 1);
			else
				return false;
		}
		return true;
	}
	
	/**	Print the words found to the screen.
	 *  @param words	array containing the words to be printed
	 */
	public void printWords (String [] wordList) {
		final int numberOfColumns = 5;
		for(int i = 0; i < wordList.length; i++)
		{
			System.out.printf("%-15s", wordList[i]);
			if ((i + 1) % numberOfColumns == 0)
				System.out.println();
		}
	}
	
	/**	Finds the highest scoring word according to a score table.
	 *
	 *  @param word  		An array of words to check
	 *  @param scoreTable	An array of 26 integer scores in letter order
	 *  @return   			The word with the highest score
	 */
	public String bestWord (String [] wordList, int [] scoreTable)
	{
		String bestStr = "";
		for(String str : wordList)
		{
			if(getScore(str, scoreTable) > getScore(bestStr, scoreTable))
			{
				bestStr = str;
			}
			else if(getScore(str, scoreTable) == getScore(bestStr, scoreTable))
			{
				int randomNumber = (int)(Math.random() * 2);
				if(randomNumber == 0)
				{
					bestStr = str;
				}
			}
		}
		return bestStr;
	}
	
	/**	Calculates the score of one word according to a score table.
	 *
	 *  @param word			The word to score
	 *  @param scoreTable	An array of 26 integer scores in letter order
	 *  @return				The integer score of the word
	 */
	public int getScore (String word, int [] scoreTable)
	{
		int score = 0;
		for(int i = 0; i < word.length(); i++)
		{
			score += scoreTable[word.charAt(i) - 'a'];
		}
		return score;
	}
	
	/***************************************************************/
	/************************** Testing ****************************/
	/***************************************************************/
	public static void main (String [] args)
	{
		WordUtilities wu = new WordUtilities();
		wu.run();
	}
	
	public void run() 
	{
		System.out.println("\n\n");
		String letters = Prompt.getString("Please enter a list of letters, from 3 to 12 letters long, without spaces");
		loadWords();
		String [] word = findAllWords(letters.toLowerCase());
		System.out.println();
		printWords(word);
		
		// Score table in alphabetic order according to Scrabble
		int [] scoreTable = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
		String best = bestWord(word,scoreTable);
		System.out.println("\nHighest scoring word: " + best + "\nScore = " 
							+ getScore(best, scoreTable) + "\n");
	}
	
		/**
	 *	Determines if a word's characters match a group of letters
	 *	@param word		the word to check
	 *	@param letters	the letters
	 *	@return			true if the word's chars match; false otherwise
	 */
	private boolean wordMatch(String word, String letters) {
		// if the word is longer than letters return false
		if (word.length() > letters.length()) return false;
		
		// while there are still characters in word, check each word character
		// with letters
		while (word.length() > 0) {
			// using the first character in word, find the character's index inside letters
			// and ignore the case
			int index = letters.toLowerCase().indexOf(Character.toLowerCase(word.charAt(0)));
			// if the word character is not in letters, then return false
			if (index < 0) return false;
			
			// remove character from word and letters
			word = word.substring(1);
			letters = letters.substring(0, index) + letters.substring(index + 1);
		}
		// all word letters were found in letters
		return true;
	}
	
	/**
	 *	finds all words that match some or all of a group of alphabetic characters
	 *	Precondition: letters can only contain alphabetic characters a-z and A-Z
	 *	@param letters		group of alphabetic characters
	 *	@return				an ArrayList of all the words that match some or all
	 *						of the characters in letters
	 */
	public ArrayList<String> allWords(String letters) {
		ArrayList<String> wordsFound = new ArrayList<String>();
		// check each word in the database with the letters
		for (String word: words)
			if (wordMatch(word, letters))
				wordsFound.add(word);
		return wordsFound;
	}
	
	/**
	 *	Sort the words in the database
	 */
	public void sortWords() {
		SortMethods sm = new SortMethods();
		sm.mergeSort(words);
	}

}
