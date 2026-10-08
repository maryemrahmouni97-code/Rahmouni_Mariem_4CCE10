package tn.esprit.rahmouni_mariem_4cce10.service;

import tn.esprit.rahmouni_mariem_4cce10.domain.Equipement;

import java.util.List;

public interface IEquipementServices {

    Equipement create(Equipement equipement);

    Equipement findbyId(long id);

    List<Equipement> findAll();

    void deleteById(long id);

    Equipement update(Equipement equipement);
}