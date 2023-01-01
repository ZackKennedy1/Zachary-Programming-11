import java.util.Date;
public class Main {
public static void main(String[] args){
    //Create a new customer and add intial deposits into each account
    Customer customer = new Customer("Zack", 14, 1000, 1000);
    //Add a deposit into each account
    customer.deposit(300, new Date(), "Checking");
    customer.deposit(400, new Date(), "Saving");
    //Print out all the deposit objects
    customer.displayDeposits();
    //Withdraw from each account
    customer.withdraw(250, new Date(), "Checking");
    customer.withdraw(100, new Date(), "Saving");
    //Print out all withdraw objects
    customer.displayWithdraws();


}
}