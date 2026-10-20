
package tn.esprit.rahmouni_mariem_4cce10.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rahmouni_mariem_4cce10.domain.Client;
import tn.esprit.rahmouni_mariem_4cce10.service.impls.ClientServiceImpls;

import java.util.List;

@RequestMapping("clients")
@RestController
@RequiredArgsConstructor
public class ClientRestController {

    private final ClientServiceImpls clientServices;

    @PostMapping
    public Client add(@RequestBody Client client) {
        return clientServices.create(client);
    }

    @GetMapping("{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientServices.findbyId(id);
    }

    @GetMapping
    public List<Client> getClients() {
        return clientServices.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        clientServices.deleteById(id);
    }

    @PutMapping("/{id}")
    public Client update(
            @PathVariable Long id,
            @RequestBody Client client) {

        client.setIdClient(id);
        return clientServices.update(client);
    }
}
