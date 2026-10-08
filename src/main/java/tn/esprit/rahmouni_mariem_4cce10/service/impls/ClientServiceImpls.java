package tn.esprit.rahmouni_mariem_4cce10.service.impls;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.rahmouni_mariem_4cce10.domain.Client;
import tn.esprit.rahmouni_mariem_4cce10.repository.IClientRepository;
import tn.esprit.rahmouni_mariem_4cce10.service.IClientServices;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImpls implements IClientServices {

    private final IClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findbyId(long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }
}