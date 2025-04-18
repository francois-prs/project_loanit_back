package edu.fprs.project_loanit_back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import edu.fprs.project_loanit_back.view.Affichage;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idUser;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String firstnameUser;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String lastnameUser;

    @Column(nullable = false, unique = true)
    @NotBlank
    @JsonView(Affichage.class)
    @Email
    protected String emailUser;

    //uniquement num français pour l'instant
    @Column(nullable = false, unique = true)
    @NotBlank
    @JsonView(Affichage.class)
    @Pattern(regexp = "^(0|\\+33)[1-9](\\d{2}){4}$", message = "Please enter a valid French phone number")
    protected String phoneUser;

    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must be at least 8 characters and include at least one digit, one lowercase letter, one uppercase letter, and one special character")
    @Column(nullable = false)
    @NotBlank//(groups = {OnCreate.class})
    @JsonIgnore
    protected String passwordUser;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    @JsonView(Affichage.class)
    protected LocalDate creationDateUser;

    @Column(nullable = false)
    @JsonView(Affichage.class)
    protected Boolean activeUser = true; // Default to active when creating a new user

    // not used at the moment. To be used if decision is made to track last login date to make User Inactive
//    @Column
//    @JsonView(Affichage.class)
//    private LocalDate lastActivityDate;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String streetUser;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String cityUser;

    @Column(nullable = false)
    @NotBlank
    @Pattern(regexp = "^\\d{5}$", message = "Postal code must be 5 digits")
    @JsonView(Affichage.class)
    protected String postalCodeUser;

    @Column(nullable = false)
    @NotBlank
    @JsonView(Affichage.class)
    protected String countryUser;

//    // In case we go for a ENUM instead of separate Table in db
//    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "ENUM('junior', 'superuser', 'administrator')")
//    protected Role userProfile;

    @ManyToOne
    @JoinColumn(name = "id_user_profile", nullable = false)
    protected UserProfile userProfile;

}
