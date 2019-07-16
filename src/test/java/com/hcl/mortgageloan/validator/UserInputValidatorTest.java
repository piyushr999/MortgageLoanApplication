package com.hcl.mortgageloan.validator;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.hcl.mortgageloan.dto.UserInputDto;
import com.hcl.mortgageloan.exception.InvalidInputException;

public class UserInputValidatorTest {

	private UserInputValidator userInputValidator;

	private UserInputDto userInputDto;

	@Before
	public void setUp() {
		userInputValidator = new UserInputValidator();
		userInputDto = new UserInputDto();
	}

	@Test
	public void testSucess() throws InvalidInputException {
		userInputDto.setDateOfBirth(new Date("12/12/1976"));
		userInputDto.setMonthlySalary(Double.valueOf(20000));
		userInputDto.setPropAreaSize(Double.valueOf(5000));
		assertTrue(userInputValidator.validateInput(userInputDto, Double.valueOf(100)));
	}
	
	@Test(expected = InvalidInputException.class)
	public void testInvlaidInputExceptionWhenDOBIsLessThan25() throws InvalidInputException {
		userInputDto.setDateOfBirth(new Date("12/12/2019"));
		userInputValidator.validateInput(userInputDto, Double.valueOf(100));
	}
	
	@Test(expected = InvalidInputException.class)
	public void testInvlaidInputExceptionWhenSalaryLessThan10K() throws InvalidInputException {
		userInputDto.setDateOfBirth(new Date("12/12/1985"));
		userInputDto.setMonthlySalary(Double.valueOf(5000));
		userInputValidator.validateInput(userInputDto, Double.valueOf(100));
	}
	
	@Test(expected = InvalidInputException.class)
	public void testInvlaidInputExceptionWhenLoanAmountIsLessThan5L() throws InvalidInputException {
		userInputDto.setDateOfBirth(new Date("12/12/1985"));
		userInputDto.setMonthlySalary(Double.valueOf(20000));
		userInputDto.setPropAreaSize(Double.valueOf(500));
		userInputValidator.validateInput(userInputDto, Double.valueOf(100));
	}


}
