package edu.fprs.project_loanit_back.controller;

import edu.fprs.project_loanit_back.dao.EquipmentDao;
import edu.fprs.project_loanit_back.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//@RequestMapping("/api/equipment")
@CrossOrigin
@RestController
public class EquipmentController {

    protected EquipmentDao equipmentDao;

    @Autowired
    public EquipmentController(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    @GetMapping("/equipments")
    public List<Equipment> getAll() {
        return equipmentDao.findAll();
    }

    @GetMapping("/equipment/{id}")
    public ResponseEntity<Equipment> get(@PathVariable int id) {

        Optional<Equipment> optionalEquipment = equipmentDao.findById(id);

        if (optionalEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalEquipment.get(), HttpStatus.OK);

    }

//    @PostMapping("/equipment")
//    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment) {
//
//        if (equipment.getCondition() == null) {
//
//            Condition Excellent = new Condition();
//            Excellent.setId(A01);
//            equipment.setCondition(Excellent);
//        }
//
//        equipment.setId(null);
//        equipmentDaoDao.save(equipment);
//        return new ResponseEntity<>(equipment, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/equipment/{id}")
//    public ResponseEntity<Equipment> updateEquipment(@PathVariable int id, @RequestBody Equipment equipment) {
//
//        if (!equipmentDao.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Optional<Equipment> optionalEquipment = equipmentDao.findById(id);
//
//        if (optionalEquipment.isEmpty()) {
//        return new ResponseEntity<>(equipment, HttpStatus.NO_CONTENT);
//    }
//
//        //@IsAdministrateur
//    @DeleteMapping("/equipment/{id}")
//    public ResponseEntity<Equipment> deleteEquipment(@PathVariable int id) {
//
//            Optional<Equipment> optionalEquipment = equipmentDao.findById(id);
//            if (optionalEquipment.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//
//            equipmentDao.deleteById(id);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
