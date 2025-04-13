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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id_equipment;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String name_equipment;

    @Column(columnDefinition = "TEXT", nullable = false)
    protected String description_equipment;

    @Column(length = 10, nullable = false, unique = true)
//    @Length(max = 10, min = 3)
    @NotBlank
    protected String serialNum_equipment;

    @Column(nullable = false)
//    @Temporal(TemporalType.DATE)
    protected LocalDateTime purchasedate_equipment;


//    @ManyToMany
//    @JoinTable(
//            name = "etiquette_produit",
//            joinColumns = @JoinColumn(name = "produit_id"),//pour renommer la colonne
//            inverseJoinColumns = @JoinColumn(name = "etiquette_id") //et renommer l'autre colonne
//
//    )
//
//    @ManyToOne
//    @JoinColumn(name = "id_status", nullable = false)
//    private StatusEquipment status;
//
//    @ManyToOne
//    @JoinColumn(name = "id_condition", nullable = false)
//    private Condition condition;
//
//    @ManyToOne
//    @JoinColumn(name = "id_cat_equip", nullable = false)
//    private CategoryEquipment categoryEquipment;
//
//    @ManyToOne
//    @JoinColumn(name = "id_equipmentProfil", nullable = false)
//    private EquipmentProfile equipmentProfile;

}
