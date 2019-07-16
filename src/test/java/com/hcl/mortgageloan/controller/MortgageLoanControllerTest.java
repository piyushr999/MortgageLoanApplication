package com.hcl.mortgageloan.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mortgageloan.dto.UserInputDto;
import com.hcl.mortgageloan.entity.MortgageOffer;
import com.hcl.mortgageloan.exception.InvalidInputException;
import com.hcl.mortgageloan.service.MortgageLoanService;

@RunWith(MockitoJUnitRunner.class)
public class MortgageLoanControllerTest {

	@InjectMocks
	private MortgageLoanController mortgageLoanController;

	@Mock
	private MortgageLoanService mortgageLoanService;

	private UserInputDto userInput;

	@Before
	public void setUp() {
		userInput = new UserInputDto();
	}

	@Test
	public void testSubmitRequestWithEmpltyList() throws InvalidInputException {
		
		Mockito.when(mortgageLoanService.submitApplication(userInput)).thenReturn(Collections.emptyList());
		assertNotNull(mortgageLoanController.submitApplication(userInput));
	}

	@Test
	public void testSubmitRequestWithOutputList() throws InvalidInputException {
		List<MortgageOffer> mortgageOffers = new ArrayList<>();
		mortgageOffers.add(new MortgageOffer());
		Mockito.when(mortgageLoanService.submitApplication(userInput)).thenReturn(mortgageOffers);
		assertNotNull(mortgageLoanController.submitApplication(userInput));
	}

	@Test
	public void testSubmitRequestWithInvalidInputException() throws InvalidInputException {
		Mockito.when(mortgageLoanService.submitApplication(userInput)).thenThrow(new InvalidInputException(""));
		assertNotNull(mortgageLoanController.submitApplication(userInput));
	}

}
