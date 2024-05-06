package tests;

import config.AppiumConfig;
import helpers.AddressGenerator;
import helpers.EmailGenerator;
import helpers.NameAndLastNameGenerator;
import helpers.PhoneNumberGenerator;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class EditContactTest extends AppiumConfig {

    @BeforeTest
    public void precondition(){
        new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField("mymegamail@mail.com")
                .fillPasswordField("MyPassword123!")
                .clickByLoginButton();
    }
    @Test
    public void editContactMailPositive(){
        String text = "updatedMail@mail.com";

        Assert.assertTrue(new ContactListScreen(driver).
                editOneContact().
                editEmailField(text).
                submitChanges().isContactContainsText(text));

    }
    @Test
    public void editAnyContactYouWant(){
        new SplashScreen(driver).switchToAuthScreen()
                .fillEmailField("mymegamail@mail.com")
                .fillPasswordField("MyPassword123!")
                .clickByLoginButton();
        Contact contact = new Contact(
                NameAndLastNameGenerator.generateName(),
                NameAndLastNameGenerator.generateLastName(),
                PhoneNumberGenerator.generatePhoneNumber(),
                EmailGenerator.generateEmail(3,3,3),
                AddressGenerator.generateAddress(), "Description"
        );
        Assert.assertTrue(new ContactListScreen(driver)
                .openNewContactForm()
                .fillTheForm(contact)
                .createContact().isContactAddedScroll(contact));



    }















}