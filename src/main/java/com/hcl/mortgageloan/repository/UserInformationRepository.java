package com.hcl.mortgageloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgageloan.entity.UserInformation;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

}
