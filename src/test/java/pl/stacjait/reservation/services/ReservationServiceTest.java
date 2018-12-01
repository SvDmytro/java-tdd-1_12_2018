package pl.stacjait.reservation.services;

import org.junit.Before;
import org.junit.Test;
import pl.stacjait.reservation.ReservationService;
import pl.stacjait.reservation.ReservationServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ReservationServiceTest {

  private ReservationService reservationService;

  @Before
  public void setUp() {
    reservationService = new ReservationServiceImpl();
  }

  @Test
  public void shouldReturnNoAvailableTables() {
    int result = reservationService.getNumberOfAvailableTables();
    assertThat(result).isEqualTo(0);
  }

  @Test
  public void shouldReleaseTable() {
    int initialAmount = reservationService.getNumberOfAvailableTables();
    int finalAmount = reservationService.releaseTable();

    assertThat(finalAmount).isEqualTo(initialAmount + 1);
  }



}
