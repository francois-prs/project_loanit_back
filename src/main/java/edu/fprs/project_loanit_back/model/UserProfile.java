package edu.fprs.project_loanit_back.model;

import jakarta.persistence.*;
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
    protected String description;


}