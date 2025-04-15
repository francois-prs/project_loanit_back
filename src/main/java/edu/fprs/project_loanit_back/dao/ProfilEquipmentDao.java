package edu.fprs.project_loanit_back.dao;

import edu.fprs.project_loanit_back.model.ProfilEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilEquipmentDao extends JpaRepository<ProfilEquipment, Long> {


}
