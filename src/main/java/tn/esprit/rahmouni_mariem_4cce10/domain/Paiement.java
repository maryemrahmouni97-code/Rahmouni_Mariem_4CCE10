package tn.esprit.rahmouni_mariem_4cce10.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@ToString
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    private BigDecimal montant;

    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat;
}