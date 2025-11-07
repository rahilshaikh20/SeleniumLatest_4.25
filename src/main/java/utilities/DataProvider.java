package utilities;

import org.testng.annotations.Test;

import java.io.IOException;

public class DataProvider {


    @org.testng.annotations.DataProvider(name = "userData")
    public Object[][] getUserData() throws IOException {
        return ExcelUtils.readExcel("TestData.xlsx", "Users");
    }

    @Test(dataProvider = "userData")
    public void createUserTest(String name, double age, String email, String city, double phone) {
        // use the data here
        System.out.println("Creating user: " +name+" "+ age+" "+ email+" "+ city+" " +phone);
    }

}
