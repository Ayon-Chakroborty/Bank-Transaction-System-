import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Bank PNC = new Bank("PNC", "123 Green St");
        System.out.println("Welcome to " + PNC.getBankID() + " bank at " + PNC.getAddress());

        System.out.println();
        System.out.println();
        System.out.println("================Creating Customers================");
        PNC.addNewCustomer("User1", "01/01/2001", "123");
        PNC.addNewCustomer("User2", "12/12/2012", "456");
        System.out.println("=======Creating a customer with an existing ID==========");
        PNC.addNewCustomer("User2", "12/12/2012", "456");
        PNC.displayAccounts();
        System.out.println("====================================================");


        System.out.println();
        System.out.println();

        System.out.println("===================Creating Accounts========================");
        PNC.addNewAccount("123", "testUserAc1", "testPass", 1000.00);
        PNC.addNewAccount("456", "testUserAc2", "testPass2", 2000.00);
        PNC.displayAccounts();
        System.out.println("====================================================================");


        System.out.println();
        System.out.println();


        System.out.println("========================Creating an account with the same account ID==============================");
        PNC.addNewAccount("123", "testUserAc1", "testPass", 1000.00);
        PNC.displayAccounts();
        System.out.println("======================================================");

        System.out.println();
        System.out.println();

        System.out.println("=======================Creating more than three accounts========================");
        PNC.addNewAccount("123", "testUserAc3", "testPass", 1000.00);
        PNC.addNewAccount("123", "testUserAc4", "testPass", 1000.00);
        PNC.addNewAccount("123", "testUserAc5", "testPass", 1000.00);
        System.out.println("==============================================================================");

        System.out.println();
        System.out.println();

        System.out.println("==========Depositing Money====================================");
        PNC.deposit_amount(700.00, "testUserAc1", "123", "testPass");
        PNC.displayAccounts();
        System.out.println("==============================================================");

        System.out.println();
        System.out.println();

        System.out.println("==================Depositing to an invalid customer===============================");
        PNC.deposit_amount(700.00, "testUserAc1", "999", "testPass");
        System.out.println("===================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("==================Depositing to an invalid Account===============================");
        PNC.deposit_amount(700.00, "testUser", "123", "testPass");
        System.out.println("===================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("==================Depositing to an invalid Password===============================");
        PNC.deposit_amount(700.00, "testUserAc1", "123", "incorrectPass");
        System.out.println("===================================================================================");

        System.out.println("==========Withdrawing Money====================================");
        PNC.withdraw_amount(700.00, "testUserAc1", "123", "testPass");
        PNC.displayAccounts();
        System.out.println("==============================================================");

        System.out.println();
        System.out.println();

        System.out.println("==================Withdrawing to an invalid customer===============================");
        PNC.withdraw_amount(700.00, "testUserAc1", "999", "testPass");
        System.out.println("===================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("==================Withdrawing to an invalid Account===============================");
        PNC.withdraw_amount(700.00, "testUser", "123", "testPass");
        System.out.println("===================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("==================Withdrawing to an invalid Password===============================");
        PNC.withdraw_amount(700.00, "testUserAc1", "123", "incorrectPass");
        System.out.println("===================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("==================Withdrawing to an invalid Amount (Zero)==========================");
        PNC.withdraw_amount(0.00, "testUserAc1", "123", "testPass");
        System.out.println("===================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("================Withdrawing more than the balance====================");
        PNC.withdraw_amount(2000.00, "testUserAc1", "123", "testPass");
        System.out.println("===============================================================================");

        System.out.println();
        System.out.println();

        System.out.println("================Withdrawing to an invalid Amount (Negative)====================");
        PNC.withdraw_amount(-700.00, "testUserAc1", "123", "testPass");
        System.out.println("===============================================================================");

        System.out.println();
        System.out.println();

        System.out.println("==================Withdrawing without customer info==========================");
        PNC.withdraw_amount(0.00, "testUserAc1", " ", "testPass");
        System.out.println("===================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("==================Withdrawing without Account info==========================");
        PNC.withdraw_amount(0.00, " ", "123", "testPass");
        System.out.println("===================================================================================");

        PNC.displayAccounts();
        System.out.println();
        System.out.println();


        System.out.println("===========================Sending money========================================");
        PNC.send("123", "testUserAc1", 200.00, "456", "testUserAc2","testPass", "testPass2");
        PNC.displayAccounts();
        System.out.println("==================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("===========================Sending money with invalid info========================================");
        PNC.send("23", "testserAc1", 200.00, "456", "testUserA","tesPass", "testPass2");
        System.out.println("===========================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("===========================Sending money with no info========================================");
        PNC.send("", "", 200.00, "", "","", "");
        System.out.println("========================================================================================");

        System.out.println();
        System.out.println();

        System.out.println("=================================Lookup non-existing account/customer===========================");
        PNC.doesCustomerExist("934");
        System.out.println("=================================Lookup non-existing account/customer===========================");

        PNC.displayTransactions();


    }

}
