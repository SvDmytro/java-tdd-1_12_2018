package pl.stacjait.reservation.services;

public class ReservationServiceImpl implements ReservationService {

  int availableTables = 0;

  @Override
  public int getNumberOfAvailableTables() {
    return this.availableTables;
  }

  @Override
  public void releaseTable() {
    this.availableTables++;
  }

}
