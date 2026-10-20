
package tn.esprit.rahmouni_mariem_4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rahmouni_mariem_4cce10.domain.Agence;
import tn.esprit.rahmouni_mariem_4cce10.service.impls.AgenceServiceImpls;

import java.util.List;

@RequestMapping("agences")
@RestController
@RequiredArgsConstructor
public class AgenceRestController {

    private final AgenceServiceImpls agenceServices;

    @PostMapping
    public Agence add(@RequestBody Agence agence) {
        return agenceServices.create(agence);
    }

    @GetMapping("{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return agenceServices.findbyId(id);
    }

    @GetMapping
    public List<Agence> getAgences() {
        return agenceServices.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        agenceServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public Agence update(
            @PathVariable Long id,
            @RequestBody Agence agence) {

        agence.setIdAgence(id);
        return agenceServices.update(agence);
    }
}
