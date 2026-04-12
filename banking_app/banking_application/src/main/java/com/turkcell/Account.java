package com.turkcell;

public class Account {

    private String accountNumber;
    private double balance;
    private int ownerId;

    public Account(String accountNumber, double balance, int ownerId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerId = ownerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Hesaba yatırılan miktar: " + amount);
        } else {
            System.out.println("Geçersiz yatırma miktarı.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Çekilen miktar: " + amount);
        } else {
            System.out.println("Geçersiz çekim miktarı veya yetersiz bakiye.");
        }
    }

    public void transfer(Account targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
            System.out.println("Transfer edilen miktar: " + amount + " Hedef Hesap: " + targetAccount.getAccountNumber());
        } else {
            System.out.println("Geçersiz transfer miktarı veya yetersiz bakiye.");
        }
    }
}
