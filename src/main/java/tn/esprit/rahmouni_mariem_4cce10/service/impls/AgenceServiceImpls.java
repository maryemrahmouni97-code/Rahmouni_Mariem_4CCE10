package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.rahmouni_mariem_4cce10.domain.Agence;
import tn.esprit.rahmouni_mariem_4cce10.repository.IAgenceRepository;
import tn.esprit.rahmouni_mariem_4cce10.service.IAgenceServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AgenceServiceImpls implements IAgenceServices {

    private final IAgenceRepository agenceRepository;

    @Override
    public Agence create(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence findbyId(long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence not found"));
    }

    @Override
    public List<Agence> findAll() {
        return agenceRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public Agence update(Agence agence) {
        return agenceRepository.save(agence);
    }
}