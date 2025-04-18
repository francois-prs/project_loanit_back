package edu.fprs.project_loanit_back.controller;

import edu.fprs.project_loanit_back.dao.ProfileEquipmentDao;
import edu.fprs.project_loanit_back.model.ProfileEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProfileEquipmentController {

    @Autowired
    protected ProfileEquipmentDao profileEquipmentDao;

    @GetMapping("/profileequipment")
    public List<ProfileEquipment> getAll() {
        return profileEquipmentDao.findAll();
    }

    @GetMapping("/profileequipment/{id}")
    public ResponseEntity<ProfileEquipment> get(@PathVariable String id) {

        Optional<ProfileEquipment> optionalProfileEquipment = profileEquipmentDao.findById(id);

        if (optionalProfileEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalProfileEquipment.get(), HttpStatus.OK);

    }

    @PostMapping("/profileequipment")
    public ResponseEntity<ProfileEquipment> save(@RequestBody ProfileEquipment profileEquipment) {
        profileEquipmentDao.save(profileEquipment);
        return new ResponseEntity<>(profileEquipment, HttpStatus.CREATED);
    }

    @DeleteMapping("/profileequipment/{id}")
    public ResponseEntity<ProfileEquipment> delete(@PathVariable String id) {

        Optional<ProfileEquipment> optionalProfileEquipment = profileEquipmentDao.findById(id);

        if (optionalProfileEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        profileEquipmentDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/profileequipment/{id}")
    public ResponseEntity<ProfileEquipment> update(
            @PathVariable String id,
            @RequestBody ProfileEquipment profileEquipment) {

        Optional<ProfileEquipment> optionalProfileEquipment = profileEquipmentDao.findById(id);

        if (optionalProfileEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        profileEquipment.setIdProfileEquipment(id);

        profileEquipmentDao.save(profileEquipment);

        return new ResponseEntity<>(profileEquipment, HttpStatus.NO_CONTENT);

    }
}
