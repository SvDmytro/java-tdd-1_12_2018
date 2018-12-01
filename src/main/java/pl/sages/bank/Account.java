package pl.sages.bank;

public class Account {

    private long accountNumber;
    private String ownerName;

    private long balance = 0;

    public Account(long accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
    }

    public void addMoney(long money) {
        balance+=money;
    }

    public void subMoney(long money) {
        balance-=money;
    }

    // ----------------------------

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
