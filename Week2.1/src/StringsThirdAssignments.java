import edu.duke.StorageResource;
import edu.duke.FileResource;



public class StringsThirdAssignments {
	public static void main(String [] args) 
	{
		test();
		System.out.println("cgRatio "+cgRatio("ATGCCATAG"));
		System.out.println("countCTG "+countCTG("CTGATGATGACTGAGCT"));
	}

	public static int findStopCodon(String dnaStr,	int startIndex, String stopCodon) {
		int currIndex = dnaStr.indexOf(stopCodon, startIndex+3);
		while (currIndex !=-1) {
			int diff = currIndex - startIndex;
			if (diff %3 ==0) {
				return currIndex;
			}
			else {
				currIndex = dnaStr.indexOf(stopCodon, currIndex+1);
		
			}

		}
		return dnaStr.length();
		

	}
	
	public static String findGene(String dna, int where) {
		dna = dna.toUpperCase();
		int startIndex = dna.indexOf("ATG", where);
		if (startIndex == -1) {
			return "";
		}
		int taaIndex = findStopCodon(dna,startIndex,"TAA");
		int tagIndex = findStopCodon(dna,startIndex,"TAG");
		int tgaIndex = findStopCodon(dna,startIndex,"TGA");

		int minIndex = 0;
		if (taaIndex == -1 ||
				(tgaIndex != -1 && tgaIndex <taaIndex)){
			minIndex = tgaIndex;
		}
		else{
			minIndex = taaIndex;
		}
		if (minIndex == -1 || (tagIndex!=-1 && tagIndex < minIndex)) {
			minIndex = tagIndex;
		}

		if (minIndex == -1) {
			return"";
		}

		return dna.substring(startIndex,minIndex+3);
	}


	public static StorageResource getAllGenes(String dna) {
		StorageResource geneList = new StorageResource();
		int startIndex = 0;
		while (true) {
			String currentGene = findGene(dna,startIndex);
			if (currentGene.isEmpty()) {
				break;
			}
			geneList.add(currentGene);
			startIndex = dna.indexOf(currentGene, startIndex) +currentGene.length();
		}
		return geneList;
	}
	
	static  float cgRatio(String dna) {
		return (float)(countLetter(dna, "C")+countLetter(dna, "G"))/dna.length();
	}
	static int countLetter(String dna, String letter) {
		int positionOfLetter = dna.indexOf(letter);
		int count=0;
		String leftOver=dna;
		if (positionOfLetter == -1) {
			return 0;
		}
		
		while(positionOfLetter!=-1) {
			//System.out.println("positionOfLetter "+positionOfLetter);
			//System.out.println("leftOver "+leftOver);
			leftOver = leftOver.substring(positionOfLetter+letter.length());
			positionOfLetter = leftOver.indexOf(letter);
			count++;
		}
		
		return count;
	}
	
	
	static int countCTG(String dna) {
		return countLetter(dna, "CTG");
	}
	

	
	public static void testOn(String dna) {
		System.out.println("Testing getAllGenes on " +dna);
		StorageResource genes = getAllGenes(dna);
		for(String g: genes.data()) {
			System.out.println(g);
		}
	}

	public static void test() {
		testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
		testOn("");
		testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
	}

}

