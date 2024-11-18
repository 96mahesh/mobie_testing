package com.moble.Tests;

import org.testng.annotations.Test;
import com.mobile.pages.LoginAppPage;
import com.mobile.utils.BaseClass;


public class LoginAppTest extends BaseClass {

	LoginAppPage loginapp;
	
	@Test
	public void verifyValidFunctionalityOfPatasalaApp() throws Exception {
		 loginapp = new LoginAppPage(BaseClass.driver);
		loginapp.LoginMonileApp();
	}
}
