package com.turkcell;

public class CustomerRepo {

    private Customer[] customers;// fake database
    private int customerCount;

    public CustomerRepo() {
        customers = new Customer[100]; // max 100 customers
        customerCount = 0;
    }

    public void addCustomer(Customer customer) {
        if (customerCount < customers.length) {
            customers[customerCount] = customer;
            customerCount++;
        } else {
            System.out.println("Customer limit reached!");
        }
    }

    public Customer getCustomerById(int id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getId() == id) {
                return customers[i];
            }
        }
        return null; // not found
    }

    public Customer[] getAllCustomers() {
        Customer[] result = new Customer[customerCount];
        System.arraycopy(customers, 0, result, 0, customerCount);
        return result;
    }

    public void removeCustomerById(int id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getId() == id) {
                // Shift remaining customers left
                for (int j = i; j < customerCount - 1; j++) {
                    customers[j] = customers[j + 1];
                }
                customers[customerCount - 1] = null; // Clear last slot
                customerCount--;
                return;
            }
        }
        System.out.println("Beliritlen ID'ye sahip müşteri bulunamadı!");
    }
}
