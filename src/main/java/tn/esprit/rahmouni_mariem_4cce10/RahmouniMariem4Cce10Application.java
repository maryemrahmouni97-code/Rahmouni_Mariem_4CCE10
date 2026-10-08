package tn.esprit.rahmouni_mariem_4cce10;

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

            vehicule.setImmatricula("555 TU 2026");            vehicule.setMarque("Toyota");
            vehicule.setModel("Yaris");
            vehicule.setCategorie(CategorieVehicule.CITADINE);
            vehicule.setTarifJournalier(new BigDecimal("120.00"));
            vehicule.setStatut(StatutVehicule.disponible);

            Vehicule saved = vehiculeRepository.save(vehicule);

            System.out.println("\n========== VEHICULE CREE ==========");
            System.out.println("ID : " + saved.getIdVehicule());
            System.out.println("Immatriculation : " + saved.getImmatricula());
            System.out.println("Marque : " + saved.getMarque());
            System.out.println("Modèle : " + saved.getModel());
            System.out.println("===================================\n");


            // =========================
            // 2. FIND BY ID
            // =========================
            Vehicule vehiculeTrouve = vehiculeRepository
                    .findById(saved.getIdVehicule())
                    .orElseThrow(() -> new RuntimeException("Vehicule non trouvé"));

            System.out.println("========== VEHICULE TROUVE ==========");
            System.out.println("ID : " + vehiculeTrouve.getIdVehicule());
            System.out.println("Immatriculation : " + vehiculeTrouve.getImmatricula());
            System.out.println("Marque : " + vehiculeTrouve.getMarque());
            System.out.println("Modèle : " + vehiculeTrouve.getModel());
            System.out.println("=====================================\n");


            // =========================
            // 3. FIND ALL
            // =========================
            System.out.println("========== TOUS LES VEHICULES ==========");

            vehiculeRepository.findAll().forEach(v -> {
                System.out.println(
                        "ID : " + v.getIdVehicule()
                                + " | Immatriculation : " + v.getImmatricula()
                                + " | Marque : " + v.getMarque()
                                + " | Modèle : " + v.getModel()
                );
            });

            System.out.println("=========================================\n");


            // =========================
            // 4. UPDATE
            // =========================
            vehiculeTrouve.setMarque("Renault");
            vehiculeTrouve.setModel("Clio");
            vehiculeTrouve.setTarifJournalier(new BigDecimal("150.00"));

            Vehicule updated = vehiculeRepository.save(vehiculeTrouve);

            System.out.println("========== VEHICULE MODIFIE ==========");
            System.out.println("ID : " + updated.getIdVehicule());
            System.out.println("Immatriculation : " + updated.getImmatricula());
            System.out.println("Marque : " + updated.getMarque());
            System.out.println("Modèle : " + updated.getModel());
            System.out.println("Tarif : " + updated.getTarifJournalier());
            System.out.println("======================================\n");


            // =========================
            // 5. DELETE BY ID
            // =========================
            vehiculeRepository.deleteById(updated.getIdVehicule());

            System.out.println("========== VEHICULE SUPPRIME ==========");
            System.out.println("Véhicule avec ID "
                    + updated.getIdVehicule()
                    + " supprimé.");
            System.out.println("=======================================\n");


            // =========================
            // 6. TRI PAR MARQUE
            // =========================
            System.out.println("========== VEHICULES TRIES PAR MARQUE ==========");

            vehiculeRepository.findAll(Sort.by("marque"))
                    .forEach(v -> {
                        System.out.println(
                                "ID : " + v.getIdVehicule()
                                        + " | Marque : " + v.getMarque()
                                        + " | Modèle : " + v.getModel()
                        );
                    });

            System.out.println("===============================================\n");


            // =========================
            // 7. PAGINATION
            // =========================
            System.out.println("========== PAGINATION ==========");

            Page<Vehicule> page = vehiculeRepository.findAll(
                    PageRequest.of(0, 2, Sort.by("marque"))
            );

            System.out.println("Nombre de véhicules dans la page : "
                    + page.getNumberOfElements());

            System.out.println("Page actuelle : "
                    + (page.getNumber() + 1));

            System.out.println("Nombre total de pages : "
                    + page.getTotalPages());

            page.getContent().forEach(v -> {
                System.out.println(
                        "ID : " + v.getIdVehicule()
                                + " | Marque : " + v.getMarque()
                                + " | Modèle : " + v.getModel()
                );
            });

            System.out.println("===============================\n");
        };
    }
}