package pl.stacjait.reservation.services;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ReservationServiceTest {

  private ReservationService reservationService;

  private int tableCount;

  @Before
  public void setUp() {
    reservationService = new ReservationServiceImpl();
    tableCount = 0;
  }

  @Test
  public void shouldReturnNoAvailableTables() {
    int result = reservationService.getNumberOfAvailableTables();
    assertThat(result).isEqualTo(tableCount);
  }

  @Test
  public void shouldReleaseTable() {
    int initialAmount = reservationService.getNumberOfAvailableTables();
    reservationService.releaseTable();
    int countAfterRelease = reservationService.getNumberOfAvailableTables();

    assertThat(countAfterRelease).isEqualTo(initialAmount + 1);
  }
}
