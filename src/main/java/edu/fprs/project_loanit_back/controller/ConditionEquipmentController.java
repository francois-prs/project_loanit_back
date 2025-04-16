package edu.fprs.project_loanit_back.controller;

import edu.fprs.project_loanit_back.dao.ConditionEquipmentDao;
import edu.fprs.project_loanit_back.model.ConditionEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ConditionEquipmentController {

    @Autowired
    protected ConditionEquipmentDao conditionEquipmentDao;

    @GetMapping("/condition")
    public List<ConditionEquipment> getAll() {
        return conditionEquipmentDao.findAll();
    }

    @GetMapping("/condition/{id}")
    public ResponseEntity<ConditionEquipment> get(@PathVariable String id) {

        Optional<ConditionEquipment> optionalConditionEquipment = conditionEquipmentDao.findById(id);

        if (optionalConditionEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalConditionEquipment.get(), HttpStatus.OK);

    }

    @PostMapping("/condition")
    public ResponseEntity<ConditionEquipment> save(@RequestBody ConditionEquipment conditionEquipment) {
        conditionEquipmentDao.save(conditionEquipment);
        return new ResponseEntity<>(conditionEquipment, HttpStatus.CREATED);
    }

    @DeleteMapping("/condition/{id}")
    public ResponseEntity<ConditionEquipment> delete(@PathVariable String id) {

        Optional<ConditionEquipment> optionalConditionEquipment = conditionEquipmentDao.findById(id);

        if (optionalConditionEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        conditionEquipmentDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/condition/{id}")
    public ResponseEntity<ConditionEquipment> update(
            @PathVariable String id,
            @RequestBody ConditionEquipment conditionEquipment) {

        Optional<ConditionEquipment> optionalConditionEquipment = conditionEquipmentDao.findById(id);

        if (optionalConditionEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        conditionEquipment.setIdConditionEquipment(id);

        conditionEquipmentDao.save(conditionEquipment);

        return new ResponseEntity<>(conditionEquipment, HttpStatus.NO_CONTENT);

    }
}
