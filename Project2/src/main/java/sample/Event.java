package sample;

import java.io.*;

public class Event {

    public String name;
    public String location;
    public String priority;
    public String time;
    private static FileReader fr;
    private static BufferedReader br;

    Event(){
        name = "";
        location = "";
        priority = "";
        time = "";
    }
    public Event(String name, String location, String priority, String time){
        this.name = name;
        this.location = location;
        this.priority = priority;
        this.time = time;
    }

    public String toString(){
        return this.priority + ". " + this.name + " @ " + this.location + ". Takes " + this.time;
    }

    public String getName() {return name;}
    public String getLocation() {return location;}
    public String getPriority() {return priority;}
    public String getTime() {return time;}

    public void writeItemsToFile(String s, boolean b) throws IOException {
// Setup. s is equal to the chosen file name. b tells the method wether or not to append
        FileWriter fw = new FileWriter(s, b);
        BufferedWriter bw = new BufferedWriter(fw);
        //Write each piece of info to the chosen file, using special characters to divide the information
        bw.write(name + ",\r");
        bw.write(location + "#\r");
        bw.write(priority + "$\r");
        bw.write(time + "\r");
        bw.write(";\r");
        bw.close();
    }
}
