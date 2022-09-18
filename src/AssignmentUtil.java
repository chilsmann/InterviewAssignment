import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AssignmentUtil {
    public static ArrayList<Record> readFile() throws FileNotFoundException {
        ArrayList<Record> recordList = new ArrayList<Record>();
        Scanner readFile = new Scanner(new FileReader("Input.txt"));

        String line = "";

        while(readFile.hasNext()){
            line = readFile.nextLine();
            if(!line.equals("")){
                String[] arraySplit = line.split("\",\"");
                arraySplit.toString();
                recordList.add(new Record(arraySplit[0].toString().substring(1),arraySplit[1].toString(),arraySplit[2].toString().replaceAll("[,.]", "").trim()+" "+arraySplit[3].toString()+", "+arraySplit[4].toString(),Integer.parseInt(arraySplit[5].substring(0,arraySplit[5].length()-1))));
            }
            line = "";
        }
        readFile.close();
        return recordList;
    }

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
