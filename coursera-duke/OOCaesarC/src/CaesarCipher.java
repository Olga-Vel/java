

public class CaesarCipher {
	private static String alphabet;
	private static String shiftedAlphabet;
	private int mainKey;
	public CaesarCipher(int key) {
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
		mainKey = key;
	}
	//Write an encrypt method that has one String parameter named input. 
	//This method returns a String that is the input encrypted using shiftedAlphabet.
	public String encrypt(String input) {
		StringBuilder encrypted = new StringBuilder(input);
				
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
	//Write a decrypt method that has one String parameter named input. 
	//This method returns a String that is the encrypted String decrypted using the key associated with this CaesarCipher object. 
	//One way to do this is to create another private field mainKey, which is initialized to be the value of key. 
	//Then you can create a CaesarCipher object within decrypt: CaesarCipher cc = new CaesarCipher(26 - mainKey); 
	//and call cc.encrypt(input).
	public String decrypt(String input) {
		CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
	}
	
}
	