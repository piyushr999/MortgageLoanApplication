package com.hcl.mortgageloan.dto;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class UserInputDtoTest {

	@Test
	public void testUserInputDto() {
		new BeanTester().testBean(UserInputDto.class);
	}

}
