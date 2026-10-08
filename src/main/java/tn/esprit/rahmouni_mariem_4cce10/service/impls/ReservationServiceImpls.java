package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.rahmouni_mariem_4cce10.domain.Reservation;
import tn.esprit.rahmouni_mariem_4cce10.repository.IReservationRepository;
import tn.esprit.rahmouni_mariem_4cce10.service.IReservationServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpls implements IReservationServices {

    private final IReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation findbyId(long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}