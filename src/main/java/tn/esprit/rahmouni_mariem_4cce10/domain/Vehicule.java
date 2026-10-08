package tn.esprit.rahmouni_mariem_4cce10.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity

public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVehicule;
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
    private Agence agence;
    @ManyToMany
    Set<Equipement> equipements=new HashSet<Equipement>();
}
