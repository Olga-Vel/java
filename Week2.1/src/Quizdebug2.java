
public class Quizdebug2 {
	public static void findAbc(String input){
	       int index = input.indexOf("abc");
	       while (true){
	           if (index == -1 || index >= input.length() - 3){
	               break;
	           }
	           System.out.println(index);
	           String found = input.substring(index+1, index+4);
	           System.out.println(found);
	           //System.out.println("index " + index);
	           index = input.indexOf("abc",index+3);
	           //System.out.println("index after updating " + index);
	       }
	   }

	public static void main(String[]args){
	       findAbc("abcabcabcabca");
	       //findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
	       //a b c d k f j s k s i o e h g j f h s d j f h k s d f h u w a b c a b c a j f i e o w j
	      // 0 1 2 3 4 5 6 7 8 9 10111213141516171819202122232425262728293031323334353637383940414243     
	   }
}
