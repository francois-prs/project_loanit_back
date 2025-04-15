package edu.fprs.project_loanit_back.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fprs.project_loanit_back.view.Affichage;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StatusEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idStatusEquipment;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class) // A quoi ça sert???
    protected String nameStatusEquipment;

}
