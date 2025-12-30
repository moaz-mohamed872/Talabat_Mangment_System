package Talabat;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin  {

    private Presentable presenter;

    public Admin(Presentable presenter) {
        this.presenter = presenter;
    }

    public void adminMenu() {
        String choice;

        do {
            presenter.print("\n====== ADMIN MENU ======\n" +
                    "1. View Customers\n" +
                    "2. View Restaurants\n" +
                    "3. Add Restaurant\n" +
                    "4. Edit Restaurant\n" +
                    "5. Edit Customer\n" +
                    "6. Remove Customer\n" +
                    "0. Logout \n");

            choice = presenter.read();

            if (choice.equals("1"))
                viewCustomerList(CustomerRepo.getCustomerList());
            else if (choice.equals("2"))
                viewResList(ResturantRepo.getResturantlist());
            else if (choice.equals("3"))
                addRes();
            else if (choice.equals("4")) {
                presenter.print("Enter restaurant name");
                editResDetail(presenter.read());
            } else if (choice.equals("5")) {
                presenter.print("Enter customer phone no.");
                editCustomerDetail(presenter.read());
            } else if (choice.equals("6")) {
                presenter.print("Enter customer name");
                removeCustomer(presenter.read());
            } else
                presenter.print("invalid input");

        } while (!choice.equals("0"));
    }

    public void viewCustomerList(ArrayList<Customer> list) {
        for (Customer c : list)
            presenter.print(c);
    }

    public void viewResList(ArrayList<Resturant> list) {
        for (Resturant r : list)
            presenter.print(r.getName());
    }

    public void addRes() {
        presenter.print("Restaurant name");
        String name = presenter.read();

        presenter.print("Phone");
        String phone = presenter.read();

        presenter.print("Address");
        String address = presenter.read();

        double rating;
        while (true){
            try {
                presenter.print("Rating");
                rating = Double.valueOf(presenter.read());
            } catch (NumberFormatException e) {
                presenter.print("invalid input");
                continue;
            }
            break;
        }


        ArrayList<Dish> menu = new ArrayList<>();

        while (true) {
            Dish d = new Dish();

            presenter.print("Dish name");
            d.setName(presenter.read());

            presenter.print("Category (A Appetizer /M Main_Course /D Desert /B brevelge)");
            char c = presenter.read().toUpperCase().charAt(0);

            if (c == 'A') d.setCategory(Category.APPETIZER);
            if (c == 'M') d.setCategory(Category.MAIN_COURSE);
            if (c == 'D') d.setCategory(Category.DESSERT);
            if (c == 'B') d.setCategory(Category.DRINK);

            try {
                presenter.print("Price");
                d.setPrice(Double.valueOf(presenter.read()));
            } catch (NumberFormatException e) {
                presenter.print("invalid input");
                continue;
            }
            menu.add(d);

            presenter.print("Add another dish? (y/n)");
            if (presenter.read().equalsIgnoreCase("n"))
                break;
        }

        ResturantRepo.getResturantlist().add(new Resturant(name, phone, rating, address, menu));
    }

    public void editResDetail(String name) {
        Resturant resturant = ResturantRepo.getResturantlist().get(
                ResturantRepo.getResturantlist().indexOf(new Resturant(name)));

        String choice;

        do {
            presenter.print("\n--- Edit Restaurant ---\n" +
                    "1. Edit Info\n" +
                    "2. Add Dish\n " +
                    "3. Remove Dish\n " +
                    "4. Update Dish\n " +
                    "0. Back");

            choice = presenter.read();

            if (choice.equals("1")) {
                presenter.print("New name");
                resturant.setName(presenter.read());

                presenter.print("New address");
                resturant.setAddress(presenter.read());

                presenter.print("New phone");
                resturant.setPhone(presenter.read());

                while (true){
                    double rating;
                    try {
                        presenter.print("New rating");
                        rating = Double.valueOf(presenter.read());
                    } catch (NumberFormatException e) {
                        presenter.print("invalid input");
                        continue;
                    }
                    resturant.setRating(rating);
                    break;
                }

            }

            else if (choice.equals("2")) {
                Dish newdish = new Dish();

                presenter.print("Dish name");
                newdish.setName(presenter.read());

                presenter.print("Category (A Appetizer /M Main_Course /D Desert /B brevelge)");
                char c = presenter.read().toUpperCase().charAt(0);

                if (c == 'A') newdish.setCategory(Category.APPETIZER);
                if (c == 'M') newdish.setCategory(Category.MAIN_COURSE);
                if (c == 'D') newdish.setCategory(Category.DESSERT);
                if (c == 'B') newdish.setCategory(Category.DRINK);

                while (true){
                    double price;
                    try {
                        presenter.print("Price");
                        price = Double.valueOf(presenter.read());
                    } catch (NumberFormatException e) {
                        presenter.print("invalid input");
                        continue;
                    }
                    newdish.setPrice(price);
                    break;
                }

                resturant.addDish(newdish);
            }

            else if (choice.equals("3")) {
                presenter.print("Dish name");
                for (Dish dish : resturant.getMenu()) {
                    if (dish.getName().equals(presenter.read())) {
                        resturant.removeDish(dish);
                    }
                }
            }

            else if (choice.equals("4")) {
                presenter.print("Old dish name:");
                String oldName = presenter.read();

                Dish oldDish = resturant.getMenu().get(
                        resturant.getMenu().indexOf(new Dish(oldName)));

                presenter.print("old dish :" + oldDish);

                presenter.print("New dish name:");
                String newName = presenter.read();

                presenter.print("New description:");
                String newDesc = presenter.read();


                Category newCategory = Category.APPETIZER;
                presenter.print("Category (A Appetizer /M Main_Course /D Desert /B brevelge)");
                char c = presenter.read().toUpperCase().charAt(0);
                if (c == 'A') newCategory = Category.APPETIZER;
                if (c == 'M') newCategory = Category.MAIN_COURSE;
                if (c == 'D') newCategory = Category.DESSERT;
                if (c == 'B') newCategory = Category.DRINK;

                double price;
                while (true){

                    try {
                        presenter.print("Price");
                        price = Double.valueOf(presenter.read());
                    } catch (NumberFormatException e) {
                        presenter.print("invalid input");
                        continue;
                    }
                    break;
                }

                Dish newDish = new Dish(newName, newDesc, newCategory, price);

                resturant.updateDish(oldDish, newDish);
            }

            /*else {
                presenter.print("client name: " + CustomerRepo.getCustomerList().get(index).getName() +
                        "client email" + CustomerRepo.getCustomerList().get(index).getEmail() +
                        "client address" + CustomerRepo.getCustomerList().get(index).getAddress() +
                        "client number" + CustomerRepo.getCustomerList().get(index).getPhoneNo());
                presenter.print("Type the client's name");//Show data!!!!!!!!!!!!!

                String client_name = presenter.read();

                presenter.print("Type the client's email");
                String clients_email = presenter.read();

                presenter.print("Type the client's number");
                String clients_number = presenter.read();

                presenter.print("Type the client's address");
                String clients_address = presenter.read();

                CustomerRepo.getCustomerList().get(index).setName(client_name);

                CustomerRepo.getCustomerList().get(index).setEmail(clients_email);

                CustomerRepo.getCustomerList().get(index).setPhoneNo(clients_number);

            }
            while (choice != 0) ;*/
        }while (true);
    }

    public void editCustomerDetail(String phone) {
        Customer customer = CustomerRepo.getCustomerList().get(
                CustomerRepo.getCustomerList().indexOf()
        );

            presenter.print("Do you want to cancel order");
            String chois= presenter.read();
            if (chois == "cancle"){
                // here there is an error because the fn cancelOrder takes int (orderNumber you want to cancel) as parameter
                //CustomerRepo.getCustomerList().get(index).cancelOrder();
            }


        }
        presenter.print("New name");
        customer.setName(presenter.read());

        presenter.print("New email");
        customer.setEmail(presenter.read());

        presenter.print("New phone");
        customer.setPhoneNo(presenter.read());

        presenter.print("New address");
        customer.setAddress(presenter.read());
    }

    public void removeCustomer(String name) {
        Customer customer = new Customer(presenter);
        for (Customer customer1 : CustomerRepo.getCustomerList()){
            if (customer1.getName().equals(name)) {
                customer = customer1;
            }
        }

        if (!CustomerRepo.getCustomerList().remove(customer))
            throw new IllegalArgumentException("Customer not found");
    }
}
