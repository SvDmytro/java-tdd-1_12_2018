package pl.stacjait.reservation.services;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceTest {

    @Mock
    ReservationService reservationService;

    RestaurantService restaurantService; // = new RestaurantService(reservationService);

    @Before
    public void setupTest() {
        MockitoAnnotations.initMocks(this);
        restaurantService = new RestaurantService(reservationService);
    }

    @Test
    public void freeTableTest() {
        when(reservationService.getNumberOfAvailableTables()).thenReturn(10);
//    when(reservationService.releaseTable()).thenThrow(new RuntimeException())
//    doThrow(new RuntimeException()).when()

        // tutaj aktor powie pod spodem to czego go nauczyliśmy:
        int freeTables = restaurantService.freeTable();
        Assert.assertEquals(freeTables, 10);
    }
}