
package tn.esprit.rahmouni_mariem_4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rahmouni_mariem_4cce10.domain.Employe;
import tn.esprit.rahmouni_mariem_4cce10.service.impls.EmployeServiceImpls;

import java.util.List;

@RequestMapping("employes")
@RestController
@RequiredArgsConstructor
public class EmployeRestController {

    private final EmployeServiceImpls employeServices;

    @PostMapping
    public Employe add(@RequestBody Employe employe) {
        return employeServices.create(employe);
    }

    @GetMapping("{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeServices.findbyId(id);
    }

    @GetMapping
    public List<Employe> getEmployes() {
        return employeServices.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        employeServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public Employe update(
            @PathVariable Long id,
            @RequestBody Employe employe) {

        employe.setIdEmploye(id);
        return employeServices.update(employe);
    }
}
