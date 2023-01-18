import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static int scanForWord(String word) throws IOException {
        //Setup
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        //Creating string variations, so it only counts the individual word, not when it's a part of a larger word
        String wordVariation1 = " " + word + " ";
        String wordVariation2 = " " + word + ",";
        String wordVariation3 = " " + word + ".";
        String wordVariation4 = " " + word + ";";
        String wordVariation5 = word + " ";
        String wordVariation6 = word + ",";
        int counter = 0;
        //Adding each line as an element in the array list
        while((line = br.readLine()) != null){
            lines.add(line);
        }

        System.out.print("Index Positions where the word appears: " );
        /*Going through every index position of the array list and seeing if it contains the given word
        if it does, print out the index position where it appears. */
        for (String a : lines){
            if(a.toLowerCase().contains(wordVariation1.toLowerCase())){
                System.out.print(lines.indexOf(a) + " ");
            }
            if(a.toLowerCase().contains(wordVariation2.toLowerCase())){
                System.out.print(lines.indexOf(a) + " ");
            }
            if(a.toLowerCase().contains(wordVariation3.toLowerCase())){
                System.out.print(lines.indexOf(a) + " ");
            }
            if(a.toLowerCase().contains(wordVariation4.toLowerCase())){
                System.out.print(lines.indexOf(a) + " ");
            }

            //Checking specifically if the line starts with the word, then a space or a comma because the other word variations would skip over it.
            if(a.toLowerCase().startsWith(wordVariation5.toLowerCase())) {
                System.out.print(lines.indexOf(a) + " ");
            }
            if(a.toLowerCase().startsWith(wordVariation6.toLowerCase())) {
                System.out.print(lines.indexOf(a) + " ");
            }
        }
        //Printing out an extra line to help the formatting
        System.out.println(" ");

        /*Going through every string in the array list and checking every group of continuous index
        positions long enough to contain the given word. */
        for (String a : lines){
            /*Checking specifically if the string starts with the word, followed by a space or a comma
            because this is not covered through the other loop */
            if(a.toLowerCase().startsWith(word.toLowerCase() + " ")){
                System.out.println(word + " can be found on line number: " + (lines.indexOf(a) + 1));
                //Add one to the number of times the word appears in the text file.
                counter = counter+1;
            }
            if(a.toLowerCase().startsWith(word.toLowerCase() + ",")){
                System.out.println(word + " can be found on line number: " + (lines.indexOf(a) + 1));
                //Add one to the number of times the word appears in the text file.
                counter = counter+1;
            }

            //Seeing if any set of continuous index positions in the string are equal to an acceptable variation of the word.
            for(int e = 1; e < a.length()-word.length()-1; e++){
                String f1 = a.substring(e-1, (e+word.length())+1);
                //If the specific substring equals the word, print out the line number where it appears(array lists start at 0, so adding 1 will give the actual line number)
                if(f1.toLowerCase().equals(" " + word.toLowerCase() + " ")){
                    System.out.println(word + " can be found on line number: " + (lines.indexOf(a) + 1));
                    //Add one to the number of times the word appears in the text file.
                    counter = counter+1;
                }
                if(f1.toLowerCase().equals(" " + word.toLowerCase() + ",")){
                    System.out.println(word + " can be found on line number: " + (lines.indexOf(a) + 1));
                    //Add one to the number of times the word appears in the text file.
                    counter = counter+1;
                }
                if(f1.toLowerCase().equals(" " + word.toLowerCase() + ".")){
                    System.out.println(word + " can be found on line number: " + (lines.indexOf(a) + 1));
                    //Add one to the number of times the word appears in the text file.
                    counter = counter+1;
                }
                if(f1.toLowerCase().equals(" " + word.toLowerCase() + ";")){
                    System.out.println(word + " can be found on line number: " + (lines.indexOf(a) + 1));
                    //Add one to the number of times the word appears in the text file.
                    counter = counter+1;
                }
            }
        }
        //Show user how many times word appears in text file
        System.out.println("Number of times the word appears in the text: " + counter);
        return counter;
    }


    public static void main(String[] args) throws IOException {
        //Setup
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
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
        scanForWord("A");

        br.close();
    }
}