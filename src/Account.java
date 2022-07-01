import java.lang.System;
import java.util.ArrayList;

public class Account{

    private String accountID;
    private String password;
    private double balance;
   private double creationTime;
   public ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Account( String accountID, String password, double balance) {
        this.accountID = accountID;
        this.password = password;
        this.balance = balance;
        this.creationTime = System.currentTimeMillis();
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public double getCreationTime() {
        return creationTime;
    }


    public void depositMoney(double money, String pass) {

        if (money > 0) {
            if (pass.equals(this.password)) {
                String transType = "Deposit";
                Transaction obj = new Transaction(this.accountID, pass, transType, this.accountID, money);
                transactions.add(obj);
                double currBal = this.getBalance();
                double newbal = currBal + money;
                this.setBalance(newbal);
            } else {
                System.out.println("Incorrect Password");

            }

        }
        else
            System.out.println("ERROR: Cannot deposit zero or a negative amount!");

    }

    public void withdraw(double amount, String pass) {
        if (amount > 0) {
            if (pass.equals(this.password)) {
                if (amount < this.balance) {
                    String transType = "Withdrawal";
                    Transaction obj = new Transaction(this.accountID, pass, transType, this.accountID, amount);
                    transactions.add(obj);
                    double currBal = this.getBalance();
                    double newbal = currBal - amount;
                    this.setBalance(newbal);
                }
                else {
                    System.out.println("You have insufficient funds to make an withdrawal");
                }
            }
            else {
                System.out.println("Incorrect Password");

            }
        } else
            System.out.println("ERROR: Cannot withdraw a zero or a negative amount!");
    }

    public int NumTransactions(){
        return transactions.size();
    }

    public void displayTransactions() {
        if (NumTransactions() > 0) {
            System.out.println("Transactions: ");
            for (int i = 0; i < transactions.size(); i++) {
                System.out.println(i + 1 + ".) " + "AccountID " + transactions.get(i).getAccountID()
                        + ", Type: " + transactions.get(i).getTransactionType() + ", Recipient: "
                        + transactions.get(i).getRecipient() + ", Amount: " + transactions.get(i).getAmount());

            }
        } else
            return;

    }

}
