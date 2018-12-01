package pl.stacjait.reservation.services;

public class RestaurantService {

  private ReservationService reservationService;

  public RestaurantService(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  public void freeTable() {
    reservationService.releaseTable();
  }

  public int getNumberOfTables() {
    return reservationService.getNumberOfAvailableTables();
  }

}
