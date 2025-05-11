package vendingmachine;



public class DispenseState implements VendingMachineState{

  private final VendingMachine vendingMachine;

  public DispenseState(VendingMachine vendingMachine){
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void selectProduct(Product product) {
    System.out.println("Product is already selected. Please collect the dispensed products");
  }

  @Override
  public void insertCoin(Coin coin) {
    System.out.println("Payment already made. Please collect the dispense product.");
  }

  @Override
  public void insertNote(Note note) {
    System.out.println("Payment already made. Please collect the dispense product");
  }

  @Override
  public void dispenseProduct() {
   Product product = vendingMachine.getSelectedProduct();
   vendingMachine.getInventory().updateQuantity(product,vendingMachine.getInventory().getQuantity(product)-1);
    System.out.println("Product dispensed: "+ product.getName());
    vendingMachine.setState(vendingMachine.getReturnChangeState()); // return the state to Return change state
  }

  @Override
  public void returnChange() {
    System.out.println("Please collect the dispensed product first");
  }
}
