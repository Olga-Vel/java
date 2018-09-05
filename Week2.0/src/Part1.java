
/**
 * Write a description of FindGeneSimpleAndTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
public String findGeneSimple(String dna){
//start codon is "ATG";
//stop codon is "TAA";
    String result = "";
    int startIndex = dna.indexOf("ATG");
    if (startIndex == -1) // no ATG
    {
            return "";
    }
    int stopIndex = dna.indexOf("TAA", startIndex+3);
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
    String gene = findGeneSimple(dna);
    System.out.println("DNA strand is " + dna);
    System.out.println(" Gene is " + gene);

dna = "AATGCTAGGGTATATTGGT";
gene = findGeneSimple(dna);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);

dna = "ATCCTATCTTCGGCTGCTCTAGTATT";
gene = findGeneSimple(dna);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);

dna = "ATGTAA";
gene = findGeneSimple(dna);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);

dna = "ATGCGTTAA";
gene = findGeneSimple(dna);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);

dna = "ATGCTTAA";
gene = findGeneSimple(dna);
System.out.println("DNA strand is " + dna);
System.out.println(" Gene is " + gene);
}
}
