package ATMDesign;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class ATM {

  private final BankingService bankingService;
  private final CashDispenser cashDispenser;
  private static final AtomicLong transactionCounter = new AtomicLong(0);

  public ATM(BankingService bankingService, CashDispenser cashDispenser) {
    this.bankingService = bankingService;
    this.cashDispenser = cashDispenser;
  }

  public void authenticateUser(Card card){
    // Authenticate user using card and pin
  }

  public double checkBalance(String accountNumber){
    Account account = bankingService.getAccount(accountNumber);
    return account.getBalance();
  }

  public void withdrawCash(String accountNumber,double amount){
    Account account = bankingService.getAccount(accountNumber);
    // check if the sufficient balance is available
    if(account != null && account.getBalance() < amount){
      System.out.println("Error: Insufficient balance.");
      return;
    }
    Transaction transaction = new WithdrawalTransaction(generateTransactionId(),account,amount);
    bankingService.processTransaction(transaction);
    cashDispenser.dispenseCash((int)amount);
  }

  public void depositCash(String accountNumber,double amount){
    Account account = bankingService.getAccount(accountNumber);
    Transaction transaction = new DepositTransaction(generateTransactionId(),account,amount);
    bankingService.processTransaction(transaction);
  }

  public  String generateTransactionId(){
    long transactionNumber = transactionCounter.incrementAndGet();
    String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    return "TXN" + timeStamp + String.format("%010d",transactionNumber);
  }
}
