package tn.esprit.rahmouni_mariem_4cce10.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Equipement {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEquipement;
    String labelle;
    @ManyToMany (mappedBy = "equipements")
    Set<Vehicule> vehicules;

}
