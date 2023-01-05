package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    public TextField txtfldAge;
    public Button btnCreateFriend;
    public TextField txtfldFirstName;
    public TextField txtfldLastName;
    public TextField txtHowYouMet;
    public ListView<Friend> friendList = new ListView<>();
    public Button btnDeleteFriend;
    public Label displayFriendName;
    public Label displayFriendAge;
    public Label displayWhereYouMet;

    public void createFriend(ActionEvent actionEvent) {
        //Creating a new friend with the values written in and adding it to the friend list
        Friend newFriend = new Friend(txtfldFirstName.getText(), txtfldLastName.getText(), txtHowYouMet.getText(), Integer.parseInt(txtfldAge.getText()));
        friendList.getItems().add(newFriend);
        //Clear all fields so new values can be added
        txtfldFirstName.clear();
        txtfldLastName.clear();
        txtHowYouMet.clear();
        txtfldAge.clear();
    }

    public void deleteFriend(ActionEvent actionEvent) {
        //Getting the selected friend and removing it from the friend list
        Friend newFriend;
        newFriend = friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(newFriend);
        //Making the friend information section blank
        displayFriendName.setText("");
        displayFriendAge.setText("");
        displayWhereYouMet.setText("");
    }

    public void displayFriendInformation(Event event) {
        //Getting the selected friend
        Friend newFriend;
        newFriend = friendList.getSelectionModel().getSelectedItem();
        //Setting the text to the values of the selected friend
        displayFriendName.setText(newFriend.getfirstName() + " " + newFriend.getlastName());
        displayFriendAge.setText(Integer.toString(newFriend.getAge()));
        displayWhereYouMet.setText(newFriend.getWhereYouMet());
    }

    public void AddSaveFile1(ActionEvent actionEvent) throws IOException {
        //Writing each friend in the friendList to Save File 1
        ObservableList<Friend> list = friendList.getItems();
        for (Friend f : list) {
            f.writeToFile("friendslist1.txt", true);
        }
        //Clear friend list so that user can start a new list
        friendList.getItems().clear();
    }
    public void ReplaceSaveToFile1(ActionEvent actionEvent) throws IOException {
        //Writing each friend in the friendList to Save File 1, but not appending the file
        ObservableList<Friend> list = friendList.getItems();
        for (Friend f : list) {
            f.writeToFile("friendslist1.txt", false);
        }
        //Clear friend list so that user can start a new list
        friendList.getItems().clear();
    }

    public void LoadInfo1(ActionEvent actionEvent) throws IOException {
        friendList.getItems().clear();
        //Adding each friend in the selected file to the friend list
        ArrayList<Friend> friends = CreateFriend.createAllFriends("friendslist1.txt");
        for (Friend f : friends) {
            friendList.getItems().add(f);
        }
    }

    public void AddSaveFile2(ActionEvent actionEvent) throws IOException {
        //Writing each friend in the friendList to Save File 2
        ObservableList<Friend> list = friendList.getItems();
        for (Friend f : list) {
            f.writeToFile("friendslist2.txt", true);
        }
        //Clear friend list so that user can start a new list
        friendList.getItems().clear();
    }
    public void ReplaceSaveToFile2(ActionEvent actionEvent) throws IOException {
        //Writing each friend in the friendList to Save File 2, but not appending the file
        ObservableList<Friend> list = friendList.getItems();
        for (Friend f : list) {
            f.writeToFile("friendslist2.txt", false);
        }
        //Clear friend list so that user can start a new list
        friendList.getItems().clear();
    }

    public void LoadInfo2(ActionEvent actionEvent) throws IOException {
        friendList.getItems().clear();
        //Adding each friend in the selected file to the friend list
        ArrayList<Friend> friends = CreateFriend.createAllFriends("friendslist2.txt");
        for (Friend f : friends) {
            friendList.getItems().add(f);
        }
    }

    public void AddSaveFile3(ActionEvent actionEvent) throws IOException {
        //Writing each friend in the friendList to Save File 3
        ObservableList<Friend> list = friendList.getItems();
        for (Friend f : list) {
            f.writeToFile("friendslist3.txt", true);
        }
        //Clear friend list so that user can start a new list
        friendList.getItems().clear();
    }
    public void ReplaceSaveToFile3(ActionEvent actionEvent) throws IOException {
        //Writing each friend in the friendList to Save File 3, but not appending the file
        ObservableList<Friend> list = friendList.getItems();
        for (Friend f : list) {
            f.writeToFile("friendslist3.txt", false);
        }
        //Clear friend list so that user can start a new list
        friendList.getItems().clear();
    }

    public void LoadInfo3(ActionEvent actionEvent) throws IOException {
        friendList.getItems().clear();
        //Adding each friend in the selected file to the friend list
        ArrayList<Friend> friends = CreateFriend.createAllFriends("friendslist3.txt");
        for (Friend f : friends) {
            friendList.getItems().add(f);
        }
    }

}
