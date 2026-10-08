package tn.esprit.rahmouni_mariem_4cce10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.rahmouni_mariem_4cce10.domain.Contrat;

public interface IContratRepository extends JpaRepository<Contrat, Long> {
}