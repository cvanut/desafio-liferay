package tests;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getTimeOut;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getUrlToHome;
import static com.liferay.gs.testFramework.SeleniumWaitMethods.getWaitDriver;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import pages.formsPage;


public class TesteSubmitFormSucessfully {

	formsPage formsPage = new formsPage();

	@BeforeClass
	public static void setUp() {
		DRIVER.manage().window().fullscreen();
		DRIVER.get(getUrlToHome());
		DRIVER.manage().timeouts().implicitlyWait(getTimeOut(), TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor) DRIVER;
		getWaitDriver().until(webDriver -> jse.executeScript("return document.readyState").equals("complete"));
		System.out.println("page loaded");
	}

	
	@Test
	public void verifyIfAUserCanSubmitTheFormSucessfully() {
		// SCENARIO: CADASTRO COM SUCESSO
		// Given that a user have to fill the form
		// And he/she fill all the form and click on submit
		// Then a page showing a success text should be loaded.
		
		formsPage.fillName("Cleyton");
		formsPage.setDate();
		formsPage.fillMotivation();
		formsPage.clickOnSubmit();
		formsPage.clickOnSubmit();
		formsPage.clickOnSubmit();
		assertTrue(formsPage.verifySuccess());
	}


	@AfterClass
	public static void tearDown() {
		DRIVER.close();
		DRIVER.quit();
	}

}
