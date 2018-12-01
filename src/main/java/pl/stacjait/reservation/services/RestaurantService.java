package pl.stacjait.reservation.services;

public class RestaurantService {

    private ReservationService reservationService;

    public RestaurantService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Metoda zwalnia table a następnia zwraca ile aktualnie jest wolnych stolików.
     * @return
     */
    public int freeTable() {
        reservationService.releaseTable();
        // tutaj jakaś bogata logika biznesowa i wywołania wielu serwisów...
        // ale reservationService nam przeszkadza więc jego mockujemy.
        return reservationService.getNumberOfAvailableTables();
    }


}
