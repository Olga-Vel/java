import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part3Internet {
	public static StorageResource getAllGenes(String dna) {
		StorageResource sr = new StorageResource();
		int startIndex = 0;
		while (true) { 
			String gene = findGene(dna, startIndex);
			
			if (gene == "") {
				break;
			}
			
			sr.add(gene);

			startIndex = dna.indexOf(gene, startIndex) + gene.length();

		}
		return sr;
	}
	public static String findGene(String dna, int where) {
		int startIndex = dna.indexOf("ATG", where);
		if(startIndex == -1 || where == -1) {
			return "";
		}

		int taaIndex = findStopCodon(dna, startIndex, "TAA");
		int tagIndex = findStopCodon(dna, startIndex, "TAG");
		int tgaIndex = findStopCodon(dna, startIndex, "TGA");

		int minIndex = 0;
		
		if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
			minIndex = tgaIndex;
		} else {
			minIndex = taaIndex;
		}

		if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
			minIndex = tagIndex;
		}

		if(minIndex == -1) {
			return "";
		}
		
		return dna.substring(startIndex, minIndex + 3);
	}
	public static int findStopCodon(String dna, int startIndex, String stopCodon) {
		int currIndex = dna.indexOf(stopCodon, startIndex + 3);
		while(currIndex != -1) {
			int diff = currIndex - startIndex;
			if(diff % 3 == 0) {
				return currIndex;
			} else {
				currIndex = dna.indexOf(stopCodon, currIndex + 1);
			}
		}

		return -1;
	}
}
