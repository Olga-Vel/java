
public class FindGeneWhile {

public static String findGene(String dna) {
	//find 1st occurrence of "ATG", call its index "startIndex"
	int startIndex = dna.indexOf("ATG");
	//find the "TAA" starting from (startIndex+3). call this result currIndex
	int currIndex = dna.indexOf("TAA", startIndex +3);
	//as long as currIndex is not equal to -1
	while (currIndex !=-1) {
		//check if(currIndex - startIndex) is a multiple of 3
		if((currIndex - startIndex) %3 ==0) {
			//if so, the text between startIndex an currIndex + 3 is your answer
			return dna.substring(startIndex, currIndex+3);
			
			//if not, update currIndex to the index of the next TAA, starting from (currIndex+1) 
			}
		    else {
		    	currIndex = dna.indexOf("TAA", currIndex+1);
		    }
	}
	//your answer is the empty string
	return "";
}


public static void testFindGene(){
    String dna = "AATGCGTAATTAATCG";
    String gene = findGene(dna);
    System.out.println("DNA strand is " + dna);
    System.out.println(" Gene is " + gene);

dna = "AATGCTAGGGTATATTGGT";
gene = findGene(dna);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);
}

public static void main(String[] args) {
	testFindGene();
	/*FindGeneWhile fgw = new FindGeneWhile(); instantiation of the class for the purpose of using its method
	fgw.testFindGene();*/
	
}

}
