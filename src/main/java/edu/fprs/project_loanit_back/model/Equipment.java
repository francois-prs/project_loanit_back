package edu.fprs.project_loanit_back.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fprs.project_loanit_back.view.Affichage;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Equipment {

    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected String idEquipment;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String nameEquipment;

    @Column(columnDefinition = "TEXT", nullable = false)
    protected String descriptionEquipment;

    //    @Length(max = 10, min = 3)
    @Column(length = 30, nullable = false, unique = true)
    @NotBlank
    protected String serialNumEquipment;

//    @Temporal(TemporalType.DATE)

    @Column(nullable = false)
    protected LocalDate purchasedateEquipment;


    //    @ManyToMany
//    @JoinTable(
//            name = "etiquette_produit",
//            joinColumns = @JoinColumn(name = "produit_id"),//pour renommer la colonne
//            inverseJoinColumns = @JoinColumn(name = "etiquette_id") //et renommer l'autre colonne
//
//    )
//

    @ManyToOne
    @JoinColumn(name = "id_cat_equipment", nullable = false)
    protected CatEquipment catEquipment;

    @ManyToOne
    @JoinColumn(name = "id_condition_equipment", nullable = false)
    protected ConditionEquipment conditionEquipment;

    @ManyToOne
    @JoinColumn(name = "id_profil_equipment", nullable = false)
    private ProfilEquipment profilEquipment;

    @ManyToOne
    @JoinColumn(name = "id_status_equipment", nullable = false)
    private StatusEquipment statusEquipment;


}
