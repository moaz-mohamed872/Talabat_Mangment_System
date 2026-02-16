package Talabat;

import java.util.ArrayList;

public class ResturantRepo {

    private static ArrayList<Resturant> resturantlist = new ArrayList<Resturant>();

    public static ArrayList<Resturant> getResturantlist() {
        return resturantlist;
    }

    public static void addResturant(Resturant resturant) {
        resturantlist.add(resturant);
    }

    public static void editResturant(Resturant oldresturant, Resturant newresturant) {
        resturantlist.remove(oldresturant);
        resturantlist.add(newresturant);
    }

    public static void deleteResturant(Resturant cresturant) {
        resturantlist.remove(cresturant);
    }

    public static void dummyData(){
        ArrayList<Dish> menu1 = new ArrayList<>();
        menu1.add(new Dish("Burger", "Beef burger", Category.MAIN_COURSE, 8.5));
        menu1.add(new Dish("Fries", "Crispy fries", Category.APPETIZER, 3.0));

        ArrayList<Dish> menu2 = new ArrayList<>();
        menu2.add(new Dish("Pizza", "Cheese pizza", Category.MAIN_COURSE, 10.0));
        menu2.add(new Dish("Cola", "Soft drink", Category.DRINK, 2.5));

        ArrayList<Dish> menu3 = new ArrayList<>();
        menu3.add(new Dish("Pasta", "White sauce pasta", Category.MAIN_COURSE, 9.0));

        ArrayList<Dish> menu4 = new ArrayList<>();
        menu4.add(new Dish("Shawarma", "Chicken shawarma", Category.MAIN_COURSE, 7.5));

        ArrayList<Dish> menu5 = new ArrayList<>();
        menu5.add(new Dish("Steak", "Grilled steak", Category.MAIN_COURSE, 15.0));

        ArrayList<Dish> menu6 = new ArrayList<>();
        menu6.add(new Dish("Ice Cream", "Vanilla ice cream", Category.DESSERT, 4.0));

        resturantlist.add(new Resturant("Food Hub", "0100000001", 4.5, "Nasr City", menu1));
        resturantlist.add(new Resturant("Pizza Town", "0100000002", 4.2, "Heliopolis", menu2));
        resturantlist.add(new Resturant("Italiano", "0100000003", 4.0, "Maadi", menu3));
        resturantlist.add(new Resturant("Shawarma King", "0100000004", 4.3, "Zamalek", menu4));
        resturantlist.add(new Resturant("Steak House", "0100000005", 4.7, "New Cairo", menu5));
        resturantlist.add(new Resturant("Sweet Spot", "0100000006", 4.1, "Dokki", menu6));

    }
}
