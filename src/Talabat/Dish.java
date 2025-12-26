package Talabat;

public class Dish {
    private String name;
    private String discription;
    private String category;
    private double price;
    private int timesOrdered = 0 ;
    private boolean visable = false ;

    public Dish(){

    }

    public Dish(String name, String discription, String category, double price) {
        this.name = name;
        this.discription = discription;
        this.category = category;
        this.price = price;
    }

    public Dish(Dish dish){
        this.name = dish.name;
        this.discription = dish.discription;
        this.category = dish.category;
        this.price = dish.price;
        this.timesOrdered = dish.timesOrdered;
        this.visable = dish.visable;
    }
}
