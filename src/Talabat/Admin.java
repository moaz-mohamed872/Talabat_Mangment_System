package Talabat;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {


    public void viewCustomerList(ArrayList<Customer> Cusomerlist){
        for (Customer c:Cusomerlist){
            System.out.println(c);
        }
    };

    public void  viewResList(ArrayList<Resturant> resturantlist){
        for (Resturant r:resturantlist){
            System.out.println(r);
        }
    };

    public void addRes(){
        /*
        - name : String
        - phone : String
        - Rating : double
        - address : String
        - menu : Dish[]
         */
        System.out.println("Enter resturante name");
        Scanner input1=new Scanner(System.in);
        String name=input1.nextLine();

        System.out.println("Enter resturante phone");
        String phone=input1.nextLine();

        System.out.println("Enter resturante address");
        String address=input1.nextLine();

        System.out.println("Enter resturante rate");
        double rate=input1.nextDouble();


        ArrayList<Dish> menu=new ArrayList<>();

        while (true){

            System.out.println("Enter dish name");
            String dish=input1.next();

            System.out.println("Enter dish category" +
                    "Enter A for Apetaizer" +
                    "Enter M for maincourse" +
                    "Enter D for desert" +
                    "Enter B for Beverages ");
            String category=input1.next().toLowerCase();

            if (category=="A"){

            }

        }



        resturantlist.get(index).setname(name);

        resturantlist.get(index).setemail(phone);

        resturantlist.get(index).setphone(phone);

        resturantlist.get(index).setaddress(address);

        resturantlist.get(index).setaddrate(rate);

    };/********** menu **********/

    public void editResDetail(String Resturantname){
       /* int  index=0;
        for (int i=0;i<resturantlist.size;i++){
            if(resturantlist.get(i).name.equals(Resturantname)){
                index=i;
            }
            else {
                index=-1;
            }
        }//index of*/

        // int index =indexof()



        if(index!=1){
            System.out.println("Do you want to remove the resturant account");
            Scanner choise=new Scanner(System.in);
            char c=choise.next().toLowerCase().charAt(0);
            if (c=='y'){
                resturantlist.remove(index);
            }
            else {
                System.out.println("Type the resturant's name");//Show data!!!!!!!!!!!!!
                Scanner input2=new Scanner(System.in);
                String resturants_name =input2.nextLine();


                System.out.println("Type the resturant's phone");
                String resturants_phone =input2.nextLine();

                System.out.println("Type the resturant's address");
                String resturants_address =input2.nextLine();


                System.out.println("Type the resturant's rate");
                String resturants_rate =input2.nextLine();

                resturantlist.get(index).setname(resturants_name);

                resturantlist.get(index).setphone(resturants_phone);

                resturantlist.get(index).setaddress(resturants_address);

                resturantlist.get(index).setaddrate(resturants_rate);


                /*menu!!!!*/

            }



        }
        else {
            System.out.println("This resturante does not exist");
        }

    };//menu **********/

    public void editCustomerDetail(String name){

        int index=0;
        for (int i=0;i<Customrlist.size;i++){
            if (Customrlist.get(i).name.equals(name)){
                index=i;
                break;
            }
            else{
                index=-1;
            }
        }//index of
        if(index!=-1){
            System.out.println("Do you want to remove the client account");
            Scanner choise=new Scanner(System.in);
            char c=choise.next().toLowerCase().charAt(0);
            if (c=='y'){
                Customrlist.remove(index);
            }
            else {
                System.out.println("Type the client's name");//Show data!!!!!!!!!!!!!
                Scanner input2=new Scanner(System.in);
                String client_name =input2.nextLine();

                System.out.println("Type the client's email");
                String clients_email =input2.nextLine();

                System.out.println("Type the client's phone");
                String clients_phone =input2.nextLine();

                System.out.println("Type the client's address");
                String clients_address =input2.nextLine();

                Customrlist.get(index).setname(client_name);

                Customrlist.get(index).setemail(clients_email);

                Customrlist.get(index).setphone(clients_phone);

                Customrlist.get(index).setaddress(clients_address);


                //Do you want to cancl order
            }



        }
        else{
            System.out.println("This customer does not exist");
        }


    };


    public void removeCustomer (String name){
        int index=0;
        for (int i=0;i<Customrlist.size;i++){
            if (Customrlist.get(i).name.equals(name)){
                index=i;
                break;
            }
            else{
                index=-1;
            }
        }//index of
        if(index!=-1) {
            Customrlist.removes(index);
        }
        else{
            System.out.println("This customer does not exist");
        }
    };


}
