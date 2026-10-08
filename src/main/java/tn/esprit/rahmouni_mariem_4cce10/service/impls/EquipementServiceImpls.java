package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.rahmouni_mariem_4cce10.domain.Equipement;
import tn.esprit.rahmouni_mariem_4cce10.repository.IEquipementRepository;
import tn.esprit.rahmouni_mariem_4cce10.service.IEquipementServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EquipementServiceImpls implements IEquipementServices {

    private final IEquipementRepository equipementRepository;

    @Override
    public Equipement create(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement findbyId(long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipement not found"));
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public Equipement update(Equipement equipement) {
        return equipementRepository.save(equipement);
    }
}