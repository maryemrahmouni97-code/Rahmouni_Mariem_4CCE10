package tn.esprit.rahmouni_mariem_4cce10.service;

import tn.esprit.rahmouni_mariem_4cce10.domain.Agence;

import java.util.List;

public interface IAgenceServices {

    Agence create(Agence agence);

    Agence findbyId(long id);

    List<Agence> findAll();

    void deleteById(long id);

    Agence update(Agence agence);
}