import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyNames {
	public static void printNames() {
		FileResource fr = new FileResource();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (numBorn <= 100) {
				System.out.println("Name " + rec.get(0) + " Gender " + rec.get(1) + " Num Born "+ rec.get(2));;
			}
		}
	}
	
	public static void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		int girlsNames = 0;
	    int boysNames = 0;
		for (CSVRecord rec: fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));			
			String name = rec.get(0);
			totalBirths += numBorn;	
			if(rec.get(1).equalsIgnoreCase("M")) {
				totalBoys+=numBorn;
				boysNames = countNames(name, boysNames);
			}
			else {
				totalGirls +=numBorn;
				girlsNames = countNames(name, girlsNames);
			}
			
		}
		System.out.println("total births = " +totalBirths);
		System.out.println("total girls = " +totalGirls);
		System.out.println("total boys = " +totalBoys);
		System.out.println("Number of Girls Names = " + girlsNames);
        System.out.println("Number of Boys Names = " + boysNames);
        System.out.println("Total Names = " + (boysNames + girlsNames));
			
	}
	//if name equals null, return the same number u gave the method. If it isn't null, return number +1
	 public static int countNames(String name, int count) {
		 if (name==null) {
			 return count;
		 }else {
			 return count+1;
		 }
		 
		 
	}
	
	public static int getRank (int year, String name, String gender) {
		 String filename = "us_babynames_by_year/yob" + year + ".csv";
	        FileResource fr = new FileResource(filename);
	        int rank = 1;
	        //int boysNames = 0;
	        for(CSVRecord record : fr.getCSVParser(false)) {
	            String nameRow = record.get(0);
	            String genderRow = record.get(1);
	           /* if(genderRow.equalsIgnoreCase("M")) {
	                boysNames = countNames(name, boysNames);
	                rank = boysNames;
	            }*/
	            if(nameRow.equalsIgnoreCase(name) && genderRow.equalsIgnoreCase(gender)) {
	                return rank;
	            }
	            rank++;
	        }
	        return -1;
	    }
	
	  //should return the name of the person in the file at this rank for the given gender
    public static String getName(int year, int rank, String gender) {
        String filename = "us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser(false);
       String name = null;
        //
        //int girlsNames = 0;
        //int maleRank = rank;
        int lineNumber = 0;
        for(CSVRecord record : parser) {
            String genderRow = record.get(1);
            lineNumber++;
            /*if(genderRow.equalsIgnoreCase("F")) {
                girlsNames = countNames(record.get(0), girlsNames);
            }
            
            if(genderRow.equalsIgnoreCase("M") && gender.equalsIgnoreCase("M")) {
                rank = maleRank + girlsNames;
            }
            */
            if(genderRow.equals(gender) && rank == lineNumber) {
                return name = record.get(0);
            }
        }
        return "NO NAME";
    }
    public static void whatIsNameInYear(String name,int year,int newYear, String gender) {
    	 int rank = getRank(year, name, gender);
         String newName = getName(newYear, rank, gender);
         if(gender.equalsIgnoreCase("M")) {
             System.out.println(name + " born in " + year + " would be " + newName + 
                             " if he was born in " + newYear);
         } else {
             System.out.println(name + " born in " + year + " would be " + newName + 
                             " if she was born in " + newYear);
         }
    }
	
    public static int yearOfHighestRank(String name, String gender) {
        int year = -1;
        int tempYear = 0;
        int previousRank = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            String filename = f.getName();
            String getYear = filename.substring(filename.indexOf("yob") + 3, filename.indexOf(".csv"));
            tempYear = Integer.parseInt(getYear);
            int currentRank = getRank(tempYear, name, gender);
            if((currentRank != -1) && (previousRank == 0 || currentRank < previousRank)) {
                previousRank = currentRank;
                year = tempYear;
            }
        }
        return year;
    }
    
	public static void testTotalBirths() {
		FileResource fr = new FileResource("us_babynames_test/yob2014short.csv");
		totalBirths(fr);
	}
	 public double getAverageRank(String name, String gender) {
	        double average = -1.0;
	        int sum = 0;
	        int count = 0;
	        DirectoryResource dr = new DirectoryResource();
	        for(File f : dr.selectedFiles()) {
	            String filename = f.getName();
	            String getYear = filename.substring(filename.indexOf("yob") + 3, filename.indexOf(".csv"));
	            int year = Integer.parseInt(getYear);
	            int rank = getRank(year, name, gender);
	            sum += rank;
	            count++;
	            average = (double)sum / count;
	        }
	        return average;
	    }
	    public static int getTotalBirthsRankedHigher(int year, String name, String gender) {
	     
	    	String filename = "us_babynames_by_year/yob" + year + ".csv";
	        FileResource fr = new FileResource(filename);
	        CSVParser parser = fr.getCSVParser(false);
	        int totalBirths = 0;
	        int count = 0;
	        int boysCount = 0;
	        int rank = getRank(year, name, gender);
	        for(CSVRecord record : parser) {
	            int numBorn = Integer.parseInt(record.get(2));
	            if(record.get(1).equals("M") && gender.equals("M")) {
	                boysCount++;
	                if(boysCount < rank) {
	                    totalBirths += numBorn;
	                }
	            } else if(record.get(1).equals("F") && gender.equals("F")){
	                count++;
	                if (count < rank) {
	                    totalBirths += numBorn;
	                }
	            }
	        }
	        return totalBirths;
	    }
	public static void main(String [] args) {
		
		//System.out.println(whatIsNameInYear("Minnie", 1880,1881,"F")); 
		 System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M")); //1134053
			
	}
	
}
