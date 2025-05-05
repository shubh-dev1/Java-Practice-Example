package CarRentalSystem.payment;

public class CreditCardPaymentProcessor implements PaymentProcessor{
  @Override
  public boolean processPayment(double amount) {
    //process credit card payment
    return true;
  }
}
