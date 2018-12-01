package pl.stacjait.reservation.services;

public class ReservationServiceImpl implements ReservationService {

  int availableTables;

  @Override
  public int getNumberOfAvailableTables() {
    return this.availableTables;
  }

  @Override
  public int releaseTable() {
    return this.availableTables + 1;
  }

}
