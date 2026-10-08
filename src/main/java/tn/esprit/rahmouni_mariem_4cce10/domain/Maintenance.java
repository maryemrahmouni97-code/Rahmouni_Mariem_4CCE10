package tn.esprit.rahmouni_mariem_4cce10.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMaintenance;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    @ManyToOne
    private Vehicule vehicule;
}
