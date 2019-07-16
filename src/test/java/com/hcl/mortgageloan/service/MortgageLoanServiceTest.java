package com.hcl.mortgageloan.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.mortgageloan.dto.UserInputDto;
import com.hcl.mortgageloan.entity.AreaPriceDetail;
import com.hcl.mortgageloan.entity.MortgageOffer;
import com.hcl.mortgageloan.exception.InvalidInputException;
import com.hcl.mortgageloan.repository.AreaPriceDetailRepository;
import com.hcl.mortgageloan.repository.MortgageOfferRepository;
import com.hcl.mortgageloan.repository.UserInformationRepository;
import com.hcl.mortgageloan.validator.UserInputValidator;

@RunWith(MockitoJUnitRunner.class)
public class MortgageLoanServiceTest {

	@InjectMocks
	private MortgageLoanService mortgageLoanService;

	@Mock
	private UserInputValidator inputValidator;

	@Mock
	private UserInformationRepository informationRepository;

	@Mock
	private AreaPriceDetailRepository areaPriceDetailRepository;

	@Mock
	private MortgageOfferRepository mortgageOfferRepository;

	private UserInputDto userInputDto;

	private AreaPriceDetail areaPriceDetails;

	private List<MortgageOffer> offerList;

	@Before
	public void setUp() {
		areaPriceDetails = new AreaPriceDetail();
		areaPriceDetails.setAreaPrice(Double.valueOf(1000));

		userInputDto = new UserInputDto();
		userInputDto.setPropertyPinCode("411028");
		userInputDto.setPropAreaSize(Double.valueOf(100));

		MortgageOffer mortgageOffer = new MortgageOffer();
		mortgageOffer.setTenureInMonths(100);
		offerList = new ArrayList<>();
		offerList.add(mortgageOffer);

	}

	@Test
	public void testSubmitApplication() throws InvalidInputException {
		when(areaPriceDetailRepository.findByPinCode("411028")).thenReturn(areaPriceDetails);
		when(inputValidator.validateInput(userInputDto, areaPriceDetails.getAreaPrice())).thenReturn(true);
		// when(informationRepository.save(userInformation)).thenReturn(userInformation);
		when(mortgageOfferRepository.retrieveEligibleOffers(Double.valueOf(80000))).thenReturn(offerList);
		assertTrue(mortgageLoanService.submitApplication(userInputDto).size() > 0);
	}

	@Test
	public void testSubmitApplicationWhenValidationFailed() throws InvalidInputException {
		when(areaPriceDetailRepository.findByPinCode("411028")).thenReturn(areaPriceDetails);
		when(inputValidator.validateInput(userInputDto, areaPriceDetails.getAreaPrice())).thenReturn(false);
		assertFalse(mortgageLoanService.submitApplication(userInputDto).size() > 0);
	}

	@Test(expected = InvalidInputException.class)
	public void testSubmitApplicationWhenAeraPriceIsNull() throws InvalidInputException {
		when(areaPriceDetailRepository.findByPinCode("411028")).thenReturn(null);
		mortgageLoanService.submitApplication(userInputDto);
	}

}
