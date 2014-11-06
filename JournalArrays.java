package Task;

import java.util.Arrays;
import java.util.Date;


public class JournalArrays {
	
	int capacity = 5; //initial capacity
	private Record[] array = new Record[capacity];
	
	int count = 0; //number of filled boxes in the array


public void add(Record r){
	
	array[count]=r;
	count++; 
	
	if(count+10>=capacity){
	array = Arrays.copyOf(array, capacity+=10); 
	//System.out.println(Arrays.toString(array)); 
	}
}

public void add(JournalArrays journal){
	
	Record[] array = journal.getArray();
	
	for(int i=0; i<journal.count ;i++){
		this.add(array[i]); }
	}

public void remove(Record r){
	
	for(int i=0; i<this.array.length; i++)	{
		if(this.array[i]==r) {
			this.array[i]=null; break;}
		}
}

public void remove(int Index){
	this.array[Index]=null; 
}

public void remove(int fromIndex, int toIndex){
	for(int i=fromIndex; i<=toIndex; i++){
	this.array[i]=null;}
}

public void removeAll(){
	for(int i=0; i<=this.count; i++){
	this.array[i]=null;}
}

public JournalArrays filter(String s) {
	for(int i=0; i<count; i++){
	  Record r = new Record(s);  
	if(!this.getArray()[i].equals(r)) this.remove(i);
	}
	return this; 
}

public JournalArrays filter(Date fromDate, Date toDate) {

	for(int i=0; i<this.count; i++)
	{
	if(this.getArray()[i].getDate().compareTo(fromDate)==-1){
		this.remove(i); } 
	else
	if(this.getArray()[i].getDate().compareTo(toDate)==1){
		this.remove(i); }
	}
	
	return this; 
}

//this method sorts records from the most older to the most earlier errors
public void sortByDate() {

for(int i=0; i<this.count; i++)
	for(int j=0; j<this.count-1; j++)
	{
		{
	if(this.getArray()[j].getDate().compareTo(this.getArray()[j+1].getDate())==1){
		swap(this.getArray(), j); }
	}
	}
}

public void sortByImportance() {

for(int i=0; i<this.count; i++)
	for(int j=0; j<this.count-1; j++)
	{
		{
	if(this.getArray()[j].getPriority()<this.getArray()[j+1].getPriority() || 
			this.getArray()[j].getPriority()==this.getArray()[j+1].getPriority()){
		swap(this.getArray(), j); }
	}
	}
}

public void sortByImportanceDate() {
	
for(int i=0; i<this.count; i++)
	for(int j=0; j<this.count-1; j++)
	{
		{
			this.sortByImportance(); 
		if(this.getArray()[j].getPriority()==this.getArray()[j+1].getPriority()){
			this.sortByDate(); 
		}
	}
	}
}

public void sortBySource() {
	
for(int i=0; i<this.count; i++)
	for(int j=0; j<this.count-1; j++)
	{
		{
			if(this.getArray()[j].getSource().compareTo(this.getArray()[j+1].getSource())>0){
		swap(this.getArray(), j); }
	}
	}
}

public void sortByImportanceSourceDate() {
	
	for(int i=0; i<this.count; i++)
		for(int j=0; j<this.count-1; j++)
		{
			{
		this.sortByImportance(); 
		
		if(this.getArray()[j].getPriority()==this.getArray()[j+1].getPriority()){
				this.sortBySource(); }
		if(this.getArray()[j].getSource().compareTo(this.getArray()[j+1].getSource())==0){
				this.sortByDate(); } 
		}
		}
}

public void sortBySourceDate() {
	for(int i=0; i<this.count; i++)
		for(int j=0; j<this.count-1; j++)
		{
			{
			this.sortBySource();
			if(this.getArray()[j].getSource().compareTo(this.getArray()[j+1].getSource())==0){
					this.sortByDate(); } 
		}
		}
}

//Other methods

private static void swap(Record[] array, int i) {
	Record tmp = array[i];  
	array[i]=array[i+1]; 
	array[i+1]=tmp; 	 
}

public Record[] getArray() {
	return array;
}

public int getCapacity() {
	return capacity;
}

public int getCount() {
	return count;
}

@Override
public String toString() {
	return Arrays.toString(array);
}


}
	

