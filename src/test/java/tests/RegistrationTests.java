package tests;

import config.AppiumConfig;
import helpers.EmailGenerator;
import helpers.PasswordStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RegistrationTests extends AppiumConfig {

    @Test
    public void registrationNewUserTest(){
        ContactListScreen contactListScreen = new SplashScreen(driver)
                .switchToAuthScreen()
                .fillEmailField(EmailGenerator.generateEmail(5,5,3))
                .fillPasswordField(PasswordStringGenerator.generateString())
                .clickByRegistrationButton();
        Assert.assertTrue(contactListScreen.isContactListPresent());
    }
    @Test
    public void registrationWrongEmailNegative(){
        AuthenticationScreen authenticationScreen = new SplashScreen(driver).switchToAuthScreen()
                .fillEmailField("mymegamail@mail.com")
                .fillPasswordField("777")
                .clickByRegistrationButton();
        Assert.assertTrue(authenticationScreen.isItAuthenticationScreen());
    }

}