package week1;
import edu.duke.*;
import java.util.Arrays;

public class WordLengths {
	//
	 static void countWordLengths(FileResource resource, int[] counts){
	        //If word has a non-letter as the first or last character,
	        //it should not be counted as part of the word length
	        for(String word : resource.words()) {
	            //checks if the first character is non-letter
	            if(!Character.isLetter(word.charAt(0))) {
	                word = word.substring(1, word.length());
	            }
	            //checks if the last character is non-letter
	            if(!Character.isLetter(word.charAt(word.length() - 1))) {
	                word = word.substring(0, word.length() - 1);
	                //length--;
	            }
	            //creates an integer
	            int length = word.length();
	            System.out.println(length + " " + word);
	            counts[length] += 1;
	        }
	        //System.out.println(Arrays.toString(counts));
	        System.out.println("index of largest element: " + indexOfMax(counts));
	    }
	    
	    static int indexOfMax(int[] values) {
	        int index = 0;
	        for(int i = 0; i < values.length; i++){
	            if(values[i] > values[index]) {
	                index = i;
	            }
	        }
	        return index;
	    }
	 // Length of the biggest word, not the number of words.
	    public static int countWords(FileResource fr) {
	        int longest = 0;
	        for(String word : fr.words()) {
	            if(word.length() > longest) {
	                longest = word.length();
	            }
	        }
	        return longest + 1;
	    }
	    
	    static void testCountWordLengths() {
	       
            FileResource fr = new FileResource();
            String words = fr.asString();
            //makes an array of integers with the size of the number of words
            int[] counts = new int[countWords(fr)];
            //System.out.println(counts.length);
            countWordLengths(fr, counts);
	        	
	        
	    }
	    public static void main(String [] args) {
	    	testCountWordLengths();
	    }
}
