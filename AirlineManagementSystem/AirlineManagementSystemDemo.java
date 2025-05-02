package AirlineManagementSystem;


import AirlineManagementSystem.Booking.Booking;
import AirlineManagementSystem.Payment.Payment;
import AirlineManagementSystem.Payment.PaymentProcessor;
import AirlineManagementSystem.Seat.Seat;
import AirlineManagementSystem.Seat.SeatType;
import AirlineManagementSystem.flight.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AirlineManagementSystemDemo {


  public static void main(String[] args) {
    run();
  }
  public static void run() {

    AirlineManagementSystem airlineManagementSystem = new AirlineManagementSystem();

    // create user1

    Passenger passenger = new Passenger("U001","John Doe","Johndoe@example.com","1234567890");

    // create flight
    LocalDateTime departureTime1 = LocalDateTime.now().plusDays(1);
    LocalDateTime arrivalTime1 = departureTime1.plusHours(2);

    Flight flight1 = new Flight("F001","New York","London",departureTime1,arrivalTime1);

    LocalDateTime departureTime2 = LocalDateTime.now().plusDays(3);
    LocalDateTime arrivalTime2 = departureTime1.plusHours(5);

    Flight flight2 = new Flight("F002","Paris","Tokyo",departureTime1,arrivalTime1);

    airlineManagementSystem.addFlight(flight1);
    airlineManagementSystem.addFlight(flight2);


    // create aircrafts

    AirCraft airCraft1 = new AirCraft("A001","Boeing 747",300);
    AirCraft airCraft2 = new AirCraft("A002","Airbus A380",500);

    // search flights

    List<Flight> searchResults = airlineManagementSystem.searchFlight("New York","London", LocalDate.now().plusDays(1));
    System.out.println("Search results:");
    for(Flight flight : searchResults){
      System.out.println("Flight: "+ flight.getFlightNumber() + " - "+ flight.getSource() + "to" + flight.getDestination());
    }

    Seat seat = new Seat("2SA", SeatType.ECONOMY);

    Payment payment = new Payment("UPI2345","UPI",100);

    PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();
    paymentProcessor.processPayment(payment);

    //BOOK A FLIGHT
    Booking booking = airlineManagementSystem.bookFlight(flight1,passenger,seat,100);
    if(booking != null){
      System.out.println("Booking successful. Booking ID: "+ booking.getBookingNumber());
    }else{
      System.out.println("Booking failed");
    }

    // cancel a booking
    airlineManagementSystem.cancelBooking(booking.getBookingNumber());
    System.out.println("Booking cancelled");

  }


}
