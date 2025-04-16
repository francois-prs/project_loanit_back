package edu.fprs.project_loanit_back.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fprs.project_loanit_back.view.Affichage;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Equipment {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String idEquipment;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String nameEquipment;

    @Column(columnDefinition = "TEXT", nullable = false)
    protected String descriptionEquipment;

    @Column(length = 10, nullable = false, unique = true)
//    @Length(max = 10, min = 3)
    @NotBlank
    protected String serialNumEquipment;

    @Column(nullable = false)
//    @Temporal(TemporalType.DATE)
    protected LocalDateTime purchasedateEquipment;


    //    @ManyToMany
//    @JoinTable(
//            name = "etiquette_produit",
//            joinColumns = @JoinColumn(name = "produit_id"),//pour renommer la colonne
//            inverseJoinColumns = @JoinColumn(name = "etiquette_id") //et renommer l'autre colonne
//
//    )
//
    @ManyToOne
    @JoinColumn(nullable = false)
    private StatusEquipment statusEquipment;

    @ManyToOne
    @JoinColumn(nullable = false)
    protected ConditionEquipment conditionEquipment;


    @ManyToOne
    @JoinColumn(nullable = false)
    protected CatEquipment catEquipment;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ProfilEquipment profilEquipment;

}
