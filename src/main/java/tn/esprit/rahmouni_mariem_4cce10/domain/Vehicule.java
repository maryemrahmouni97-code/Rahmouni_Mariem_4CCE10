
package tn.esprit.rahmouni_mariem_4cce10.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @Column(nullable = false, unique = true)
    private String immatricula;

    private String marque;
    private String model;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    @ManyToOne
    @ToString.Exclude
    private Agence agence;

    @ManyToMany
    @ToString.Exclude
    private Set<Equipement> equipements = new HashSet<>();
}
