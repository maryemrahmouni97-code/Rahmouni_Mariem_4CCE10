
package tn.esprit.rahmouni_mariem_4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rahmouni_mariem_4cce10.domain.Paiement;
import tn.esprit.rahmouni_mariem_4cce10.service.impls.PaiementServiceImpls;

import java.util.List;

@RequestMapping("paiements")
@RestController
@RequiredArgsConstructor
public class PaiementRestController {

    private final PaiementServiceImpls paiementServices;

    @GetMapping("{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementServices.findbyId(id);
    }

    @GetMapping
    public List<Paiement> getPaiements() {
        return paiementServices.findAll();
    }
}
