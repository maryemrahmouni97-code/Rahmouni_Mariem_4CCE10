package tn.esprit.rahmouni_mariem_4cce10.service;

import tn.esprit.rahmouni_mariem_4cce10.domain.Maintenance;

import java.util.List;

public interface IMaintenanceServices {

    Maintenance create(Maintenance maintenance);

    Maintenance findbyId(long id);

    List<Maintenance> findAll();

    void deleteById(long id);

    Maintenance update(Maintenance maintenance);
}