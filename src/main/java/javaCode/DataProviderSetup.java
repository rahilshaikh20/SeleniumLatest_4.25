package javaCode;
import org.testng.annotations.DataProvider;

public class DataProviderSetup {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"user1", "pass1", 23},
                {"user2", "pass2", 56},
                {"admin", "admin123",98}
        };
    }
}
