package com.turkcell;

public class AccountRepo {

    private Account[] accounts;// fake database
    private int accountCount;

    public AccountRepo() {
        accounts = new Account[100]; // max 100 accounts
        accountCount = 0;
    }

    public void addAccount(Account account) {
        if (accountCount < accounts.length) {
            accounts[accountCount] = account;
            accountCount++;
        } else {
            System.out.println("Account limit reached!");
        }
    }

    public Account getAccountByNumber(String number) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(number)) {
                return accounts[i];
            }
        }
        return null; // not found
    }

    public Account[] getAllAccounts() {
        Account[] result = new Account[accountCount];
        System.arraycopy(accounts, 0, result, 0, accountCount);
        return result;
    }

    public Account[] getAccountsByOwnerId(int ownerId) {
        Account[] result = new Account[accountCount];
        int count = 0;
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getOwnerId() == ownerId) {
                result[count] = accounts[i];
                count++;
            }
        }
        // Create a new array with the actual number of accounts found
        Account[] finalResult = new Account[count];
        System.arraycopy(result, 0, finalResult, 0, count);
        return finalResult; // return the array of accounts owned by the specified ownerId
    }

    public void removeAccountsByOwnerId(int ownerId) {
        int i = 0;
        while (i < accountCount) {
            if (accounts[i].getOwnerId() == ownerId) {
                // Shift remaining accounts left
                for (int j = i; j < accountCount - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                accounts[accountCount - 1] = null; // Clear last slot
                accountCount--;
            } else {
                i++;
            }
        }
    }

}
