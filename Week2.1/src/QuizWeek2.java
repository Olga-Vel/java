
public class QuizWeek2 {
	
	public static void main(String [] args) {
		int count=0;
		String newDna = "";
		int startPos = 0;
		int pos = 0;
		String dna = "ATGCCCGGGAATAACC";
		while (count < 3) {
			System.out.println(count);
			count += 1;
			newDna = newDna + dna.substring(startPos,pos);
			startPos = pos+1;
			pos = dna.indexOf("T", startPos);
			if (pos == -1) {
				break;
			 }
		}
	}
}
