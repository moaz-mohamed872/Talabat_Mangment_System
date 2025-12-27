package Talabat;

import static Talabat.Category.APPETIZER;

public class Dish {
    private String name;
    private String discription;
    private Category category;
    private double price;
    private int timesOrdered = 0 ;
    private boolean visable = false ;

    public Dish(){
    this.name = "";
    this.discription = "";
    this.category =APPETIZER;
        this.price = 0;
    }

    public Dish(String name, String discription, Category category, double price) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTimesOrdered() {
        return timesOrdered;
    }

    public void setTimesOrdered(int timesOrdered) {
        this.timesOrdered = timesOrdered;
    }

    public boolean isVisable() {
        return visable;
    }

    public void setVisable(boolean visable) {
        this.visable = visable;
    }
}
