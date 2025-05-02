package AirlineManagementSystem;

import AirlineManagementSystem.Booking.Booking;
import AirlineManagementSystem.Booking.BookingManager;
import AirlineManagementSystem.Payment.Payment;
import AirlineManagementSystem.Payment.PaymentProcessor;
import AirlineManagementSystem.Seat.Seat;
import AirlineManagementSystem.flight.Flight;
import AirlineManagementSystem.flight.FlightSearch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AirlineManagementSystem {

  private final List<Flight> flights;
  private final List<AirCraft> airCrafts;
  private final FlightSearch flightSearch;
  private final BookingManager bookingManager;
  private final PaymentProcessor paymentProcessor;

  public AirlineManagementSystem() {
    this.flights = new ArrayList<>();
    this.airCrafts = new ArrayList<>();
    this.flightSearch = new FlightSearch(flights);
    this.bookingManager = BookingManager.getInstance();
    this.paymentProcessor = PaymentProcessor.getInstance();
  }

  public void addFlight(Flight flight){
    flights.add(flight);
  }
  public void addAircraft(AirCraft airCraft){
    airCrafts.add(airCraft);
  }

  public List<Flight> searchFlight(String source, String destination, LocalDate date){
    return flightSearch.searchFlights(source,destination,date);
  }

  public Booking bookFlight(Flight flight, Passenger passenger, Seat seat, double price){
    return bookingManager.createBooking(flight,passenger,seat,price);
  }

  public void cancelBooking(String bookingNumber){
    bookingManager.cancelBooking(bookingNumber);
  }

  public void processPayment(Payment payment){
    payment.processPayment();
  }
}
