package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateEvents {
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Event> events = new ArrayList<>();
    public static ArrayList createAllEvents(String fileName) throws IOException {
        //Setup
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String eventString = "";
        /* Get the info for the first event, add it to a string,
        and send the string to the parseEvent method. After this is completed
        Set the string to " " and get the info for the next event */
        while((line = br.readLine()) != null){
            if(!line.equals(";")){
                eventString += line;
            }else{
                parseEvent(eventString);
                eventString = "";
            }
        }
        //return the arrayList of all the item elements
        return events;
    }
    private static void parseEvent(String string){
        //Setup
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        String name = "";
        String location = "";
        String priority = "";
        String time = "";
        /*Find the position of each special character dividing the event information,
        and set a pos value to its position in the string */
        for(int i = 0;i<string.length();i++) {
            if (string.substring(i, i + 1).equals(",")) {
                pos1 = i;
            }
            if (string.substring(i, i + 1).equals("#")) {
                pos2 = i;
            }
            if (string.substring(i, i + 1).equals("$")) {
                pos3 = i;
            }
        }
        /* Using the special characters, find the position in the string each piece of information is
            and set variables to these parts of the string */
        name = string.substring(0,pos1);
        location = string.substring(pos1+1,pos2);
        priority = string.substring(pos2+1,pos3);
        time = string.substring(pos3+1);
        events.add(new Event(name, location, priority, time));
    }
}
