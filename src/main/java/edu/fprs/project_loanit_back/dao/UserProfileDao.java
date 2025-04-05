package edu.fprs.project_loanit_back.dao;

import edu.fprs.project_loanit_back.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileDao extends JpaRepository<UserProfile, Integer> {

}
