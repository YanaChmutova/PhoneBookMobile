package config;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginData")
    public Object[][] loginData(){

        return new Object[][]{
                {"fakeUser1@mail.com", "fakePassword2"},
                {"fakeUser2@mail.com", "fakePassword1"}
        };
    }

}