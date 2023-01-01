import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Date;
import java.util.ArrayList;

public class Testing {
    Customer test;
    Date newDate;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";


    @Before
    public void setup(){
        test = new Customer("Zack", 1, 500, 500);

        Date newDate;
    }

    @Test
    public void testDeposittoString() {
        //Make a new deposit into the savings account
        Deposit testDeposit = new Deposit(200, new Date(), SAVING);
        //Checking that the deposit string made by the code is the same as what I expect the result to be
        assertEquals(testDeposit.toString(), "Deposit of: $200.0 Date: " + new Date() + " into account: Saving");

        //Make a new deposit into the checking account
        Deposit testDeposit2 = new Deposit(900, new Date(), CHECKING);
        //Checking that the deposit string made by the code is the same as what I expect the result to be
        assertEquals(testDeposit2.toString(), "Deposit of: $900.0 Date: " + new Date() + " into account: Checking");
    }

    @Test
    public void testWithdrawtoString(){
        //Make a new withdraw out of the savings account
        Withdraw testWithdraw = new Withdraw(200, new Date(), SAVING);
        // Checking that the withdraw string made by the code is the same as what I expect the result to be
        assertEquals(testWithdraw.toString(), "Withdraw of: $200.0 Date: " + new Date() + " into account: Saving");

        //Make a new withdraw out the checking account
        Withdraw testWithdraw2 = new Withdraw(500, new Date(), CHECKING);
        // Checking that the withdraw string made by the code is the same as what I expect the result to be
        assertEquals(testWithdraw2.toString(), "Withdraw of: $500.0 Date: " + new Date() + " into account: Checking");


    }
   @Test
    public void testCustomerdeposit() {
        //Making sure both the checking and saving accounts have values of $500
       assertTrue(test.getCheckBalance() == 500);
       assertTrue(test.getSavingBalance() == 500);
       //There should now be two deposit objects from the inital creation of the customer
       //There should now be two deposit objects
       assertTrue(test.getDeposits().size() == 2);
       //Deposit money into both the checking and saving accounts and making sure they still have the correct totals
        test.deposit(500, new Date(), "Checking");
        assertTrue(test.getCheckBalance() == 1000);
        test.deposit(1375, new Date(), "Saving");
        assertTrue(test.getSavingBalance() == 1875);
        //There should now be four deposit objects
       assertTrue(test.getDeposits().size() == 4);
    }
    @Test
    public void testCustomerwithdraw(){
        //Making sure both the checking and saving accounts have values of $500
        assertTrue(test.getCheckBalance() == 500);
        assertTrue(test.getSavingBalance() == 500);
        //Withdraw money from both accounts and make sure they still have the correct total
        test.withdraw(565, new Date(), "Saving");
        assertTrue(test.getSavingBalance() == -65);
        test.withdraw(125, new Date(), "Checking");
        assertTrue(test.getCheckBalance() == 375);
        //There should now be two withdraw objects
        assertTrue(test.getWithdraws().size() == 2);
        //Testing in both accounts that if you attempt to withdraw more money than the overdraft allows, it won't allow you
        test.withdraw(10000, new Date(), "Checking");
        //The withdraw method should not have worked, therefore the check balance should not have changed from earlier
        assertTrue(test.getCheckBalance() == 375);
        //It should also not create a new withdraw object, so there should still only be two withdraw objects
        assertTrue(test.getWithdraws().size() == 2);


    }
}
