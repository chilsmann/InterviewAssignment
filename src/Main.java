import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        /*
        This program creates an ArrayList of custom class 'Record'. This class is used as an object to store
        first name, last name, combined address fields and age. It has overrided CompareTo function to check
        by address, then last name, then first name in order to sort. '.' and ',' are removed from address and
        trimmed in order to check the full address of the record.

        The output is reported to the console as well as a unique file.
         */
        ArrayList<Record> recordList = AssignmentUtil.readFile();
        Collections.sort(recordList);
        AssignmentUtil.outputAssignment(recordList);
    }

}