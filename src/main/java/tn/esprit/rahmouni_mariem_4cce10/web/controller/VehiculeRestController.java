package tn.esprit.rahmouni_mariem_4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rahmouni_mariem_4cce10.domain.Vehicule;
import tn.esprit.rahmouni_mariem_4cce10.service.impls.VehiculeServiceImpls;

import java.util.List;

@RequestMapping("vehicules")
@RestController
@RequiredArgsConstructor
public class VehiculeRestController {

    private final VehiculeServiceImpls vehiculeServices;

    @PostMapping
    public Vehicule add(@RequestBody Vehicule vehicule) {
        return vehiculeServices.create(vehicule);
    }
    @GetMapping("{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeServices.findbyId(id);
    }
    @GetMapping
    public List<Vehicule> getVehicules() {
       return vehiculeServices.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        vehiculeServices.deleteById(id);
    }
    @PutMapping("/{id}")
    public Vehicule update(
            @PathVariable Long id,
            @RequestBody Vehicule vehicule) {

        vehicule.setIdVehicule(id);
        return vehiculeServices.update(vehicule);
    }


}
