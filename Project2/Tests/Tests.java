import org.junit.Before;
import org.junit.Test;
import sample.CreateEvents;
import sample.Event;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tests {
    //Two test events to use
    Event testEvent = new Event("Shoping", "Walmart", "2", "9 hours");
    Event testEvent2 = new Event("Cleaning", "Home", "3", "30 minutes");

    //Methods to test: eventToString
    @Before
    public void setup() {
        //Making sure all files are blank before the test is run again
        File deleteFile = new File("testFile1.txt");
        deleteFile.delete();
        File deleteFile2 = new File("textFile2.txt");
        deleteFile2.delete();

    }


    @Test
    public void testWriteItemsToFile() throws IOException {
        //Writing an event to a file using the method
        testEvent.writeItemsToFile("testFile1.txt", true);

        //Reading what the method put into the file and turning the info into a string
        String lines = "";
        FileReader fr = new FileReader("testFile1.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            lines = lines + line;
        }
        /*Checking if the string 'lines' is the expected string. It should show the special characters between each piece of
         information, but not have the returns due to the way the info was added to the 'lines' string */
        assertEquals(lines, (testEvent.name + "," + testEvent.location + "#" + testEvent.priority + "$" + testEvent.time + ";"));

    }


    @Test
    public void testCreateAllEvents() throws IOException {
        //Adding events to a file
        testEvent.writeItemsToFile("textFile2.txt", false);
        testEvent2.writeItemsToFile("textFile2.txt", true);
        //Run createAllFriends method to add info from the file back into an arraylist
        ArrayList<Event> eventsTested = CreateEvents.createAllEvents("textFile2.txt");
        //Checking all values for the two events are correct and the same as initially listed
        assertTrue(eventsTested.size() == 2);
        assertTrue((eventsTested.get(0).name).equals("Shoping"));
        assertTrue((eventsTested.get(1).name).equals("Cleaning"));
        assertTrue((eventsTested.get(0).location).equals("Walmart"));
        assertTrue((eventsTested.get(1).location).equals("Home"));
        assertTrue((eventsTested.get(0).priority).equals("2"));
        assertTrue((eventsTested.get(1).priority).equals("3"));
        assertTrue((eventsTested.get(0).time).equals("9 hours"));
        assertTrue((eventsTested.get(1).time).equals("30 minutes"));

    }

    @Test
    public void testEventToString() {
        //Checking that the .toString method prints out the event as expected
        assertEquals("2. Shoping @ Walmart. Takes 9 hours", testEvent.toString());
    }
}


