package com.hcl.mortgageloan.entity;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class UserInformationTest {

	@Test
	public void testUserInformation() {
		new BeanTester().testBean(UserInformation.class);
	}

}
