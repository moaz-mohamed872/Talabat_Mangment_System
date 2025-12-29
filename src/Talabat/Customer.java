package Talabat;
import java.util.ArrayList;

import static java.lang.Character.toLowerCase;

public class Customer extends User {
    ConsolePresenter presenter;

    // the Constructors we have
    public Customer(){
        this.name = "User10022585110005";
        this.email="User1002258@gmail.com";
        this.address="Egypt Cairo ElMaadi ElSaada st";
        this.number = "01101010449";

    }

    public Customer(String name, String email, String number, String address) {
        setName(name);
        setEmail(email);
        setNumber(number);
        setAddress(address);
    }

    public Customer(Customer c1) {
        setName(c1.name);
        setEmail(c1.email);
        setNumber(c1.number);
        setAddress(c1.address);
        this.orders=c1.orders;

    }

    // the fields of the Class
    private String name;
    private String email;
    private String number;
    private String address;
    private ArrayList<Order> orders = new ArrayList<>();


    // the Methods of the Class

    // the following 8 Methods are the setters and the getters for the fields
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

// From here the Methods that do actions For the Customers
    /*  the showResLis() Method it takes the customer choice for the Restaurant and returns
        that Restaurant to work on it on the next processes
     */

     private Resturant showResLis() {
         Resturant restaurantPicked; //this var will have the Restaurant that the Customer Choose

         //this restaurantLimit it has the total number we have of Restaurant as String to use in a condition
         String restaurantLimit = Integer.toString(ResturantRepo.getResturantlist().size());
         //show all Restaurants for the Customer
         presenter.print("Restaurants");
         for(int i=0;i<ResturantRepo.getResturantlist().size();i++){
             presenter.print('\t'+ i+1+": "+ResturantRepo.getResturantlist().get(i).getName());
         }
         presenter.print("Choose the number of the Restaurant you want (enter X to cancle) : ");
         //this loop to validate the Choice of the Customer of the Restaurants
         while(true) {
             String choice = presenter.read();
             if (choice.toLowerCase().charAt(0) == 'x') {
                 return null;
             }
             // this condition check if the Entered String is Number because if it was a String fn valueOf wiil Throw Exception
             else if ((choice.charAt(0)>'0'&&choice.charAt(restaurantLimit.length()) <= restaurantLimit.charAt(restaurantLimit.length()) )&&(Integer.valueOf(choice)>0 &&Integer.valueOf(choice)<= ResturantRepo.getResturantlist().size())){
                  restaurantPicked =ResturantRepo.getResturantlist().get(Integer.valueOf(choice));
                 break;
             }
             else {
                 presenter.print("Invalid Choice plz Enter a valid Choice");
                 continue;
             }
         }
        placeOrder(restaurantPicked);

        return restaurantPicked;
     }

    /*
     the placeOrder() Method it takes the Restaurant that returned by the showResLis() and then
     takes the order from the customer and returned it for the next processes
    */
     private Order placeOrder(Resturant res )  {
        Order ord = new Order(); //this will have the orer of the customer will order

         //this dishLimit it has the total number we have of Dishes as String to use in a condition
        String dishLimit = Integer.toString(res.getMenu().size());
         char answer; //this var for if the customer want to add another dish

         // this arraylist to add init the orderitem for customer and to make the order arraylist of menu have it
         ArrayList<OderItem> ordItem = new ArrayList<>();

         OderItem orderCustomerPicked = new OderItem();
            ord.setResturant(res);

            presenter.print("Menu"+"\n\t");
            presenter.print(res.showMenu());
        while(true){
            presenter.print("Enter Dish no. (enter X to cancle) : ");
            String dishChoice = presenter.read();// this var is the customer when he chooses number dish he want in menu

            if(dishChoice.toLowerCase().charAt(0) == 'x'){
                return null;
            }
            // this condition check if the Entered String is Number because if it was a String fn valueOf wiil Throw Exception
           else if((dishChoice.charAt(0)>'0'&&dishChoice.charAt(dishLimit.length()) <= dishLimit.charAt(dishLimit.length()) )
                    &&Integer.valueOf(dishChoice) > 0 && Integer.valueOf(dishChoice) <= res.getMenu().size()){

                orderCustomerPicked.setOrderedDish(res.getMenu().get(Integer.valueOf(dishChoice)-1));
            }
           else {
               presenter.print("Invalid Choice plz Enter a valid Choice");
               continue;
            }

            presenter.print("Enter the amount: ");
            int amountOfDish =Integer.valueOf(presenter.read());//this var for the customer enter how many dish he wants

            //this while loop for thr validation of the amount of the dishes
            while(true) {
                if (amountOfDish>0) {
                    orderCustomerPicked.setQuantity(amountOfDish);
                    break;

                }
                else{
                    presenter.print("Plz Enter a Valid Amount");
                }

            }
            ordItem.add(orderCustomerPicked);
            presenter.print("Do you want another Dish ? (Y/N)");
            answer = presenter.read().charAt(0);

                if(toLowerCase(answer) == 'n') {
                    ord.setMenu(ordItem);
                    //here remeber that you will the constructur all the data you want
                    ord = new Order(presenter);
                    break;
                }
               else if (!(toLowerCase(answer) == 'y')) {
                    presenter.print("Invalid Choice plz enter the valid choice");
                    continue;
                }

        }
        this.orders.add(ord);
        ord.showOrder();
        return ord;
     }

    /*
    the newOrder() Method it show the whole process when the customer choose new order from the Restaurants
    available and the menu of the Restaurant that he chose
    */
     public void newOrder(){
        while(true) {
            if (this.showResLis() == null) {
                return;
            }
        }

     }

     public void cancelOrder(int orderNumber){

         for(int i=0;i<this.orders.size();i++){
             presenter.print((this.orders.get(i).getNumber()));
             presenter.print(this.orders.get(i).getResturant().getName());
             presenter.print("---------------------- \t ----------------------------");
         }
        for(int i=0 ;i<this.orders.size();i++){
           if(this.orders.get(i).getNumber()==orderNumber)
            {
            this.orders.remove(i);

            }
        }
     }

     public void trackOrder(){
        Integer orderPicked;
         for(int i=0;i<this.orders.size();i++){
             presenter.print((this.orders.get(i).getNumber()));
             presenter.print(this.orders.get(i).getResturant().getName());
             presenter.print("---------------------- \t ----------------------------");
         }
         presenter.print("Enter the number of the Order you want to track");

         //this loop to see if the number he enterd for the orderNumber valid or not found
         while(true) {
             orderPicked = Integer.valueOf(presenter.read());
             boolean found =false;
             for (int i = 0; i < this.orders.size(); i++) {

                 if (this.orders.get(i).getNumber() == orderPicked) {
                     this.orders.get(i).showOrder();
                     found = true;
                 }

             }
             if(found)
                 break;
             else {
                 presenter.print("Plz Enter a Valid Order Number");
             }
         }

     }

}
