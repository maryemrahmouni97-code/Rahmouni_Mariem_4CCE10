package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rahmouni_mariem_4cce10.Repositry.IVehiculeRepository;
import tn.esprit.rahmouni_mariem_4cce10.domain.Vehicule;
import tn.esprit.rahmouni_mariem_4cce10.service.IVehiculeServices;

import java.util.List;
@RequiredArgsConstructor
@Service
public class VehiculeServiceImpls implements IVehiculeServices {

    private IVehiculeRepository vehiculeRepository;


    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule findbyId(long id) {
        return vehiculeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vehicule not found"));
    }

    @Override
    public List<Vehicule> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(long id) {
        vehiculeRepository.deleteById(id);

    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }
}
