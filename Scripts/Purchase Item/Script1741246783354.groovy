import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://www.saucedemo.com/')
WebUI.maximizeWindow()
WebUI.setText(findTestObject('Object Repository/Login/input_username'), 'standard_user')
WebUI.setText(findTestObject('Object Repository/Login/input_password'), 'secret_sauce')
WebUI.click(findTestObject('Object Repository/Login/Btn_Login'))

WebUI.click(findTestObject('Object Repository/Add to Cart/Barang_Backpack'))
WebUI.click(findTestObject('Object Repository/Add to Cart/Barang_Bike_Light'))

WebUI.click(findTestObject('Object Repository/Add to Cart/Keranjang'))
WebUI.click(findTestObject('Object Repository/Add to Cart/Btn_Checkout'))

println("firstName: " + firstName)
println("lastName: " + lastName)
println("postalCode: " + postalCode)

WebUI.setText(findTestObject('Object Repository/Add to Cart/Input_Checkout_Firstname'), firstName)
WebUI.setText(findTestObject('Object Repository/Add to Cart/Input_Checkout_Lastname'), lastName)
WebUI.setText(findTestObject('Object Repository/Add to Cart/Input_Checkout_Postalcode'), postalCode)

WebUI.click(findTestObject('Object Repository/Add to Cart/Btn_Continue'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Add to Cart/PaymentInformation'), 0)

WebUI.click(findTestObject('Object Repository/Add to Cart/Btn_Finish'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Add to Cart/Notifikasi_BerhasilOrder'), 0)
WebUI.closeBrowser()