package edu.fprs.project_loanit_back.dao;

import edu.fprs.project_loanit_back.model.StatusEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusEquipmentDao extends JpaRepository<StatusEquipment, Integer> {

}
