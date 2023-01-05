package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String firstName;
    private static String lastName;
    private static int age;
    private static String whereYouMet;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();
    public static ArrayList createAllFriends(String fileName) throws IOException {
        //Setup
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        /* Get the info for the first friend, add it to a string,
        and send the string to the parseFriend method. After this is completed
        Set the string to " " and get the info for the next friend */
        while((line = br.readLine()) != null){
            if(!line.equals(";")){
                friendString += line;
            }else{
                parseFriend(friendString);
                friendString = "";
            }
        }
        //return the arrayList of all the friend elements
        return friends;
    }
    private static void parseFriend(String string){
        //Setup
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        String firstName = "";
        String lastName = "";
        int age = 0;
        String whereYouMet = "";
        /*Find the position of each special character dividing the friend information,
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
            firstName = string.substring(0,pos1);
            lastName = string.substring(pos1+1,pos2);
            whereYouMet = string.substring(pos2+1,pos3);
            age = Integer.parseInt(string.substring(pos3+1));
        friends.add(new Friend(firstName, lastName, whereYouMet, age));
    }


}
