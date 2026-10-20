package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import tn.esprit.rahmouni_mariem_4cce10.domain.Contrat;
import tn.esprit.rahmouni_mariem_4cce10.exception.ResourceNotFoundException;
import tn.esprit.rahmouni_mariem_4cce10.repository.IContratRepository;
import tn.esprit.rahmouni_mariem_4cce10.service.IContratServices;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpls implements IContratServices {

    private final IContratRepository contratRepository;

    @Override
    public Contrat create(Contrat contrat) {

        if (contrat.getIdContrat() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau contrat ne doit pas avoir d'identifiant"
            );
        }

        return contratRepository.save(contrat);
    }

    @Override
    public Contrat findbyId(long id) {

        return contratRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Contrat", id)
                );
    }

    @Override
    public List<Contrat> findAll() {
        return contratRepository.findAll();
    }

    @Override
    public void deleteById(long id) {

        if (!contratRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contrat", id);
        }

        contratRepository.deleteById(id);
    }

    @Override
    public Contrat update(Contrat contrat) {

        Contrat existant = findbyId(contrat.getIdContrat());

        existant.setDateSignature(contrat.getDateSignature());
        existant.setMontantTotal(contrat.getMontantTotal());
        existant.setValide(contrat.isValide());

        return contratRepository.save(existant);
    }
}