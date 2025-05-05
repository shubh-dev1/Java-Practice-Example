package CoffeeVendingMachine;



public class CoffeeVendingMachineDemo {
  public static void main(String[] args) {
    run();
  }
  public static  void run(){
    CoffeeVendingMachine coffeeVendingMachine = CoffeeVendingMachine.getInstance();

    coffeeVendingMachine.refillIngredients("Water",120);
    coffeeVendingMachine.refillIngredients("Milk",70);
    coffeeVendingMachine.refillIngredients("Coffee",150);

    // display coffee menu
    coffeeVendingMachine.displayMenu();
    coffeeVendingMachine.showIngredients();

    // simulate user requests
    CoffeeRecipe espresso = coffeeVendingMachine.selectRecipe("Espresso");
    coffeeVendingMachine.dispenseCoffee(espresso,new Payment(3.0));

    CoffeeRecipe cappcuccino = coffeeVendingMachine.selectRecipe("Cappuccino");
    coffeeVendingMachine.dispenseCoffee(cappcuccino,new Payment(3.5));

    CoffeeRecipe latte = coffeeVendingMachine.selectRecipe("Latte");
    coffeeVendingMachine.dispenseCoffee(latte,new Payment(4.0));

  }
}
