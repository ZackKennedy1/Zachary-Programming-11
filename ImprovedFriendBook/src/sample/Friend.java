package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    public String firstName;
    public String lastName;
    public int age;
    public String whereYouMet;


    Friend(String firstName, String lastName, String whereYouMet, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.whereYouMet = whereYouMet;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getWhereYouMet() {
        return whereYouMet;
    }




    public void writeToFile(String s,boolean b) throws IOException {
/* Setup. s is equal to the chosen file name.
b is equal to true if the user wants to add to the chosen file, false if they want to replace info */
        FileWriter fw = new FileWriter(s, b);
        BufferedWriter bw = new BufferedWriter(fw);
        //Write each piece of info to the chosen file, using special characters to divide the information
        bw.write(firstName + ",\r");
        bw.write(lastName + "#\r");
        bw.write(whereYouMet + "$\r");
        bw.write(Integer.toString(age) + "\r");
        bw.write(";\r");
        bw.close();
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
