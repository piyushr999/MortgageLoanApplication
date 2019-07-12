package com.hcl.mortgageloan.validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.stereotype.Component;

import com.hcl.mortgageloan.dto.UserInputDto;
import com.hcl.mortgageloan.exception.InvalidInputException;

/**
 * @author Administrator
 *
 */
@Component
public class UserInputValidator {

	/**
	 * This method is used to validate user inputs
	 * 
	 * @param userInput
	 * @param AreaPrice
	 * @return true is all inputs are valid
	 * @throws InvalidInputException
	 */
	public boolean validateInput(UserInputDto userInput, Double price) throws InvalidInputException {
		if (Period.between(userInput.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				LocalDate.now()).getYears() < 25) {
			throw new InvalidInputException("You are not eligible for loan. Minimum age should be 25");
		} else if (userInput.getMonthlySalary() < 10000) {
			throw new InvalidInputException("You are not eligible for loan. Minimum salary should be 10000");
		} else if ((userInput.getPropAreaSize() * price) < 500000) {
			throw new InvalidInputException("You are not eligible for loan. Minimum property value should be 500000");
		}
		return true;
	}
}
