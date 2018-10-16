package week1;
import edu.duke.*;

public class WordPlay {
	 public static boolean isVowel(char ch) {
	        String vowels = "aeiouAEIOU";
	          for(int i = 0; i < vowels.length(); i++) {
	            if(vowels.charAt(i) == ch) {
	                return true;
	            }
	          }
	        return false;
	    }
	 
	 public static void testIsVowel() {
	        System.out.println(isVowel('a'));
	        System.out.println(isVowel('U'));
	        System.out.println(isVowel('F'));
	    }
	 
	 public static String replaceVowels(String phrase, char ch) {
		 StringBuilder newPhrase = new StringBuilder(phrase);
		   for(int i = 0; i < newPhrase.length(); i++) {
	            if(isVowel(newPhrase.charAt(i))) {
	                newPhrase.setCharAt(i, ch);
	            }
	        }
	        return newPhrase.toString();
		 
	 }
	 
	 public static void testReplaceVowels() {
	        System.out.println(replaceVowels("Hello World", '*'));
	    }
	 
	 public static String emphasize(String phrase, char ch) {
		 StringBuilder newPhrase = new StringBuilder(phrase);
		 int pointer = 0;
	     int index = phrase.indexOf(ch, pointer);
	            for(int i = 0; i < newPhrase.length(); i++) {
	            int remainder = (index + 1) % 2;
	            char currChar = newPhrase.charAt(i);
	            if(remainder == 0 && Character.toLowerCase(currChar) == Character.toLowerCase(ch)) {
	                newPhrase.setCharAt(i, '+');
	            } else if(remainder == 1 && Character.toLowerCase(currChar) == Character.toLowerCase(ch)){
	                newPhrase.setCharAt(i, '*');
	            }
	            pointer++;
	            index = phrase.indexOf(ch, pointer);
	        }
		 
		return newPhrase.toString();
	 }

	 public static void testEmphasize() {
	        System.out.println(emphasize("dna ctgaaactga", 'a')); //dn* ctg+*+ctg+
	        System.out.println(emphasize("Mary Bella Abracadabra", 'a')); //M+ry Bell+ +br*c*d*br+
	        System.out.println(emphasize("AbraCAdaBRaSisBumbA", 'A')); //*br+C+d+BR*SisBumb*
	    }
	 
	 public static void main(String [] args) {
		 testEmphasize();
	 }
}
