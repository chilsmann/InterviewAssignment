import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AssignmentUtil {
    /*
        readFile function uses a scanner to read the file and takes each line and splits based on '","'. this
        leaves one Qoutation on the 0th element and the -1 element, which gets trimmed and substringed when
        the record gets created and added to the array list.

        if the address field is empty, the record is discarded as it can not be attributed to a Household and
        a warning message is outputted to the console.
     */
    public static ArrayList<Record> readFile() throws FileNotFoundException {
        ArrayList<Record> recordList = new ArrayList<Record>();
        Scanner readFile = new Scanner(new FileReader("Input.txt"));

        String line = "";

        while(readFile.hasNext()){
            line = readFile.nextLine();
            if(!line.equals("")){
                String[] arraySplit = line.split("\",\"");
                if(!arraySplit[2].toString().replaceAll("[,.]", "").trim().equals("")) {
                    recordList.add(new Record(arraySplit[0].toString().substring(1), arraySplit[1].toString(), arraySplit[2].toString().replaceAll("[,.]", "").trim() + " " + arraySplit[3].toString() + ", " + arraySplit[4].toString(), Integer.parseInt(arraySplit[5].substring(0, arraySplit[5].length() - 1))));
                }
                else // if address field is empty, output warning to console that record will not be counted
                    System.out.println("WARNING: Address field is empty. Record "+arraySplit[0].toString().substring(1)+" "+arraySplit[1].toString()+" will not be outputted!");
            }
            line = "";
        }
        readFile.close();
        return recordList;
    }

    /*
        outputAssignment function creates an output txt file and writes the output to the console.
        The function takes the sorted arraylist of Records from Main function and uses a queue as
        a fifo to group up records with the same household and get the count. From here it compares
        the next record's address to see if it matches. If not, it will output the households (which
        are already sorted based on the CompareTo in Record class) and prints/write-outs the output to file
        and console. This continues until the end of the arrayList. The function also filters out records
        where age is under 18.
     */
    public static void outputAssignment(ArrayList<Record> recordList) throws IOException {
        File newFile = new File("output_"+System.currentTimeMillis()+".txt");
        FileWriter fw = new FileWriter(newFile);
        BufferedWriter bw = new BufferedWriter(fw);
        Queue<Record> fifo = new LinkedList<Record>();
        for(int i = 0; i < recordList.size(); i++){
            if(recordList.get(i).getAge()>=18)
                fifo.add(recordList.get(i));
            if(i == recordList.size()-1 || !recordList.get(i).getAddress().equalsIgnoreCase(recordList.get(i+1).getAddress())){
                //line breaks for format
                System.out.println();
                bw.newLine();
                bw.newLine();
                //Write output to console and file
                bw.write("Household: "+fifo.peek().getAddress() +" - Household count: "+fifo.size());
                System.out.println("Household: "+fifo.peek().getAddress() +" - Household count: "+fifo.size());
                while(!fifo.isEmpty()) {
                    //unload queue to prepare for next household
                    System.out.println(fifo.peek());
                    bw.newLine();
                    bw.write(fifo.peek().toString());
                    fifo.remove();
                }
            }
        }
        bw.close();
    }
}
