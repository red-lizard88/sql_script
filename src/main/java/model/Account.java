package model;


import java.util.Objects;

public class Account {

    private int accountId;
    private int userID;
    private int balance;
    private String currency;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userID=" + userID +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId && userID == account.userID && balance == account.balance && currency.equals(account.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, userID, balance, currency);
    }

}
