package pl.stacjait.reservation;

public interface ReservationService {

  int getNumberOfAvailableTables();

  int releaseTable();
}
