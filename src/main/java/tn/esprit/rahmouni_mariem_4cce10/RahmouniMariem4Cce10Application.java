package tn.esprit.rahmouni_mariem_4cce10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import tn.esprit.rahmouni_mariem_4cce10.domain.CategorieVehicule;
import tn.esprit.rahmouni_mariem_4cce10.domain.StatutVehicule;
import tn.esprit.rahmouni_mariem_4cce10.domain.Vehicule;
import tn.esprit.rahmouni_mariem_4cce10.repository.IVehiculeRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class RahmouniMariem4Cce10Application {

    private static final Logger logger =
            LoggerFactory.getLogger(RahmouniMariem4Cce10Application.class);

    public static void main(String[] args) {
        SpringApplication.run(RahmouniMariem4Cce10Application.class, args);
    }

    @Bean
    CommandLineRunner testVehicule(IVehiculeRepository vehiculeRepository) {
        return args -> {

            // =========================
            // 1. CREATE
            // =========================
            Vehicule vehicule = new Vehicule();

            vehicule.setImmatricula("555 TU 2026");
            vehicule.setMarque("Toyota");
            vehicule.setModel("Yaris");
            vehicule.setCategorie(CategorieVehicule.CITADINE);
            vehicule.setTarifJournalier(new BigDecimal("120.00"));
            vehicule.setStatut(StatutVehicule.disponible);

            Vehicule saved = vehiculeRepository.save(vehicule);

            logger.info("========== VEHICULE CREE ==========");
            logger.info("ID : {}", saved.getIdVehicule());
            logger.info("Immatriculation : {}", saved.getImmatricula());
            logger.info("Marque : {}", saved.getMarque());
            logger.info("Modèle : {}", saved.getModel());
            logger.info("===================================");


            // =========================
            // 2. FIND BY ID
            // =========================
            Vehicule vehiculeTrouve = vehiculeRepository
                    .findById(saved.getIdVehicule())
                    .orElseThrow(() ->
                            new RuntimeException("Vehicule non trouvé"));

            logger.info("========== VEHICULE TROUVE ==========");
            logger.info("ID : {}", vehiculeTrouve.getIdVehicule());
            logger.info("Immatriculation : {}",
                    vehiculeTrouve.getImmatricula());
            logger.info("Marque : {}", vehiculeTrouve.getMarque());
            logger.info("Modèle : {}", vehiculeTrouve.getModel());
            logger.info("=====================================");


            // =========================
            // 3. FIND ALL
            // =========================
            logger.info("========== TOUS LES VEHICULES ==========");

            vehiculeRepository.findAll().forEach(v ->
                    logger.info(
                            "ID : {} | Immatriculation : {} | Marque : {} | Modèle : {}",
                            v.getIdVehicule(),
                            v.getImmatricula(),
                            v.getMarque(),
                            v.getModel()
                    )
            );

            logger.info("=========================================");


            // =========================
            // 4. UPDATE
            // =========================
            vehiculeTrouve.setMarque("Renault");
            vehiculeTrouve.setModel("Clio");
            vehiculeTrouve.setTarifJournalier(new BigDecimal("150.00"));

            Vehicule updated = vehiculeRepository.save(vehiculeTrouve);

            logger.info("========== VEHICULE MODIFIE ==========");
            logger.info("ID : {}", updated.getIdVehicule());
            logger.info("Immatriculation : {}",
                    updated.getImmatricula());
            logger.info("Marque : {}", updated.getMarque());
            logger.info("Modèle : {}", updated.getModel());
            logger.info("Tarif : {}", updated.getTarifJournalier());
            logger.info("======================================");


            // =========================
            // 5. DELETE BY ID
            // =========================
            vehiculeRepository.deleteById(updated.getIdVehicule());

            logger.info("========== VEHICULE SUPPRIME ==========");
            logger.info(
                    "Véhicule avec ID {} supprimé.",
                    updated.getIdVehicule()
            );
            logger.info("=======================================");


            // =========================
            // 6. TRI PAR MARQUE
            // =========================
            logger.info(
                    "========== VEHICULES TRIES PAR MARQUE =========="
            );

            vehiculeRepository.findAll(Sort.by("marque"))
                    .forEach(v ->
                            logger.info(
                                    "ID : {} | Marque : {} | Modèle : {}",
                                    v.getIdVehicule(),
                                    v.getMarque(),
                                    v.getModel()
                            )
                    );

            logger.info("===============================================");


            // =========================
            // 7. PAGINATION
            // =========================
            logger.info("========== PAGINATION ==========");

            Page<Vehicule> page = vehiculeRepository.findAll(
                    PageRequest.of(
                            0,
                            2,
                            Sort.by("marque")
                    )
            );

            logger.info(
                    "Nombre de véhicules dans la page : {}",
                    page.getNumberOfElements()
            );

            logger.info(
                    "Page actuelle : {}",
                    page.getNumber() + 1
            );

            logger.info(
                    "Nombre total de pages : {}",
                    page.getTotalPages()
            );

            page.getContent().forEach(v ->
                    logger.info(
                            "ID : {} | Marque : {} | Modèle : {}",
                            v.getIdVehicule(),
                            v.getMarque(),
                            v.getModel()
                    )
            );

            logger.info("===============================");
        };
    }
}