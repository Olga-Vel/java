package week1;
import edu.duke.*;

public class CaesarCipher {
	
	public static String encrypt(String input, int key){
		StringBuilder encrypted = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
		
		for (int i =0; i < encrypted.length(); i++){
			char currChar = encrypted.charAt(i);
			char tempChar = Character.toUpperCase(currChar);
			int index = alphabet.indexOf(tempChar);
					
			if(index != -1){
				char newChar = shiftedAlphabet.charAt(index);
					if(Character.isLowerCase(currChar)) {
						encrypted.setCharAt(i, Character.toLowerCase(newChar));
					} else {
						encrypted.setCharAt(i, newChar);
                }
			}
		}
		return encrypted.toString();
	}
	public static String encryptTwoKeys(String input, int key1, int key2){
		StringBuilder encrypted = new StringBuilder(input);
        String f = "";
        char x;
        for(int i = 0; i < encrypted.length(); i++) {
            if(i % 2 == 0) {
                f = encrypt(String.valueOf(encrypted.charAt(i)), key1);
                //convert string to character
                x = f.charAt(0);
                encrypted.setCharAt(i, x);
            } else {
                f = encrypt(String.valueOf(encrypted.charAt(i)), key2);
                x = f.charAt(0);
                encrypted.setCharAt(i, x);
            }
        }
        return encrypted.toString();
	}
	
	public static void testCaesar(){
		int key = 15;
		FileResource fr = new FileResource();
		String message = fr.asString();
		String encrypted = encrypt(message, key);
		System.out.println("key is " + key + "\n" + encrypted);
	 }
	
	public static void testEncryptTwoKeys() {
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
        //System.out.println(encryptTwoKeys("FIRST LEGION", 23, 17));
        //System.out.println(encryptTwoKeys("First Legion", 17, 23));
        int key1 = 21;
        int key2 = 8;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println("keys are " + key1 + " and " + key2 + "\n" + encrypted);
    }
	public static void main(String [] args) {
		System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
		System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
	}
}