package Talabat;

import java.util.ArrayList;

public class CustomerRepo {
    private static Presentable presenter;

    public static void setPresenter(Presentable p){
        presenter = p;
    }

    private static ArrayList<Customer> customerList = new ArrayList<Customer>();

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public static void addCustomer (Customer customer){
        customerList.add(customer);
    }

    public static Customer findCustomer(Customer customer){
        int index = getCustomerList().indexOf(customer);
        if (index == -1)
            return null;
        else
            return getCustomerList().get(index);
    }

    public static void editCustomer(Customer oldCustomer, Customer newCustomer){
        customerList.remove(oldCustomer);
        customerList.add(newCustomer);
    }

    public static void deletecustomer(Customer customer){
        customerList.remove(customer);
    }

    public static void dummyData(){
        customerList.add(new Customer("user1", "pass1", false, "Ahmed Ali",
                "Nasr City", "0111111111", "user1@mail.com",
                new ArrayList<>(), presenter));

        customerList.add(new Customer("user2", "pass2", false, "Sara Mohamed",
                "Heliopolis", "0111111112", "user2@mail.com",
                new ArrayList<>(), presenter));

        customerList.add(new Customer("user3", "pass3", false, "Omar Hassan",
                "Maadi", "0111111113", "user3@mail.com",
                new ArrayList<>(), presenter));

        customerList.add(new Customer("user4", "pass4", false, "Mona Khaled",
                "Zamalek", "0111111114", "user4@mail.com",
                new ArrayList<>(), presenter));

        customerList.add(new Customer("user5", "pass5", false, "Youssef Adel",
                "New Cairo", "0111111115", "user5@mail.com",
                new ArrayList<>(), presenter));

        customerList.add(new Customer("user6", "pass6", false, "Nour Tarek",
                "Dokki", "0111111116", "user6@mail.com",
                new ArrayList<>(), presenter));

        customerList.add(new Customer("user7", "pass7", false, "Karim Samy",
                "Shoubra", "0111111117", "user7@mail.com",
                new ArrayList<>(), presenter));

        customerList.add(new Customer("user8", "pass8", false, "Laila Mostafa",
                "Giza", "0111111118", "user8@mail.com",
                new ArrayList<>(), presenter));

        customerList.add(new Customer("user9", "pass9", false, "Hassan Fathy",
                "6th October", "0111111119", "user9@mail.com",
                new ArrayList<>(), presenter));

        customerList.add(new Customer("user10", "pass10", false, "Dina Wael",
                "Mohandessin", "0111111120", "user10@mail.com",
                new ArrayList<>(), presenter));    }
}
