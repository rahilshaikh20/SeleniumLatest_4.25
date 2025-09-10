package javaCode;
import org.testng.annotations.Test;

public class TestCaseDataProvider {

    @Test(dataProvider = "loginData", dataProviderClass= DataProviderSetup.class)
    public void testLogin(String username, String password, int ID) {
        System.out.println("Username: " + username + ", Password: " + password + ", ID: "+ID);
        // You could put actual login logic/assertions here
    }
}
