
public class CaesarCipherTwo {
    private String alphabet;
    private int mainKey1;
    private int mainKey2;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
    
    public CaesarCipherTwo(int key1, int key2) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
     
    public String encrypt(String input){
		StringBuilder encrypted = new StringBuilder(input);
        String f = "";
        char x;
        int index;
        for(int i = 0; i < encrypted.length(); i++) {
        	index = alphabet.indexOf(Character.toLowerCase(encrypted.charAt(i)));
        	if(index != -1){
	            if(i % 2 == 0) {
	                x = shiftedAlphabet1.charAt(index);
	                encrypted.setCharAt(i, x);
	            } else {
	                x = shiftedAlphabet2.charAt(index);
	                encrypted.setCharAt(i, x);
	            }
	            //System.out.println(input.charAt(i)+" -> " + x);
        	}
        }
        return encrypted.toString();
	}
    
    public String decryptGuessingKey(String encrypted) {
        
        String firstHalf = halfOfString(encrypted, 0);
        String secondHalf = halfOfString(encrypted, 1);
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        
        int dkey1 = key1 - 4;
        int dkey2 = key2 - 4;
        if(key1 < 4) {
            dkey1 = 26 - (4 - key1);
        }
        if(key2 < 4) {
            dkey2 = 26 - (4 - key2);
        }
        
        System.out.println("key1: " + dkey1 + " key2: " + dkey2);
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - dkey1,26 - dkey2);
        return cc.encrypt(encrypted);
    }
    public String decrypt(String encrypted) {
        
        //System.out.println("key1: " + dkey1 + " key2: " + dkey2);
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1,26 - mainKey2);
        return cc.encrypt(encrypted);
    }
    public String halfOfString(String message, int start) {
        StringBuilder sb = new StringBuilder();
        //String answer = "";
        for(int i = start; i < message.length(); i += 2) {
            char ch = message.charAt(i);
            sb.append(ch);
        }
        //for (int k = start; k< message.length() ; k+= 2) {
            //answer = answer + message.charAt(k);
        //}
        return sb.toString();
        //return answer;
    }
    
    int getKey(String s) {
        int[] freqs = countLetters(s);
        int key = maxIndex(freqs);
        return key;
    }
    int[] countLetters(String encrypt) {
        //String alphabet = "abcdefghijklmnopqrstuvwxyz";
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
    
    int maxIndex(int[] freqs) {
        int maxDex = 0;
        for(int i = 0; i < freqs.length; i++) {
            if(freqs[i] > freqs[maxDex]) {
                maxDex = i;
            }
        }
        return maxDex;
    }
}
