package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.rahmouni_mariem_4cce10.domain.Employe;
import tn.esprit.rahmouni_mariem_4cce10.repository.IEmployeRepository;
import tn.esprit.rahmouni_mariem_4cce10.service.IEmployeServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeServiceImpls implements IEmployeServices {

    private final IEmployeRepository employeRepository;

    @Override
    public Employe create(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe findbyId(long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employe not found"));
    }

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe update(Employe employe) {
        return employeRepository.save(employe);
    }
}