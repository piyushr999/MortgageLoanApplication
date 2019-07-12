package com.hcl.mortgageloan.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.mortgageloan.dto.UserInputDto;
import com.hcl.mortgageloan.entity.AreaPriceDetail;
import com.hcl.mortgageloan.entity.MortgageOffer;
import com.hcl.mortgageloan.entity.UserInformation;
import com.hcl.mortgageloan.exception.InvalidInputException;
import com.hcl.mortgageloan.repository.AreaPriceDetailRepository;
import com.hcl.mortgageloan.repository.MortgageOfferRepository;
import com.hcl.mortgageloan.repository.UserInformationRepository;
import com.hcl.mortgageloan.validator.UserInputValidator;

/**
 * @author Administrator
 *
 */
@Service
public class MortgageLoanService {

	@Autowired
	private AreaPriceDetailRepository areaPriceDetailRepository;

	@Autowired
	private MortgageOfferRepository mortgageOfferRepository;

	@Autowired
	private UserInformationRepository userInformationRepository;

	@Autowired
	private UserInputValidator inputValidator;

	/**
	 * Its is used to submit loan application
	 * 
	 * @param userInput
	 * @return Eligible offers
	 * @throws InvalidInputException
	 */
	public List<MortgageOffer> submitApplication(@RequestBody UserInputDto userInput) throws InvalidInputException {

		AreaPriceDetail areaPriceDetail = areaPriceDetailRepository.findByPinCode(userInput.getPropertyPinCode());
		if (null == areaPriceDetail) {
			throw new InvalidInputException(
					"Service not available for mentioned property PinCode :" + userInput.getPropertyPinCode());
		} else if (inputValidator.validateInput(userInput, areaPriceDetail.getAreaPrice())) {

			UserInformation information = new UserInformation();

			information.setFullName(userInput.getApplicantName());
			information.setPhoneNumber(userInput.getContactNumber());
			information.setDob(userInput.getDateOfBirth());
			information.setEmailId(userInput.getEmail());
			information.setGender(userInput.getSex());
			information.setPanNumber(userInput.getPan());
			information.setSalary(userInput.getMonthlySalary());
			information.setPinCode(userInput.getPropertyPinCode());
			information.setPropertyType(userInput.getPropType());
			information.setPropertyAddress(userInput.getPropAddress());
			information.setPropertyAreaSize(userInput.getPropAreaSize());

			Double eligibleLoanAmount = ((userInput.getPropAreaSize() * areaPriceDetail.getAreaPrice()) * 80) / 100;

			userInformationRepository.save(information);
			return mortgageOfferRepository.retrieveEligibleOffers(eligibleLoanAmount);
		}

		return Collections.emptyList();

	}

}
