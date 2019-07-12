package com.hcl.mortgageloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgageloan.entity.MortgageOffer;

@Repository
public interface MortgageOfferRepository extends JpaRepository<MortgageOffer, Long> {

}
