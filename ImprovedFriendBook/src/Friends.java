public class Friends {
    public String firstName;
    public String lastName;
    public int age;
    public String whereYouMet;

    Friends(String firstName, String lastName, int age, String whereYouMet){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.whereYouMet = whereYouMet;
    }

    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
