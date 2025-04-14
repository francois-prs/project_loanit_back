package edu.fprs.project_loanit_back.dao;

import edu.fprs.project_loanit_back.model.CatEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CatEquipmentDao extends JpaRepository<CatEquipment, Integer> {


}
