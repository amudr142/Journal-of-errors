package Task;

import java.util.GregorianCalendar;

public class TestCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		
		Record record1 = new Record("2014-10-22 01:16:10, !!!, Omega, They can use Java only"); 
		Record record2 = new Record("2014-11-10 01:16:10, !!! , Apple, They");
		Record record3 = new Record("2014-10-20 01:16:00, !!! , IBM, Java only");
		Record record4 = new Record("2014-10-19 01:16:00, !!!, Apple, They can");
		Record record5 = new Record("2014-10-18 01:16:00, !!!!!, Apple5, They can use");
		
		JournalCollections journal = new JournalCollections(); 
		JournalCollections journal2 = new JournalCollections();
		JournalCollections journal3 = new JournalCollections();
		
		journal.add(record1);
		journal.add(record2);
		journal.add(record3);
		journal.add(record4);
		journal.add(record5);
		
		
		
		//journal.filter("2014-10-22 01:16:10, !!!, Omega, They can use Java only"); 
		//System.out.println(journal.toString()); 
		
		
		
		//sort tests
		GregorianCalendar date1 = new GregorianCalendar();
		date1.set(2014, 9, 10, 20, 15, 11);
		GregorianCalendar date2 = new GregorianCalendar();
		date2.set(2014, 11, 20, 20, 15, 11);

		//journal.filter(date1.getTime(), date2.getTime()); 
		//System.out.println(journal.toString()); 
		
		
		//sort tests-----------------------------------------------------
		//journal.sortByDate(); 
		//journal.sortByImportanceDate(); 
		//journal.sortByImportanceSourceDate(); 
		journal.sortByImportance(); 
		//journal.sortBySourceDate(); 
		
		System.out.println(journal.toString());
		
		//System.out.println(record3.getSource().compareTo(record2.getSource())); 
		
		//System.out.println(record1.getSource().compareTo(record2.getSource()));
		
		

	}

}
