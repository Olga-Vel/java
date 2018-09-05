import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import edu.duke.FileResource;
import edu.duke.StorageResource;


public class Part3 {
	static void processGenes(StorageResource sr,int geneLength) {
			
		System.out.println("Strings in sr that are longer than " +geneLength + " characters are ");
		printLongerThan(sr,geneLength);
		System.out.println("Number of Strings in sr that are longer than " +geneLength + " characters is ");
		printNumberLongerThan(sr,geneLength);
		System.out.println("Strings in sr whose C-G-ratio is higher than 0.35 are " );
		printCGGreater035(sr);
		System.out.println("Number of strings in sr whose C-G-ratio is higher than 0.35 is " );
		printNumberCGGreater035(sr);
		System.out.println("Length of the longest gene in sr is ");
		printLengthLongestGene(sr);
		System.out.println("Number of genes in dna is ");
		printNumberOfGenes(sr);
	
		
	}	
	private static void printNumberOfGenes(StorageResource sr) {
		int count = 0;
		for (String s : sr.data()) {
		     count++;;
		     
		 }
		System.out.println(count);	
	}
	
	private static void printLongerThan(StorageResource sr,int geneLength) {
		for (String s : sr.data()) {
		     if(s.length() > geneLength) {
		    	 System.out.println(s);
		     }
		 }
		 
		
	}
	private static void printNumberLongerThan(StorageResource sr,int geneLength) {
		int count = 0;
		for (String s : sr.data()) {
		     if(s.length() > geneLength) {
		    	 count++;;
		     }
		 }
		System.out.println(count);
	}


	private static void printCGGreater035(StorageResource sr) {
		for (String s : sr.data()) {
		     if(StringsThirdAssignments.cgRatio(s)>0.35) {
		    	 System.out.println(s);
		     }
		 }
		 
		
	}

	private static void printNumberCGGreater035(StorageResource sr) {
		int count = 0;
		for (String s : sr.data()) {
		     if(StringsThirdAssignments.cgRatio(s)>0.35) {
		    	 count++;;
		     }
		 }
		System.out.println(count);
	}

		
	

	private static void printLengthLongestGene(StorageResource sr) {
		int currentBig = 0;
		for (String s : sr.data()) {
		     if(s.length()>currentBig) {
		    	 currentBig = s.length();
		     }
		 }
		System.out.println(currentBig);	
	}

	static void testProcessGenes(){
		StorageResource store = new StorageResource();
		store.add("ATCCTATGTTCGGCTGCTCGTAAGTATT");
		store.add("ATGCTATAA");
		store.add("ATGCGCTGCCCGTAA");
		store.add("ATATGCTATTTTCGTCTGCTCGTACATATTATTTAGCTATTTCAAAAATAACC");
		processGenes(store,9);
		
		
	}
	
	static void testDukeFile() throws IOException {
		FileResource fr = new FileResource("GRch38dnapart.fa");
		String dna = fr.asString();
		System.out.println("Number of CTG in dna is ");
		System.out.println(StringsThirdAssignments.countCTG(dna));
		//String dna = new String(Files.readAllBytes(Paths.get("C:\\Users\\velic\\workspace\\workspace-java\\Week2.0\\src\\brca1line.fa")));
		dna = dna.toUpperCase();
		System.out.print(dna);
		StorageResource store = Part3Internet.getAllGenes(dna);
		processGenes(store,60);
	}
	
	public static void main(String [] args) throws IOException {
		//testProcessGenes();
		testDukeFile();
	}
}

