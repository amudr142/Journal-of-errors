package Task;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class JournalCollections {
	
	List<Record> list = new ArrayList<Record>(); 
	
	
	
	public void add(Record r) {
		list.add(r);  	}


	public void remove(Record r) {
		list.remove(r); }
	
	
	public void remove(int index) {
		list.remove(index); }
	
	
	public void remove(int fromIndex, int toIndex){
		for(int i=fromIndex; i<=toIndex; i++){
		list.remove(i);  } 
	}
	

	public void removeAll(){	
		list.removeAll(list);  	}
	
	//method for checking only----------------------------
	public void printer() {
		Iterator<Record> iter = list.iterator(); 
		
		while(iter.hasNext()){
			Record elem = iter.next();
			System.out.println(elem); 		}
	}
	//---------------------------------------------
	
	public JournalCollections filter(String s) {
		Iterator<Record> iter = list.iterator(); 
		Record r = new Record(s);
		
		while(iter.hasNext()){
			Record elem = iter.next();
		if(!elem.equals(r)) iter.remove();
		}
		return this; 
	}

	public JournalCollections filter(Date fromDate, Date toDate) {
		Iterator<Record> iter = list.iterator(); 
		
		while(iter.hasNext()){
			Record elem = iter.next();
			
		if(elem.getDate().compareTo(fromDate)==-1){
			iter.remove(); } 
		else
		if(elem.getDate().compareTo(toDate)==1){
			iter.remove(); }
		}
		return this; 
	}
	
	//this method sorts records from the most older to the most earlier errors
	public void sortByDate() {
		
	Collections.sort(list, new Comparator<Record>()
	{
		 @Override
	        public int compare(Record record1, Record  record2)
		 {
			 return record1.getDate().compareTo(record2.getDate()); }	
	}); 
	} 
	
	
	public void sortByImportance() {
		
	Collections.sort(list, new Comparator<Record>(){
		 @Override
	        public int compare(Record record1, Record  record2)
		 {
			 return record2.getPriority()-record1.getPriority(); }	
	}); 
	} 

	
	public void sortByImportanceDate() {
		
		Collections.sort(list, new Comparator<Record>(){
			 @Override
		        public int compare(Record record1, Record  record2)
			 {
				 if (record2.getPriority()!=record1.getPriority()){
				 return record2.getPriority()-record1.getPriority(); }	
				
				 return record1.getDate().compareTo(record2.getDate());

		}
		});	
} 
	
	
	public void sortByImportanceSourceDate() {
		
		Collections.sort(list, new Comparator<Record>(){
			 @Override
		        public int compare(Record record1, Record  record2)
			 {
				 
				 if (record2.getPriority()!=record1.getPriority()){
				 return record2.getPriority()-record1.getPriority(); }	
				 
				 if(record2.getPriority()==record1.getPriority()){
				 return record1.getSource().compareTo(record2.getSource()) + record1.getDate().compareTo(record2.getDate());}
	
				 //if(record1.getSource().compareTo(record2.getSource())==0)
				 //return record1.getDate().compareTo(record2.getDate());
				 
				 return 0; }
			 
		});	
} 		
		
	
public void sortBySourceDate() {
		
		Collections.sort(list, new Comparator<Record>(){
			 @Override
		        public int compare(Record record1, Record  record2)
			 {
				if(record1.getSource().compareTo(record2.getSource())!=0){
					return record1.getSource().compareTo(record2.getSource()); }

				return record1.getDate().compareTo(record2.getDate());
		}
		});			
}
	
	//other methods
	
	List<Record> getErrorsList() {
		return list;
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
}
