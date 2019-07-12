package com.hcl.mortgageloan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.mortgageloan.entity.MortgageOffer;

/**
 * @author Administrator
 *
 */
@Repository
public interface MortgageOfferRepository extends JpaRepository<MortgageOffer, Long> {

	@Query(value = "select * from mortgage_offer where loan_amount <= :eligibleLoanAmount", nativeQuery = true)
	List<MortgageOffer> retrieveEligibleOffers(@Param("eligibleLoanAmount") Double eligibleLoanAmount);

}
