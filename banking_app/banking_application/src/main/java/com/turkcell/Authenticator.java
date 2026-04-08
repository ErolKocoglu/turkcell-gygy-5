package com.turkcell;

public class Authenticator {

    private CustomerRepo customerRepo;

    public Authenticator(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public boolean authenticate(int id, String password) {
        Customer customer = customerRepo.getCustomerById(id);
        if (customer != null && customer.getPassword().equals(password)) {
            return true; // Authentication successful
        }
        return false; // Authentication failed
    }
}
