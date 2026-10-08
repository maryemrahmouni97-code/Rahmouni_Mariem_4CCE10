package tn.esprit.rahmouni_mariem_4cce10.Repositry;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.rahmouni_mariem_4cce10.domain.Agence;
import tn.esprit.rahmouni_mariem_4cce10.domain.Vehicule;

public interface IAgenceRepository extends CrudRepository<Agence, Long> {

}
