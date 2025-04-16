package edu.fprs.project_loanit_back.dao;

import edu.fprs.project_loanit_back.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDao extends JpaRepository<Equipment, String> {

    public Equipment findByNameEquipment(String name);

}
