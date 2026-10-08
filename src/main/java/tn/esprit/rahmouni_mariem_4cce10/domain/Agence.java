package tn.esprit.rahmouni_mariem_4cce10.domain;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAgence;
    String nom;
     String ville;
     String adresse;
     String telephone;
     @OneToMany  (mappedBy = "agence")
     Set<Vehicule> vehicules = new HashSet<Vehicule>();

}
