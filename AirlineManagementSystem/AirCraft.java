package AirlineManagementSystem;

public class AirCraft {

  private final String tailNumber;
  private final String model;
  private final int totalSeats;

  public AirCraft(String tailNumber, String model, int totalSeats) {
    this.tailNumber = tailNumber;
    this.model = model;
    this.totalSeats = totalSeats;
  }
}
