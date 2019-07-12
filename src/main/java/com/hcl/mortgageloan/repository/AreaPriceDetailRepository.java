package com.hcl.mortgageloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgageloan.entity.AreaPriceDetail;

/**
 * @author Administrator
 *
 */
@Repository
public interface AreaPriceDetailRepository extends JpaRepository<AreaPriceDetail, Long> {
	
	AreaPriceDetail findByPinCode(String pinCode);
}
