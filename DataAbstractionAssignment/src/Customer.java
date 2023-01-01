import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
        name = "";
        accountNumber = 0;
        checkBalance = 0;
        savingBalance = 0;
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();
        this.name = name;
        this.accountNumber = accountNumber;
        checkBalance = 0;
        savingBalance = 0;
        deposit(checkDeposit, new Date(), CHECKING);
        deposit(savingDeposit, new Date(), SAVING);
    }

    //Requires: amt>=0, current date, account Checking or Saving
    // Modifies:this,deposits
    // Effects: add amt to the chosen account. Creates a new deposit object and adds it to the deposits arrayList.
    public double deposit(double amt, Date date, String account){
        this.deposits.add(new Deposit(amt, date, account));
        if (account.equals(CHECKING)) {
            checkBalance = checkBalance + amt;
        }
        if (account.equals(SAVING)) {
            savingBalance = savingBalance + amt;
        }
        return 0;
    }

    //Requires: amt>=0, current date, account Checking or Saving
    // Modifies: this,withdraws
    // Effects: removes amt from chosen account if it stays within the overdraft limit. Creates a new withdraw object and adds it to the withdraws arrayList.
    public double withdraw(double amt, Date date, String account){
        if(checkOverdraft(amt, account) == true){
            System.out.println("You do not have enough money to withdraw");
        }
        else {
            Withdraw customerWithdraw = new Withdraw(amt, date, account);
            withdraws.add(customerWithdraw);
            if (account.equals(CHECKING)) {
                checkBalance = checkBalance - amt;
            }
            if (account.equals(SAVING)) {
                savingBalance = savingBalance - amt;
            }
        }
        return 0;
    }

    private boolean checkOverdraft(double amt, String account) {
        if (account.equals("Checking")) {
            if (checkBalance >= amt + OVERDRAFT) {
                return false;
            }
            else{
                return true;
            }
            }
        else if (account.equals("Saving")) {
            if (savingBalance >= amt + OVERDRAFT) {
                return false;
            }
        }
        return true;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    //Getters to use while testing
    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }
}

