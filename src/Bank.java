import java.util.ArrayList;

public class Bank {

    private String bankID;
    private String Address;
    public ArrayList<Customer> customers = new ArrayList<>();

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Bank(String bankID, String address) {
        this.bankID = bankID;
        Address = address;
    }

    public void addNewCustomer(String name, String DoB, String id){
        for(int i = 0; i < customers.size(); i++){
            if(id.equals(customers.get(i).getCustomerID())){
                System.out.println("This customer already exists, cannot add customer!");
                return;
            }
        }
        Customer obj = new Customer(name, DoB, id);
        customers.add(obj);
    }

    public void displayAccounts(){
        for(int i = 0; i < customers.size(); i++){
            customers.get(i).displayInfo();
            System.out.println("----------------------------------------------------------------");
        }
    }

    public void addNewAccount(String customerID, String userName, String pass, double bal){
        for(int i = 0; i < customers.size(); i++){
            if(customerID.equals(customers.get(i).getCustomerID())){
                customers.get(i).createAccount(userName, pass, bal);
                break;
            }
        }
    }

    public int getTotalAccounts(){
        int total = 0;
        for(int i = 0; i < customers.size(); i++){
            total += customers.get(i).getNumOfAccounts();
        }

        return total;
    }

    public void send(String customerID, String accountID, double money, String recipientID, String recipientAccountID, String pass1, String pass2) {
        int cIndex = doesCustomerExist(customerID);
        if (cIndex != -1) {
            int aIndex = customers.get(cIndex).doesAccExist(accountID);
            if (aIndex != -1) {
                customers.get(cIndex).accounts.get(aIndex).withdraw(money, pass1);
            }
        }

        int cIndex2 = doesCustomerExist(recipientID);
        if (cIndex2 != -1) {
            int aIndex2 = customers.get(cIndex2).doesAccExist(recipientAccountID);
            if (aIndex2 != -1) {
                customers.get(cIndex2).accounts.get(aIndex2).depositMoney(money, pass2);
            }
        }
    }

    public void deposit_amount(double money, String accID, String cusID, String pass){
        int cIndex = doesCustomerExist(cusID);
        if (cIndex != -1) {
            int aIndex = customers.get(cIndex).doesAccExist(accID);
            if (aIndex != -1) {
                customers.get(cIndex).accounts.get(aIndex).depositMoney(money, pass);
            }
        }
    }

    public void withdraw_amount(double money, String accID, String cusID, String pass){
        int cIndex = doesCustomerExist(cusID);
            if (cIndex != -1) {
                int aIndex = customers.get(cIndex).doesAccExist(accID);
                    if (aIndex != -1) {
                            customers.get(cIndex).accounts.get(aIndex).withdraw(money, pass);

                    }
            }
    }


    public void balanceCheck(String cusID){
        for(int i = 0; i < customers.size(); i++){
            if(cusID.equals(customers.get(i).getCustomerID())){
                for(int j = 0; j < customers.get(i).getNumOfAccounts(); j++){
                    System.out.println(customers.get(i).accounts.get(j).getAccountID() + " Balance: "+ customers.get(i).accounts.get(j).getBalance());
                }
            }
        }

    }


    public int doesCustomerExist(String customerID){
        for(int i = 0; i < customers.size(); i++){
            if(customerID.equals(customers.get(i).getCustomerID())){
                return i;
            }
        }

        System.out.println("Customer does not exist with this Bank");
        return -1;
    }

    public void displayTransactions(){
        for(int i = 0; i < customers.size(); i++){
            System.out.println(customers.get(i).getName());
            customers.get(i).displayTransactions();
        }
    }

}
