/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
	public static boolean twoOccurrences(String stringa, String stringb){
	    int occurance =  stringb.indexOf(stringa);
	    if(occurance == -1) //if the string doesnt occure
	        return false;
	    String secondpart = stringb.substring(occurance+stringa.length());//leftovers of the string from the occurance and on
	    if((occurance !=-1) && (secondpart.indexOf(stringa) ==-1))
	        return false;
	    return true;
	}
	
	public static String lastPart(String stringa, String stringb) {
		int occurance =  stringb.indexOf(stringa);
		if(occurance == -1) //if the string doesnt occure
			return stringb;
		return stringb.substring(occurance+stringa.length());
		
	}

	public static void testing(){
	    String stringa = "v";
	    String stringb = "Alice in Wonderland";
	    boolean result = twoOccurrences(stringa, stringb);
	    System.out.println("The result is " + result);
	    
	
		stringa = "Mat";
		stringb = "Hakuna Matata";
		result = twoOccurrences(stringa, stringb);
		System.out.println("The result is " + result);
		
		stringa = "ta";
		stringb = "Hakuna Matata";
		result = twoOccurrences(stringa, stringb);
		System.out.println("The result is " + result);
		
		stringa = "an";
		stringb = "banana";
		String result2 = lastPart(stringa, stringb);
		System.out.println("The result is " + result2);
		
		stringa = "zoo";
		stringb = "Forest";
		result2 = lastPart(stringa, stringb);
		System.out.println("The result is " + result2);
	}
	
	public static void main(String[] args) {
		testing();
	}
}