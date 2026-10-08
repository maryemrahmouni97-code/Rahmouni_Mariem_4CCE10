package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.rahmouni_mariem_4cce10.domain.Paiement;
import tn.esprit.rahmouni_mariem_4cce10.repository.IPaiementRepository;
import tn.esprit.rahmouni_mariem_4cce10.service.IPaiementServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaiementServiceImpls implements IPaiementServices {

    private final IPaiementRepository paiementRepository;

    @Override
    public Paiement create(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement findbyId(long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement not found"));
    }

    @Override
    public List<Paiement> findAll() {
        return paiementRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        paiementRepository.deleteById(id);
    }

    @Override
    public Paiement update(Paiement paiement) {
        return paiementRepository.save(paiement);
    }
}