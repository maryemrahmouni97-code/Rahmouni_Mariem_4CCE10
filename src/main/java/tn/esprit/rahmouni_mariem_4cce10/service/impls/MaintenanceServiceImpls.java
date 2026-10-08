package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.rahmouni_mariem_4cce10.domain.Maintenance;
import tn.esprit.rahmouni_mariem_4cce10.repository.IMaintenanceRepository;
import tn.esprit.rahmouni_mariem_4cce10.service.IMaintenanceServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MaintenanceServiceImpls implements IMaintenanceServices {

    private final IMaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance findbyId(long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance not found"));
    }

    @Override
    public List<Maintenance> findAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }
}