package CarRentalSystem.payment;

public class PayPalPaymentProcessor implements PaymentProcessor{


  @Override
  public boolean processPayment(double amount) {
    // process pay pal payment
    return true;
  }
}
