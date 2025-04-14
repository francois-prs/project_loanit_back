package edu.fprs.project_loanit_back.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fprs.project_loanit_back.view.Affichage;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class ConditionEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idConditionEquipment;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String nameConditionEquipment;

}
