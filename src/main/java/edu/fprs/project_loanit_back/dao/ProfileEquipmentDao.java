package edu.fprs.project_loanit_back.dao;

import edu.fprs.project_loanit_back.model.ProfileEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileEquipmentDao extends JpaRepository<ProfileEquipment, String> {


}
