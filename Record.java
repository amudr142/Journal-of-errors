package Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record{
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    
    private static final String exceptionMessageTemplate = "Illegal argument. %s should %s!";
    private static final String toStringTemplate = "%s, %s, %s, %s";
    private static final String exceptionCauseNullPointer = "not be null";
    private static final String exceptionMessageIncorrectStringFormat = "Incorrect string format. Can't parse!";
    

    
    private static final String priority1 = ".    ";
    private static final String priority2 = "!    ";
    private static final String priority3 = "!!!  ";
    private static final String priority4 = "!!!!!";

    
    private Date date;
    private int priority;
    private String source;
    private String message;
    
    
    
    public Record(Date date, int priority, String source, String message) {
        
    	
    	//Checking for any type of mistakes 
    	
    	if (date == null)
            throw new IllegalArgumentException(String.format(exceptionMessageTemplate, "Date",
                    exceptionCauseNullPointer));    
    	
        if (priority < 1 || priority > 4)
            throw new IllegalArgumentException(String.format(
                    exceptionMessageTemplate, "Priority",
                    "contain values from 1 to 4"));

        if (source == null)
            throw new IllegalArgumentException(String.format(
                    exceptionMessageTemplate, "Source",
                    exceptionCauseNullPointer));
        
        if (message == null)
            throw new IllegalArgumentException(String.format(
                    exceptionMessageTemplate, "Message",
                    exceptionCauseNullPointer));
        
        if (source.trim().isEmpty() || source.contains(" "))
            throw new IllegalArgumentException(String.format(
                    exceptionMessageTemplate, "Source",
                    "not be empty or contain spaces or linebreaks"));
        
        if (message.trim().isEmpty() || message.contains("\n"))
            throw new IllegalArgumentException(String.format(
                    exceptionMessageTemplate, "Message",
                    "not be empty or contain linebreaks"));
//------------------------------------------------------------------------------------------------------------//
        this.date = new Date(date.getTime());
        this.priority = priority;
        this.source = source;
        this.message = message;
    }

    
    public Record(String record) {
        if (record == null)
            throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
      
        // Dividing record string into 4 separate objects
        
        record = record.trim();
        
        int comma = record.indexOf(","); 
        if (comma == -1)
            throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
        
        String date = record.substring(0, comma);
        record = record.substring(comma+1).trim();
        
        
        comma = record.indexOf(",");
        if (comma == -1)
            throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
        
        String priority = record.substring(0, comma).trim();
        record = record.substring(comma+1).trim();
        
        
        comma = record.indexOf(",");
        if (comma == -1)
            throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
        
        String source = record.substring(0, comma).trim();
        
        record = record.substring(comma+1).trim();
        if(record==null) 
        	throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
        String message = record;
        
        //-----------------------------------------------------------------------------------------------
        // Checking Date format
        
        int whiteSpace = date.indexOf(" "); 
        if (whiteSpace == -1)
            throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
        
 
        String date1 = date.substring(0, whiteSpace);
        String date2 = date.substring(whiteSpace);
        

        date = date1 + " " + date2;
        
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
        }
        
        //--------------------------------------------------------------------
        //Checking priority format

        if (priority.equals(priority1.trim()))
            this.priority = 1;
        else if (priority.equals(priority2.trim()))
            this.priority = 2;
        else if (priority.equals(priority3.trim()))
            this.priority = 3;
        else if (priority.equals(priority4))
            this.priority = 4;
        else
            throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
      
        //--------------------------------------------------------------------
        //Checking Source and Message formats
        
        if (source.trim().isEmpty() || source.contains(" "))
            throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
        this.source = source;

        if (message.isEmpty() || message.contains("\n"))
            throw new IllegalArgumentException(
                    exceptionMessageIncorrectStringFormat);
        this.message = record;
        
        
    }

    
	@Override
	public boolean equals(Object obj) {
		
		Record other = (Record) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (priority != other.priority)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}


	public Date getDate() {
        return new Date(this.date.getTime());
    }

    public int getPriority() {
        return this.priority;
    }

    public String getSource() {
        return this.source;
    }

    public String getMessage() {
        return this.message;
    }

    private String getPriorityString() {
        if (this.priority == 1)
            return priority1;
        if (this.priority == 2)
            return priority2;
        if (this.priority == 3)
            return priority3;
        if (this.priority == 4)
            return priority4;
        return "";
    }

    @Override
    public String toString() {
        return String.format(toStringTemplate, dateFormat.format(this.date),
                getPriorityString(), source, message);
    }

}
