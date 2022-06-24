package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class CustomerService {
    //use collection
    //private static final ArrayList<Customer> customers = new ArrayList<>();
    private static final  Collection<Customer> customers = new LinkedList<>();

    public static void addCustomer(String email, String firstName, String lastName){
        if (getCustomer(email) != null) throw new IllegalArgumentException("Email already registered");
        Customer customer = new Customer(firstName, lastName, email);
        customers.add(customer);
    }
    public static Customer getCustomer(String customerEmail) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
        return null;
    }
    public static Collection<Customer> getAllCustomers(){
        return customers;
    }
}
