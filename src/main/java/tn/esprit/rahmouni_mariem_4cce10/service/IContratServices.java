package tn.esprit.rahmouni_mariem_4cce10.service;

import tn.esprit.rahmouni_mariem_4cce10.domain.Contrat;

import java.util.List;

public interface IContratServices {

    Contrat create(Contrat contrat);

    Contrat findbyId(long id);

    List<Contrat> findAll();

    void deleteById(long id);

    Contrat update(Contrat contrat);
}