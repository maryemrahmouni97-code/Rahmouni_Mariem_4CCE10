
package tn.esprit.rahmouni_mariem_4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rahmouni_mariem_4cce10.domain.Equipement;
import tn.esprit.rahmouni_mariem_4cce10.service.impls.EquipementServiceImpls;

import java.util.List;

@RequestMapping("equipements")
@RestController
@RequiredArgsConstructor
public class EquipementRestController {

    private final EquipementServiceImpls equipementServices;

    @PostMapping
    public Equipement add(@RequestBody Equipement equipement) {
        return equipementServices.create(equipement);
    }

    @GetMapping("{id}")
    public Equipement getEquipementById(@PathVariable Long id) {
        return equipementServices.findbyId(id);
    }

    @GetMapping
    public List<Equipement> getEquipements() {
        return equipementServices.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        equipementServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public Equipement update(
            @PathVariable Long id,
            @RequestBody Equipement equipement) {

        equipement.setIdEquipement(id);
        return equipementServices.update(equipement);
    }
}
