package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {

    public TextField TxtFldName;
    public TextField TxtFldLocation;
    public TextField TxtFldPriority;
    public TextField TxtFldTime;
    public Label LblCurrentCalendarDate;
    public DatePicker TxtFldSelectedCalendarDate;


    public ListView<Event> EventList = new ListView<>();
    public ArrayList<Event> EventList2 = new ArrayList<>();
    public ArrayList<Event> EventList2Sorted = new ArrayList<>();
    public Button BtnCreateNewEvent;


    public void createNewEvent(ActionEvent actionEvent) {
        //Create a new event object and add it to the end of the listview
        Event newEvent = new Event(TxtFldName.getText(), TxtFldLocation.getText(), TxtFldPriority.getText(), TxtFldTime.getText());
        EventList.getItems().add(newEvent);

        //Copy items from listview into an array list
        ObservableList<Event> lists = EventList.getItems();
        for (Event e : lists) {
            EventList2.add(e);}
        EventList.getItems().clear();
        //Loop organises the items in the array list into a new list, sorted by ascending order by startTime
        for (int i = 0; i < EventList2.size(); i++) {
            //Each if loop includes a size requirement to avoid an out of bounds error
            //For each item, checks if priority is smaller or equal to the priority at each index of the array list.

            if(EventList2.size() == 1){
                EventList2Sorted.add(0, EventList2.get(i));
                continue;
            }
            if(EventList2.size() > 0){
            if (Integer.parseInt(EventList2.get(i).getPriority()) <= Integer.parseInt(EventList2.get(0).getPriority())) {
                EventList2Sorted.add(0, EventList2.get(i));
                continue;
            }
            } if(EventList2.size() > 1){
            if (Integer.parseInt(EventList2.get(i).getPriority()) <= Integer.parseInt(EventList2.get(1).getPriority())) {
                EventList2Sorted.add(1, EventList2.get(i));
                continue;
            }
            } if(EventList2.size() > 2){
            if (Integer.parseInt(EventList2.get(i).getPriority()) <= Integer.parseInt(EventList2.get(2).getPriority())) {
                EventList2Sorted.add(2, EventList2.get(i));
                continue;
            }
            } if(EventList2.size() > 3){
            if(Integer.parseInt(EventList2.get(i).getPriority()) <= Integer.parseInt(EventList2.get(3).getPriority())){
                EventList2Sorted.add(3, EventList2.get(i));
                continue;}
            } if(EventList2.size() > 4){
            if(Integer.parseInt(EventList2.get(i).getPriority()) <= Integer.parseInt(EventList2.get(4).getPriority())){
                EventList2Sorted.add(4, EventList2.get(i));
                continue;}
            } if(EventList2.size() > 5) {
                if (Integer.parseInt(EventList2.get(i).getPriority()) <= Integer.parseInt(EventList2.get(5).getPriority())) {
                    EventList2Sorted.add(5, EventList2.get(i));
                }
            }
        }

        //Clears lists
        EventList.getItems().clear();
        lists.clear();
        //Copies the sorted list into the listview so it can be observed by the user.
        for(Event e : EventList2Sorted){
            EventList.getItems().add(e);}
        //Clear the lists
        EventList2.clear();
        EventList2Sorted.clear();


            //Clear all text fields
            TxtFldName.clear();
            TxtFldLocation.clear();
            TxtFldPriority.clear();
            TxtFldTime.clear();
    }

    public void setCalendarDateToSelectedDate(ActionEvent actionEvent) throws IOException {
        //Allow user to begin adding items
        BtnCreateNewEvent.setDisable(false);
        BtnCreateNewEvent.setText("Add Item");
        //Clear any preexisting items on the listview
        EventList.getItems().clear();
        //Getting the value from the date selector and setting the label of the to do list's date to this date.
        LblCurrentCalendarDate.setText(TxtFldSelectedCalendarDate.getValue().toString());
        //Adding any items that were previously saved to the file of the chosen date and adding them back to the listview
        ArrayList<Event> events = CreateEvents.createAllEvents( TxtFldSelectedCalendarDate.getValue() + ".txt");
        for (Event e : events) {
            EventList.getItems().add(e);
        }
        //Clear arraylist to avoid duplicate items
        events.clear();
    }

    public void loadTodayCalendar(ActionEvent actionEvent) throws IOException {
        //Allowing user to begin adding items
        BtnCreateNewEvent.setDisable(false);
        BtnCreateNewEvent.setText("Add Item");
        //Clear any preexisting events in the list
        EventList.getItems().clear();
        //Determine today's date and format it correctly
        LocalDate todayDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String todayDateFormatted = todayDate.format(formatter);
        //Set the calendar date to today's date
        LblCurrentCalendarDate.setText(todayDateFormatted);
        //Add any items that were previously added to today's calendar back to the listview
        ArrayList<Event> events = CreateEvents.createAllEvents( todayDateFormatted + ".txt");
        for (Event e : events) {
            EventList.getItems().add(e);
        }
        //Clear arraylist to avoid duplicate items
        events.clear();
    }

    public void deleteEvent(ActionEvent actionEvent) {
        Event newEvent;
        //Remove selected item from the listview
        newEvent = EventList.getSelectionModel().getSelectedItem();
        EventList.getItems().remove(newEvent);
    }

    public void saveCalendar(ActionEvent actionEvent) throws IOException{
        //Delete the preexisting file for the selected date to avoid duplicated items
        File deleteFile = new File(LblCurrentCalendarDate.getText() + ".txt");
        deleteFile.delete();

        ObservableList<Event> list = EventList.getItems();
        for (Event e : list) {
            //Copy each event into a file with the name of the date the events take place.
            e.writeItemsToFile(LblCurrentCalendarDate.getText() + ".txt", true);
        }
        EventList.getItems().clear();
        //Making it clear to user they no longer have a date selected
        BtnCreateNewEvent.setDisable(true);
        BtnCreateNewEvent.setText("Must Select Date Before Adding Item");
        LblCurrentCalendarDate.setText("No Date Selected");
    }
}