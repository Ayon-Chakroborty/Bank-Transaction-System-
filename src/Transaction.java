public class Transaction {

   String accountID;
    String password;
    String transactionType;
    String recipient;
    double amount;
    double creationTime;

    public Transaction(String accountID, String password, String transactionType, String recipient, double amount) {
        this.accountID = accountID;
        this.password = password;
        this.transactionType = transactionType;
        this.recipient = recipient;
        this.amount = amount;
        this.creationTime = System.currentTimeMillis();
    }

    public String getAccountID() {
        return accountID;
    }

    public String getPassword() {
        return password;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getCreationTime() {
        return creationTime;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
