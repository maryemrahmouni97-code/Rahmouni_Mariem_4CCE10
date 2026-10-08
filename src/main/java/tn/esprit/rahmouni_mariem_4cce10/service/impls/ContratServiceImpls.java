package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.rahmouni_mariem_4cce10.domain.Contrat;
import tn.esprit.rahmouni_mariem_4cce10.repository.IContratRepository;
import tn.esprit.rahmouni_mariem_4cce10.service.IContratServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContratServiceImpls implements IContratServices {

    private final IContratRepository contratRepository;

    @Override
    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat findbyId(long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrat not found"));
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat update(Contrat contrat) {
        return contratRepository.save(contrat);
    }
}