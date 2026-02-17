package Talabat;

public class Main {
    public static void main(String[] args) {
        ConsolePresenter presenter = new ConsolePresenter();
        SystemActions.setPresenter(presenter);

        User currUser = new Customer(presenter);
        while(currUser != null) {
            currUser = SystemActions.startSystem();
            SystemActions.showMainOptions(currUser);
        }
    }
}