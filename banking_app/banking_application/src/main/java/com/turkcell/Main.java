package com.turkcell;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories and authenticator
        CustomerRepo customerRepo = new CustomerRepo();
        AccountRepo accountRepo = new AccountRepo();
        Authenticator authenticator = new Authenticator(customerRepo);

        // Create some customers and accounts
        Customer customer1 = new Customer("Alice", 1, "password123");
        Customer customer2 = new Customer("Bob", 2, "secure456");

        customerRepo.addCustomer(customer1);
        customerRepo.addCustomer(customer2);

        Account account1 = new Account("ACC123", 1000.0, 1);
        Account account2 = new Account("ACC456", 2000.0, 2);

        accountRepo.addAccount(account1);
        accountRepo.addAccount(account2);

        // Authenticate a customer
        boolean isAuthenticated = authenticator.authenticate(1, "password123");
        if(isAuthenticated) {
            System.out.println("Oturum açma başarılı!");
            System.out.println("Müşteri: " + customer1.getName());
            System.out.println("Hesap Numarası: " + account1.getAccountNumber());
            System.out.println("Bakiye: " + account1.getBalance());
        } else {
            System.out.println("Oturum açma başarısız!");
        }

        // Perform some transactions
        account1.deposit(500);
        System.out.println("Güncel Bakiye: " + account1.getBalance());

        account1.withdraw(200);
        System.out.println("Güncel Bakiye: " + account1.getBalance());

        // Open a new account for Alice
        Account account3 = new Account("ACC789", 0.0, 1);
        accountRepo.addAccount(account3);
        System.out.println("Yeni Hesap Numarası: " + account3.getAccountNumber());

        // Transfer money from Bob to Alice
        Account destination = accountRepo.getAccountByNumber("ACC789");
        account2.transfer(destination, 300);
        System.out.println("Bob'un Güncel Bakiye: " + account2.getBalance());
        System.out.println("Alice'in Güncel Bakiye: " + destination.getBalance());

        // List Alice's accounts
        Account[] aliceAccounts = accountRepo.getAccountsByOwnerId(1);
        System.out.println("Alice'in Hesapları:");
        for (Account acc : aliceAccounts) {
            System.out.println("- " + acc.getAccountNumber() + ": " + acc.getBalance());
        }

        // All customers in the system
        System.out.println("Tüm Müşteriler:");
        for (Customer cust : customerRepo.getAllCustomers()) {
            System.out.println("- " + cust.getName() + " (ID: " + cust.getId() + ")");
        }

        // All accounts in the system
        System.out.println("Tüm Hesaplar:");
        for (Account acc : accountRepo.getAllAccounts()) {
            System.out.println("- " + acc.getAccountNumber() + ": " + acc.getBalance() + " (Sahibi ID: " + acc.getOwnerId() + ")");
        }

        // Deleting a customer and their accounts
        customerRepo.removeCustomerById(1);
        accountRepo.removeAccountsByOwnerId(1);
        System.out.println("Alice ve hesapları silindi.");
        System.out.println("Tüm Müşteriler:");
        for (Customer cust : customerRepo.getAllCustomers()) {
            System.out.println("- " + cust.getName() + " (ID: " + cust.getId() + ")");
        }
        System.out.println("Tüm Hesaplar:");
        for (Account acc : accountRepo.getAllAccounts()) {
            System.out.println("- " + acc.getAccountNumber() + ": " + acc.getBalance() + " (Sahibi ID: " + acc.getOwnerId() + ")");
        }


    }
}