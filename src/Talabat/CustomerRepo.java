package Talabat;

import java.util.ArrayList;

public class CustomerRepo {
    private static ArrayList<Customer> customerList = new ArrayList<Customer>();

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public static void addCustomer (Customer customer){
        customerList.add(customer);
    }

    public static void editCustomer(Customer oldCustomer, Customer newCustomer){
        customerList.remove(oldCustomer);
        customerList.add(newCustomer);
    }

    public static void deletecustomer(Customer customer){
        customerList.remove(customer);
    }
}
