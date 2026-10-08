package tn.esprit.rahmouni_mariem_4cce10.service;

import tn.esprit.rahmouni_mariem_4cce10.domain.Employe;

import java.util.List;

public interface IEmployeServices {

    Employe create(Employe employe);

    Employe findbyId(long id);

    List<Employe> findAll();

    void deleteById(long id);

    Employe update(Employe employe);
}