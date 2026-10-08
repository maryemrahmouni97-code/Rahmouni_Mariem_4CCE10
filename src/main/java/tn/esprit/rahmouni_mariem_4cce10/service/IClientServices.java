package tn.esprit.rahmouni_mariem_4cce10.service;

import tn.esprit.rahmouni_mariem_4cce10.domain.Client;

import java.util.List;

public interface IClientServices {

    Client create(Client client);

    Client findbyId(long id);

    List<Client> findAll();

    void deleteById(long id);

    Client update(Client client);
}