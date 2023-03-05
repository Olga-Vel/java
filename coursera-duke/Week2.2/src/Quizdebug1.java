
public class Quizdebug1 {
	public static void findAbc(String input) {
		System.out.println(input.length());
	    int index = input.indexOf("abc");
	    while (true) {
	        if (index == -1) {
	            break;
	        }
	        /*System.out.println(index+1);
	        System.out.println(index+4);*/
	        if(index >= input.length() - 4) {
	        	break;
	        }
	        String found = input.substring(index+1, index+4);
	        System.out.println(found);
	        index = input.indexOf("abc", index+4);
	    }
	}
	public static void main(String[]args) {
		findAbc("abcdabc");
		findAbc("abcbbbabcdddabc");
		findAbc("woiehabchi");
		findAbc("eusabce");
		findAbc("yabcyabc");
		findAbc("aaaaabc");
				
	}
}
