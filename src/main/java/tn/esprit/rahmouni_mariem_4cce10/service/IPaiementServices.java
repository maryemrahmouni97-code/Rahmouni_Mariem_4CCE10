package tn.esprit.rahmouni_mariem_4cce10.service;

import tn.esprit.rahmouni_mariem_4cce10.domain.Paiement;

import java.util.List;

public interface IPaiementServices {

    Paiement create(Paiement paiement);

    Paiement findbyId(long id);

    List<Paiement> findAll();

    void deleteById(long id);

    Paiement update(Paiement paiement);
}