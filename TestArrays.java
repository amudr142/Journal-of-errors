package Task;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestArrays {
	
	public static void main(String[] args) {

		
		Record record1 = new Record("2014-10-22 01:16:10, !!!, Omega, They can use Java only"); 
		Record record2 = new Record("2014-10-22 01:16:10, !!!, Apple, They");
		Record record3 = new Record("2013-10-20 01:16:00, . , Apple, Java only");
		Record record4 = new Record("2014-10-19 01:16:00, !!!, Apple4, They can");
		Record record5 = new Record("2014-10-18 01:16:00, !!!!!, Apple5, They can use");

		
		JournalArrays journal = new JournalArrays(); 
		JournalArrays journal2 = new JournalArrays();
		JournalArrays journal3 = new JournalArrays();
		
		journal.add(record1);
		journal.add(record2);
		journal.add(record3);
		 
		
		//dates tests---------------------------------------------------------------
		GregorianCalendar date1 = new GregorianCalendar();
		date1.set(2014, 8, 1, 20, 15, 11);
		GregorianCalendar date2 = new GregorianCalendar();
		date2.set(2014, 11, 20, 20, 15, 11);

		journal.filter(date1.getTime(), date2.getTime()); 
		System.out.println(journal.toString()); 
		
		//System.out.println(journal.getArray()[1].getDate().compareTo(date1.getTime()));
		
		//System.out.println(dateFormat.format(journal.getArray()[1].getDate()));
		//System.out.println(date2.getTime());
	
		//filter tests--------------------------------------------------------------
		
		//System.out.println(journal.getArray()[0].toString()); 
		
		//System.out.println(journal.getArray()[0].toString().equals("2014-10-22 01:16:00, !    , Apple1, They can use Java only")); 
		
		//String s = "2014-10-22 01:16:00, ! , Apple1, They can use Java only"; 
		//Record r = new Record(s); 
		//System.out.println(journal.getArray()[0].equals(r)); 
		
		//journal.filter("2014-10-21 01:16:00, !!!, Apple3, They"); 
		//System.out.println(journal.toString()); 
		
		
		//sort tests------------------------------------------------------------------------

		//journal.sortByDate(); 
		//System.out.println(journal.toString());
		
		//journal.sortByImportanceDate(); 
		//System.out.println(journal.toString());
		
		//journal.sortBySource();  
		//System.out.println(journal.toString());
		
		//journal.sortByImportanceSourceDate();  
		//System.out.println(journal.toString());
		
		//journal.sortBySourceDate();   
		//System.out.println(journal.toString());
		
	}
}
