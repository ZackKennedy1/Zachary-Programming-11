import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static int scanForWord(String word) throws IOException {
        //Setup
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("in.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int counter = 0;
        //Adding each line as an element in the array list
        while((line = br.readLine()) != null){
            lines.add(line);
        }

        System.out.print("Index Positions where the word appears: " );
        /*Going through every index position and seeing if it contains the given word
        if it does, print out the index position where it appears. */
        for (String a : lines){
                if(a.contains(word)){
                    System.out.print(lines.indexOf(a) + " ");
                }
            }
        //Printing out an extra line to help the formatting
        System.out.println(" ");

        /*Going through every string in the array list and checking every group of continuous index
        positions long enough to contain the given word. */
        for (String a : lines){
            for(int e = 0; e < a.length()-word.length(); e++){
                String f = a.substring(e, e+word.length());
                //If the specific substring equals the word, print out the line number where it appears(array lists start at 0, so adding 1 while give the actual line number)
                if(f.equals(word)){
                    System.out.println(word + " can be found on line number: " + (lines.indexOf(a) + 1));
                    //Add one to the number of times the word appears in the text file.
                    counter = counter+1;
                }
            }
        }
        //Show user how many times word appears in text file
        System.out.println("Number of time the word appears in the text: " + counter);
        return counter;
    }


            public static void main(String[] args) throws IOException {
        //Setup
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("in.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        //Adding each line as element of the arraylist
        while((line = br.readLine()) != null){
            lines.add(line);
        }
        //Printing out arraylist to show that the above code worked properly
        for(String a : lines){
            System.out.println(a);
        }
        //Run method using the provided word to scan for where and how often the word appears in the text file
        scanForWord("allow");


    br.close();
    }
}