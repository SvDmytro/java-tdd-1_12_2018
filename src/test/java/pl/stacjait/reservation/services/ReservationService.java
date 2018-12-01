package pl.stacjait.reservation.services;

public interface ReservationService {

  int getNumberOfAvailableTables();

  int releaseTable();
}
