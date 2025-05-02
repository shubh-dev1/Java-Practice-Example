package AirlineManagementSystem.flight;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {
  private final List<Flight> Flights;

  public FlightSearch(List<Flight> Flights){
    this.Flights = Flights;
  }

  public List<Flight> searchFlights(String source, String destination, LocalDate date){
    return Flights.stream()
      .filter(Flight -> Flight.getSource().equalsIgnoreCase(source)
       && Flight.getDestination().equalsIgnoreCase(destination)
      && Flight.getDepartureTime().toLocalDate().equals(date))
      .collect(Collectors.toList());
  }
}
