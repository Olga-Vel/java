import edu.duke.*;
public class TestCaesarCipherTwo {
	
    
    static void simpleTests() {
        
    	String message1 ="Can you imagine life WITHOUT the internet AND computers in your pocket?";
    	System.out.println("message 1: " + message1);
        CaesarCipherTwo cc = new CaesarCipherTwo(21, 8);
        String encrypted1 = cc.encrypt(message1);
        System.out.println("encrypted message 1: " + encrypted1);
        String decrypted1 = cc.decrypt(encrypted1);
        System.out.println("decrypted message 1: " + decrypted1);
        CaesarCipherTwo cc2 = new CaesarCipherTwo(14,24);
        
        String decrypted2 = cc2.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy");
        System.out.println("Decrypted message 2:");
        System.out.println(decrypted2);
        String decryptedGK = cc.decryptGuessingKey("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
        System.out.println("Decrypted message guessing key:");
        System.out.println(decryptedGK);
        FileResource fr = new FileResource("mysteryTwoKeysQuiz.txt");
        String file = fr.asString();
        CaesarCipherTwo cc3 = new CaesarCipherTwo(0, 0);
        System.out.println(cc3.decryptGuessingKey(file));
        //String firstHalf = halfOfString(message, 0);
        //String secondHalf = halfOfString(message, 1);
    }
    public static void main(String[] args) {
    	simpleTests();
    }
}
