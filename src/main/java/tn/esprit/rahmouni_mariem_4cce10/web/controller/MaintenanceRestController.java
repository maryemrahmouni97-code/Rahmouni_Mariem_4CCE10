
package tn.esprit.rahmouni_mariem_4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rahmouni_mariem_4cce10.domain.Maintenance;
import tn.esprit.rahmouni_mariem_4cce10.service.impls.MaintenanceServiceImpls;

import java.util.List;

@RequestMapping("maintenances")
@RestController
@RequiredArgsConstructor
public class MaintenanceRestController {

    private final MaintenanceServiceImpls maintenanceServices;

    @PostMapping
    public Maintenance add(@RequestBody Maintenance maintenance) {
        return maintenanceServices.create(maintenance);
    }

    @GetMapping("{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return maintenanceServices.findbyId(id);
    }

    @GetMapping
    public List<Maintenance> getMaintenances() {
        return maintenanceServices.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        maintenanceServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public Maintenance update(
            @PathVariable Long id,
            @RequestBody Maintenance maintenance) {

        maintenance.setIdMaintenance(id);
        return maintenanceServices.update(maintenance);
    }
}
