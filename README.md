# InterviewAssignment
Interview Assignment in order to show Java/coding skill

This program uses a custom class 'Record' in order to store details of person by reading a input.txt file, parses the line using regex split and storing
that record instance into an Arraylist. Once end of file has been reached, the Arraylist is then sorted using built in Collections.sorted(). This sorting uses the custom @Override compareTo funtion which first sorts based on Address. If Address is equal, then the next step in the CompareTo function takes is to compare the last names of each record. Lastly, if last names are equal it will check first names. 

Once the Arraylist is sorted, the program uses a FIFO queue in order to separate each Households. If the next value in the array list has a value, the program will then output the address (as the Houshold) and the number of records in the queue. Then output the queue starting at the top (using peek and remove method), using the @Override toString method of the class to give expected output of the record. The program will output to the console as well as to a file with a unique name.

If the record has an empty address field, the program will ignore that record and write a warning message to the console.

Items todo that would be performed given time:
1. Various checks on input fields beyond address.
2. Checks on file itself. Ensure input is txt with proper formatting.
3. removal of duplicate records if given in file.
4. Full testing plan with different points of contact.
5. performance test with input file of 1k records.
