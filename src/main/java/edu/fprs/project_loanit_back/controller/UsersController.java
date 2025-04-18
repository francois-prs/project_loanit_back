package edu.fprs.project_loanit_back.controller;

import edu.fprs.project_loanit_back.dao.UsersDao;
import edu.fprs.project_loanit_back.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UsersController {

    protected UsersDao usersDao;
    protected PasswordEncoder passwordEncoder;

    @Autowired
    public UsersController(UsersDao usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public List<Users> getAll() {
        return usersDao.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> get(@PathVariable Integer id) {
        Optional<Users> optionalUsers = usersDao.findById(id);

        if (optionalUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalUsers.get(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Users> save(@RequestBody Users user) {
        // Encode the password before saving
        user.setPasswordUser(passwordEncoder.encode(user.getPasswordUser()));

        usersDao.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Users> delete(@PathVariable Integer id) {
        Optional<Users> optionalUsers = usersDao.findById(id);

        if (optionalUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        usersDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> update(
            @PathVariable Integer id,
            @RequestBody Users user) {

        Optional<Users> optionalUsers = usersDao.findById(id);

        if (optionalUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // If password is provided and different, encode it
        Users existingUser = optionalUsers.get();
        if (user.getPasswordUser() != null &&
                !user.getPasswordUser().equals(existingUser.getPasswordUser()) &&
                !user.getPasswordUser().isEmpty()) {
            user.setPasswordUser(passwordEncoder.encode(user.getPasswordUser()));
        } else {
            // Keep the existing password if none provided
            user.setPasswordUser(existingUser.getPasswordUser());
        }

        user.setIdUser(id);
        usersDao.save(user);

        return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
    }

    // Optional: Add method to find user by email
    @GetMapping("/users/email/{email}")
    public ResponseEntity<Users> getByEmail(@PathVariable String email) {
        Optional<Users> optionalUsers = usersDao.findByEmailUser(email);

        if (optionalUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalUsers.get(), HttpStatus.OK);
    }

}
