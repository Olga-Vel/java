import edu.duke.*;
public class WoldLengths2 {
	public static void countWordLengths(FileResource resource, int[] counts) {
	    
        final int countsLen = counts.length;
        
        for (String word : resource.words()) {
            int wordLen = Math.min(wordLength(word), countsLen);
            counts[wordLen]++;
           
        }
    
    }
    
    /**
     * Helper function for counting word length, ignoring non-letter chars
     * @param   word    string to be counted
     * @return  number of numeric characters in word
     */
    private static int wordLength(String word) {
        int len = 0;
        for (char ch : word.toCharArray()) if (Character.isLetter(ch)) len++;
        
        return len;
    }
    
    /**
     * This method returns the index position of the largest element in values.
     * @param   values  int array to be searched
     * @return  largest value int values array
     */
    public static int indexOfMax(int[] values) {
        int indOfMax = 0;
        int maxSoFar = values[0];
        
        for (int i=1;i<values.length;i++){
        
            if (values[i]>maxSoFar) {
                maxSoFar = values[i];
                indOfMax = i;
            }
        }
        
        return indOfMax;
    }
    
    /**
     * Testing countWordLengths method.
     */
    public static void testCountWordLengths() {
    int[] counts = new int[31];
    FileResource fr = new FileResource();
    
    countWordLengths(fr, counts);
    
    for (int i=1; i<counts.length; i++) {
        System.out.printf("%d:\t%d\n", i, counts[i]);
    }
    
    System.out.println("Largest value in array: " + indexOfMax(counts));

    }
    public static void main(String [] args) {
    	testCountWordLengths();
    }
}
