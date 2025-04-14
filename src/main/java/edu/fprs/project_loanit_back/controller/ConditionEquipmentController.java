package edu.fprs.project_loanit_back.controller;

import edu.fprs.project_loanit_back.dao.ConditionEquipmentDao;
import edu.fprs.project_loanit_back.model.ConditionEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ConditionEquipment> get(@PathVariable int id) {

        Optional<ConditionEquipment> optionalConditionEquipment = conditionEquipmentDao.findById(id);

        if (optionalConditionEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalConditionEquipment.get(), HttpStatus.OK);

    }
}
