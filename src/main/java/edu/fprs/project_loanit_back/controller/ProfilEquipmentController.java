package edu.fprs.project_loanit_back.controller;

import edu.fprs.project_loanit_back.dao.ProfilEquipmentDao;
import edu.fprs.project_loanit_back.model.ProfilEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ProfilEquipmentController {

    @Autowired
    protected ProfilEquipmentDao profilEquipmentDao;

    @GetMapping("/profilequipment")
    public List<ProfilEquipment> getAll() {
        return profilEquipmentDao.findAll();
    }

    @GetMapping("/profilequipment/{id}")
    public ResponseEntity<ProfilEquipment> get(@PathVariable String id) {

        Optional<ProfilEquipment> optionalProfilEquipment = profilEquipmentDao.findById(id);

        if (optionalProfilEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalProfilEquipment.get(), HttpStatus.OK);

    }

    @PostMapping("/profilequipment")
    public ResponseEntity<ProfilEquipment> save(@RequestBody ProfilEquipment profilEquipment) {
        profilEquipmentDao.save(profilEquipment);
        return new ResponseEntity<>(profilEquipment, HttpStatus.CREATED);
    }

    @DeleteMapping("/profilequipment/{id}")
    public ResponseEntity<ProfilEquipment> delete(@PathVariable String id) {

        Optional<ProfilEquipment> optionalProfilEquipment = profilEquipmentDao.findById(id);

        if (optionalProfilEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        profilEquipmentDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/profilequipment/{id}")
    public ResponseEntity<ProfilEquipment> update(
            @PathVariable String id,
            @RequestBody ProfilEquipment profilEquipment) {

        Optional<ProfilEquipment> optionalProfilEquipment = profilEquipmentDao.findById(id);

        if (optionalProfilEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        profilEquipment.setIdProfilEquipment(id);

        profilEquipmentDao.save(profilEquipment);

        return new ResponseEntity<>(profilEquipment, HttpStatus.NO_CONTENT);

    }
}
