package edu.fprs.project_loanit_back.controller;

import edu.fprs.project_loanit_back.dao.StatusEquipmentDao;
import edu.fprs.project_loanit_back.model.StatusEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class StatusEquipmentController {

    @Autowired
    protected StatusEquipmentDao statusEquipmentDao;

    @GetMapping("/statusequipment")
    public List<StatusEquipment> getAll() {
        return statusEquipmentDao.findAll();
    }

    @GetMapping("/statusequipment/{id}")
    public ResponseEntity<StatusEquipment> get(@PathVariable int id) {

        Optional<StatusEquipment> optionalStatusEquipment = statusEquipmentDao.findById(id);

        if (optionalStatusEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalStatusEquipment.get(), HttpStatus.OK);

    }

    @PostMapping("/statusequipment")
    public ResponseEntity<StatusEquipment> save(@RequestBody StatusEquipment statusEquipment) {
        statusEquipmentDao.save(statusEquipment);
        return new ResponseEntity<>(statusEquipment, HttpStatus.CREATED);
    }

    @DeleteMapping("/statusequipment/{id}")
    public ResponseEntity<StatusEquipment> delete(@PathVariable int id) {

        Optional<StatusEquipment> optionalStatusEquipment = statusEquipmentDao.findById(id);

        if (optionalStatusEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        statusEquipmentDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/statusequipment/{id}")
    public ResponseEntity<StatusEquipment> update(
            @PathVariable int id,
            @RequestBody StatusEquipment statusEquipment) {

        Optional<StatusEquipment> optionalStatusEquipment = statusEquipmentDao.findById(id);

        if (optionalStatusEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        statusEquipment.setIdStatusEquipment(id);

        statusEquipmentDao.save(statusEquipment);

        return new ResponseEntity<>(statusEquipment, HttpStatus.NO_CONTENT);

    }
}
