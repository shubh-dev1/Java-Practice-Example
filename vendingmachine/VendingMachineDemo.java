package vendingmachine;

public class VendingMachineDemo {
  public static void main(String[] args) {
    run();
  }
  public static void run(){

    VendingMachine vendingMachine = VendingMachine.getInstance();

    // Add products to the inventory

    Product coke = vendingMachine.addProduct("Coke",1.5,3);
    Product pepsi = vendingMachine.addProduct("Pepsi",1.5,2);
    Product water = vendingMachine.addProduct("Water",1.0,5);

    // select a product

    vendingMachine.selectProduct(coke);

    // Insert coins
    vendingMachine.insertCoin(Coin.QUARTER);
    vendingMachine.insertCoin(Coin.QUARTER);
    vendingMachine.insertCoin(Coin.QUARTER);
    vendingMachine.insertCoin(Coin.QUARTER);

    // Insert a note
    vendingMachine.insertNote(Note.FIVE);

    // dispense the product
    vendingMachine.dispenseProduct();

    // return change
    vendingMachine.returnChange();

    // select another product

    vendingMachine.selectProduct(pepsi);

    //insert insufficient payment
    vendingMachine.insertCoin(Coin.QUARTER);

    // try to dispense the product
    vendingMachine.dispenseProduct();

    // add more coins
    vendingMachine.insertCoin(Coin.QUARTER);
    vendingMachine.insertCoin(Coin.QUARTER);
    vendingMachine.insertCoin(Coin.QUARTER);
    vendingMachine.insertCoin(Coin.QUARTER);

    // dispense the product
    vendingMachine.dispenseProduct();

    // return change
    vendingMachine.returnChange();
  }
}
