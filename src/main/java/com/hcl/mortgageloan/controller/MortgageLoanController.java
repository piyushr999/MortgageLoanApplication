package com.hcl.mortgageloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgageloan.dto.UserInputDto;
import com.hcl.mortgageloan.entity.MortgageOffer;
import com.hcl.mortgageloan.exception.InvalidInputException;
import com.hcl.mortgageloan.service.MortgageLoanService;

/**
 * @author Administrator
 *
 */
@RestController
public class MortgageLoanController {

	@Autowired
	private MortgageLoanService mortgageLoanService;

	/**
	 * This method is used to submit loan application
	 * 
	 * @param userInput
	 * @return List of mortgage offers
	 * @throws InvalidInputException
	 */
	@PostMapping("/request")
	public ResponseEntity<Object> submitApplication(@RequestBody UserInputDto userInput) {
		try {
			List<MortgageOffer> mortgageOffers = mortgageLoanService.submitApplication(userInput);
			if (mortgageOffers.isEmpty()) {
				return new ResponseEntity<>("Sorry no offer available for mentioned property", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(mortgageOffers, HttpStatus.ACCEPTED);
			}
		} catch (InvalidInputException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}
