package Task;

import java.util.GregorianCalendar;

public class RecordTest {

    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(2012, 11, 12, 20, 15, 11);
 
        //Null Date
//       Record badRecord = new Record(null, 0, null, null);
        //Too low priority 
//        Record badRecord = new Record(calendar.getTime(), 0, null, null);
        //Too big priority
//        Record badRecord = new Record(calendar.getTime(), 5, null, null);
        //Null source
//        Record badRecord = new Record(calendar.getTime(), 2, null, null);
        //Null message
//        Record badRecord = new Record(calendar.getTime(), 2, "Source", null);
        //Empty source
//               Record badRecord = new Record(calendar.getTime(), 2, "h", " ");
        //Empty message
//        Record badRecord = new Record(calendar.getTime(), 2, "Source", " ");
        //Source with whitespace
//       Record badRecord = new Record(calendar.getTime(), 2, "Very long source", " ");
        //Message with line-breakers
//        Record badRecord = new Record(calendar.getTime(), 2, "Source", "Message \n with \n linebreakers ");
        
        
        // One good record
   	Record record = new Record(calendar.getTime(), 2, "Source", "Error message");
        
        // Look at it's toString() value!
//         System.out.println(record.toString());
        
        //Now try some magic
//        Record rebornRecord = new Record(record.toString());
        // So, how are we?
//        System.out.println(rebornRecord.toString());
        // Looks like a magic ))

   	
        //Just null string
//        Record badStringRecord = new Record(null);
        //Or empty string
//        Record badStringRecord = new Record("        ");
        //Who needs hours and minutes?!
//   		  Record badStringRecord = new Record("2012-12-12!Source Error message");
        //Fuck the priorities!
//        Record badStringRecord = new Record("2012-12-12 20:15:48     Source Error message");
        //It was very anonymous source.
//        Record badStringRecord = new Record("2012-12-12 20:15:48 ! message");
        //And very secret message
        //Record badStringRecord = new Record("2012-12-12 20:15:48, !    , Source");
        
        //What about good string?
        Record stringRecord = new Record("2014-10-22 01:16:00, ! , Apple, They can use Java only");
        //Look at this!
   
        System.out.println(stringRecord.toString());
        
        
        System.out.println(stringRecord.getDate());
        
        
        
    }

}
