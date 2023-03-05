import edu.duke.URLResource;

public class Part4 {
	public static void main(String[] args) {
		URLResource u = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		int leftq, rightq;
		int begyt, endyt;
		for (String s : u.lines()) {
		     // print or process s
			begyt=s.toLowerCase().indexOf("youtube.com");  //index of letter y of youtube.com
			endyt=begyt+"youtube.com".length(); //index of letter m of youtube.com
			if (begyt!=-1) {  //checks if youtube.com link exists in this line. If not, go to next line
				leftq=s.lastIndexOf("\"",begyt);  //checks for the last quote that happens before youtube.com
				rightq=s.indexOf("\"",endyt); //checks for the first quote that happens after youtube.com
				System.out.println(s.substring(leftq,rightq+1));
			}
			
		 }
		
	}
}
