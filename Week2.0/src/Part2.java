
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
public String findGeneSimple(String dna, String startCodon, String stopCodon){
//start codon is "ATG";
//stop codon is "TAA";
    String result = "";
    //String upDna = dna.toUpperCase();
    int startIndex = dna.indexOf(startCodon);
    if (startIndex == -1) // no ATG
    {
            return "";
    }
    int stopIndex = dna.indexOf(stopCodon, startIndex+3);
    if (stopIndex == -1) // no TAA
    {
            return "";
    }
    
    if ((dna.substring(startIndex+3, stopIndex).length())%3==0)
    {
            return dna.substring(startIndex+3, stopIndex);
    }
    else{
        return "";
    }
}


public void testFindGeneSimple(){
    String dna = "AATGCGTAATATGGT";
    String startCodon = "ATG";
    String stopCodon = "TAA";
    String gene = findGeneSimple(dna, startCodon, stopCodon);
    System.out.println("DNA strand is " + dna);
    System.out.println(" Gene is " + gene);

dna = "AATGCTAGGGTATATTGGT";
startCodon = "ATG";
stopCodon = "TAA";
gene = findGeneSimple(dna, startCodon, stopCodon);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);

dna = "ATCCTATCTTCGGCTGCTCTAGTATT";
startCodon = "ATG";
stopCodon = "TAA";
gene = findGeneSimple(dna, startCodon, stopCodon);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);

dna = "ATGTAA";
gene = findGeneSimple(dna, startCodon, stopCodon);
startCodon = "ATG";
stopCodon = "TAA";
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);

dna = "ATGCGTTAA";
gene = findGeneSimple(dna, startCodon, stopCodon);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);

dna = "ATGCTTAA";
gene = findGeneSimple(dna, startCodon, stopCodon);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);

dna = "ATGCGTTAA";
gene = findGeneSimple(dna.toLowerCase(), startCodon.toLowerCase(), stopCodon.toLowerCase());
System.out.println("DNA strand is " + dna.toLowerCase());
System.out.println(" Gene is " + gene);
}
}
