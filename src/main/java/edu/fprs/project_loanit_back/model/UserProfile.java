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
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY = auto incrementation de mySQL
    protected Integer id; //Integer etant un objet il peut avoir une valeur nulle

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String nameUserProfil;


}