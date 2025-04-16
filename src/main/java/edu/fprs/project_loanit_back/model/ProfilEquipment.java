package edu.fprs.project_loanit_back.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fprs.project_loanit_back.view.Affichage;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProfilEquipment {


    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected String idProfilEquipment;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class) // A quoi ça sert???
    protected String nameProfilEquipment;
}
