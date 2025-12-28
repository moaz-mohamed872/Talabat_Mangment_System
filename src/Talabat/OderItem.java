package Talabat;

public class OderItem {

    private int quantity;
    private double TotalPrice;

    private Dish orderedDish;


    public OderItem(int quantity, Dish orderedDish) {
        this.quantity = quantity;
        this.orderedDish = orderedDish;
    }
    public OderItem(){
        this(0, null);
    }

    public OderItem(OderItem otherOrderItem) {
//            this(otherOrderItem.quantity, new Dish(otherOrderItem.getOrderedDish())));

    }

    private void calculateTotalPrice() {
//      this.TotalPrice = quantity * orderedDish.getPrice();
    }

    public void setOrderedDish(Dish orderedDish) {
        if (orderedDish == null)
            throw new IllegalArgumentException("Dish can't be null");

        this.orderedDish = orderedDish;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice()  { return TotalPrice; }

    public Dish getOrderedDish() { return orderedDish; }

    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return //orderedDish.getName() +
                "\t"  + getQuantity()
                + "\t" + getTotalPrice();
    }
}


