
package tn.esprit.rahmouni_mariem_4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rahmouni_mariem_4cce10.domain.Contrat;
import tn.esprit.rahmouni_mariem_4cce10.service.impls.ContratServiceImpls;

import java.util.List;

@RequestMapping("contrats")
@RestController
@RequiredArgsConstructor
public class ContratRestController {

    private final ContratServiceImpls contratServices;

    @PostMapping
    public Contrat add(@RequestBody Contrat contrat) {
        return contratServices.create(contrat);
    }

    @GetMapping("{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratServices.findbyId(id);
    }

    @GetMapping
    public List<Contrat> getContrats() {
        return contratServices.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        contratServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public Contrat update(
            @PathVariable Long id,
            @RequestBody Contrat contrat) {

        contrat.setIdContrat(id);
        return contratServices.update(contrat);
    }
}
