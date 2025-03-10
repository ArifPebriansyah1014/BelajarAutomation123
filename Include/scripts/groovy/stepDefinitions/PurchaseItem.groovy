package stepDefinitions
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import stepDefinitions.Login

class PurchaseItem {

	Login login = new Login()

	@Given("user berada di halaman utama web")
	public void user_berada_di_halaman_utama_web() {
		login.user_berada_di_login_page()
		login.user_input_username_dan_password("standard_user", "secret_sauce")
		login.user_klik_login()
	}

	@When("user pilih dua item")
	public void user_pilih_dua_item() {
		WebUI.click(findTestObject('Object Repository/Add to Cart/Barang_Backpack'))
		WebUI.click(findTestObject('Object Repository/Add to Cart/Barang_Bike_Light'))
	}

	@When("user klik keranjang dan checkout")
	public void user_klik_keranjang_dan_checkout() {
		WebUI.click(findTestObject('Object Repository/Add to Cart/Keranjang'))
		WebUI.click(findTestObject('Object Repository/Add to Cart/Btn_Checkout'))
	}

	@When("user input firstName lastName postalCode")
	public void user_input_firstName_lastName_postalCode() {

		String firstName = GlobalVariable.GlobalFirstname
		String lastName = GlobalVariable.GlobalLastname
		String postalCode = GlobalVariable.GlobalPostalcode
		
		println("firstName: " + firstName)
		println("lastName: " + lastName)
		println("postalCode: " + postalCode)

		WebUI.setText(findTestObject('Object Repository/Add to Cart/Input_Checkout_Firstname'), firstName)
		WebUI.setText(findTestObject('Object Repository/Add to Cart/Input_Checkout_Lastname'), lastName)
		WebUI.setText(findTestObject('Object Repository/Add to Cart/Input_Checkout_Postalcode'), postalCode)
	}

	@When("user klik continue")
	public void user_klik_continue() {
		WebUI.click(findTestObject('Object Repository/Add to Cart/Btn_Continue'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Add to Cart/PaymentInformation'), 0)
	}

	@Then("user klik finish dan selesai melakukan pembayaran")
	public void user_klik_finish_dan_selesai_melakukan_pembayaran() {
		WebUI.click(findTestObject('Object Repository/Add to Cart/Btn_Finish'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Add to Cart/Notifikasi_BerhasilOrder'), 0)
		WebUI.closeBrowser()
	}
}