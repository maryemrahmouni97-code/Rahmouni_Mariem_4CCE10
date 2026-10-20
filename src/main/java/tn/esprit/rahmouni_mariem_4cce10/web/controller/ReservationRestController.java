
package tn.esprit.rahmouni_mariem_4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rahmouni_mariem_4cce10.domain.Reservation;
import tn.esprit.rahmouni_mariem_4cce10.service.impls.ReservationServiceImpls;

import java.util.List;

@RequestMapping("reservations")
@RestController
@RequiredArgsConstructor
public class ReservationRestController {

    private final ReservationServiceImpls reservationServices;

    @PostMapping
    public Reservation add(@RequestBody Reservation reservation) {
        return reservationServices.create(reservation);
    }

    @GetMapping("{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationServices.findbyId(id);
    }

    @GetMapping
    public List<Reservation> getReservations() {
        return reservationServices.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        reservationServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public Reservation update(
            @PathVariable Long id,
            @RequestBody Reservation reservation) {

        reservation.setIdReservation(id);
        return reservationServices.update(reservation);
    }
}
