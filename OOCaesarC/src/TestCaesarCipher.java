import edu.duke.FileResource;

public class TestCaesarCipher {
	static String message;
	 public static int[] countLetters(String encrypt) {
	        String alphabet = "abcdefghijklmnopqrstuvwxyz";
	        int[] counts = new int[26];
	        for(int i = 0; i < encrypt.length(); i++) {
	            char ch = Character.toLowerCase(encrypt.charAt(i));
	            int dex = alphabet.indexOf(ch);
	            if(dex != - 1) {
	                counts[dex] += 1;
	            }
	        }
	        return counts;
	    }
	    
	    public static int maxIndex(int[] freqs) {
	        int maxDex = 0;
	        for(int i = 0; i < freqs.length; i++) {
	            if(freqs[i] > freqs[maxDex]) {
	                maxDex = i;
	            }
	        }
	        return maxDex;
	    }
	    
	    //This method should read in a file as a String, create a CaesarCipher object with key 18, 
	    //encrypt the String read in using the CaesarCipher object, print the encrypted String, 
	    //and decrypt the encrypted String using the decrypt method.


	    //This method should figure out which key was used to encrypt this message 
	    //(in a similar manner as the previous lesson), 
	    //then create a CaesarCipher object with that key and decrypt the message.
	    public static void breakCaesarCipher(String input){
	    	 int[] freqs = countLetters(input);
	         int key = maxIndex(freqs);
	         System.out.println("Calculated key:");
	         System.out.println(key);
	         CaesarCipher cc = new CaesarCipher(key);
	         String decrypted = cc.decrypt(input);
	         System.out.println("Decrypted message:");
	         System.out.println(decrypted);
	    	
	    }
	    static void simpleTests() {
	        //FileResource fr = new FileResource();
	        message = "iojtybrtibbrthbxtirthbbrthircnhcriyiiioi4ffstriii";
	        System.out.println("Message:");
	        System.out.println(message);
	        CaesarCipher cc = new CaesarCipher(18);
	        String encrypted = cc.encrypt(message);
	        System.out.println("Encrypted message:");
	        System.out.println(encrypted);
	        String decrypted = cc.decrypt(encrypted);
	        System.out.println(decrypted);        
	    }
	    public static void main(String [] args) {
	    	simpleTests(); 
	    	breakCaesarCipher(message);
		}
	
}
