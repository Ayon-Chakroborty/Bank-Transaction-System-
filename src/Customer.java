import java.util.ArrayList;

public class Customer {
    private String name;
   private String dateOfBirth;
   private String customerID;
   public ArrayList<Account> accounts = new ArrayList<>();

    public Customer(String name, String dateOfBirth, String customerID) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getNumOfAccounts() {
        return accounts.size();
    }

    public void createAccount(String accountID, String password, double balance){
        if(accounts.size() < 3) {
            for(int i = 0; i < accounts.size(); i++){
                if(accountID.equals(accounts.get(i).getAccountID())){
                    System.out.println("This account already exists, change the account ID!");
                    return;
                }
            }
            Account obj = new Account( accountID, password, balance);
            accounts.add(obj);
        }
        else
            System.out.println( this.name + " can't have more than 3 accounts!");
    }

    public void displayInfo(){
        System.out.println("Customer: " + this.getName());
        System.out.println("CustomerID: " + this.getCustomerID());
        System.out.println("Date of Birth: " + this.dateOfBirth);
        System.out.println("Number of Accounts: " + accounts.size());
        System.out.println("Account information: ");
        for(int i = 0; i < accounts.size(); i++){
            System.out.println(accounts.get(i).getAccountID() + ", Balance: " + accounts.get(i).getBalance() + ", Transactions: "
                    + accounts.get(i).NumTransactions() + ", CreationTime: " + accounts.get(i).getCreationTime());
        }
    }

    public int doesAccExist(String accountID){
        for(int i = 0; i < accounts.size(); i++){
            if(accountID.equals(accounts.get(i).getAccountID())){
                return i;
            }
        }
        System.out.println("Account " + accountID + " not found!");
        return -1;
    }

    public void displayTransactions(){
        for(int i = 0; i < accounts.size(); i++){
            accounts.get(i).displayTransactions();
        }
    }

}
