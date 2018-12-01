package pl.sages.bank;


import java.util.HashMap;
import java.util.Map;

public class Bank {

    private String name;
    private Map<Long, Account> accounts = new HashMap<>();

    public Bank(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void transferMoney(long from, long to, long money) {
        accounts.get(from).subMoney(money);
        accounts.get(to).addMoney(money);
    }

    public Account getAccount(long accountNumber) {
        return accounts.get(accountNumber);
    }
}
