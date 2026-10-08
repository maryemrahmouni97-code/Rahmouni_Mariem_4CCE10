package tn.esprit.rahmouni_mariem_4cce10.service;
import tn.esprit.rahmouni_mariem_4cce10.domain.Vehicule;

import java.util.List;
public interface IVehiculeServices {
    Vehicule create(Vehicule vehicule);
    Vehicule findbyId(long id);
    List<Vehicule> findAll();
    void deleteById(long id);
    Vehicule update(Vehicule vehicule);
}
