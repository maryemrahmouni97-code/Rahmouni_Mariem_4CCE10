package tn.esprit.rahmouni_mariem_4cce10.service;

import tn.esprit.rahmouni_mariem_4cce10.domain.Reservation;

import java.util.List;

public interface IReservationServices {

    Reservation create(Reservation reservation);

    Reservation findbyId(long id);

    List<Reservation> findAll();

    void deleteById(long id);

    Reservation update(Reservation reservation);
}