package CoffeeVendingMachine;

public class PaymentProcessor {
  public double process(double price,double paid){
    System.out.println("Processing payment.......");
    return paid-price;
  }
}
