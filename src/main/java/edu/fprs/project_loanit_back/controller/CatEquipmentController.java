package edu.fprs.project_loanit_back.controller;

import edu.fprs.project_loanit_back.dao.CatEquipmentDao;
import edu.fprs.project_loanit_back.model.CatEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CatEquipmentController {

    @Autowired
    protected CatEquipmentDao catEquipmentDao;

//    @Autowired
//    public CatEquipmentController(CatEquipmentDao catEquipmentDao) {
//        this.catEquipmentDao = catEquipmentDao;
//    }

    @GetMapping("/category")
    public List<CatEquipment> getAll() {
        return catEquipmentDao.findAll();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CatEquipment> get(@PathVariable int id) {

        Optional<CatEquipment> optionalCatEquipment = catEquipmentDao.findById(id);

        if (optionalCatEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalCatEquipment.get(), HttpStatus.OK);

    }

    @PostMapping("/category")
    public ResponseEntity<CatEquipment> save(@RequestBody CatEquipment catEquipment) {
        catEquipmentDao.save(catEquipment);
        return new ResponseEntity<>(catEquipment, HttpStatus.CREATED);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<CatEquipment> delete(@PathVariable int id) {

        Optional<CatEquipment> optionalCatEquipment = catEquipmentDao.findById(id);

        if (optionalCatEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        catEquipmentDao.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CatEquipment> update(
            @PathVariable int id,
            @RequestBody CatEquipment catEquipment) {

        Optional<CatEquipment> optionalCatEquipment = catEquipmentDao.findById(id);

        if (optionalCatEquipment.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        catEquipment.setIdCatEquipment(id);

        catEquipmentDao.save(catEquipment);

        return new ResponseEntity<>(catEquipment, HttpStatus.NO_CONTENT);

    }

}
