import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreqs;
	
	public WordFrequencies() {
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
	}
	public void findUnique() {
		myWords.clear();
        myFreqs.clear();
		FileResource resource = new FileResource();
		
		for (String word : resource.words()) {
			word = word.toLowerCase();
			int index = myWords.indexOf(word);
			if(index==-1) {
				myWords.add(word);
				myFreqs.add(1);
				
			}
			else {
				int value = myFreqs.get(index);
				myFreqs.set(index,value+1);
			}
		}
	}

	public int findIndexOfMax() {
	     int max = myFreqs.get(0);
	        int maxIndex = 0;
	        for(int i = 0; i < myFreqs.size(); i++) {
	            if(myFreqs.get(i) > max) {
	                max = myFreqs.get(i);
	                maxIndex = i;
	            }
	        }
		return maxIndex;
	}

    
	public void tester() {
		findUnique();
		System.out.println("Number of unique words: "+myWords.size());
		for(int k=0; k < myWords.size(); k++) {
		System.out.println(myFreqs.get(k) + "\t" +myWords.get(k));
		}
		int maxIndex = findIndexOfMax();
		System.out.println("The word that occurs most often and its count are: " + 
                        myWords.get(maxIndex) + " " + myFreqs.get(maxIndex));
	}
	public static void main(String [] args) {
		WordFrequencies wf = new WordFrequencies();
		wf.tester(); 
    }
}
