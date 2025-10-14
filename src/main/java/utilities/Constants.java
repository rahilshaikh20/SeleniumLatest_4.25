package utilities;

/**
 * Contains all the constants related to project configuration
 **/
public class Constants {
    // URLs
    public static final String BASE_URL = "https://www.manutd.com/";
    public static final String LOGIN_URL = BASE_URL + "/login";
    // Credentials (for demo only)
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin123";
    // Timeouts
    public static final int DEFAULT_WAIT = 20;
    public static final int EXPLICIT_WAIT = 30;
    //Date Pattern for Screenshots
    public static final String DATE_PATTERN = "yyyy-MM-dd_HHmmss";
    // File paths
    public static final String SCREENSHOT_FOLDER = System.getProperty("user.dir") + "//Screenshots";
    public static final String CONFIG_PROPERTIES_FILE_PATH = System.getProperty("user.dir") +
            "/src/test/resources/config/Config.properties";
    public static final String TEST_DATA_PROPERTIES_FILE_PATH = System.getProperty("user.dir") +
            "/src/test/resources/testData/TestData.properties";
    public static final String EXTENT_REPORTS_PATH = System.getProperty("user.dir") + "/SparkReports/Rahil_New_Spark_Report.html";
    /**** For windows use \\ , for Mac use '//' or single forward slash '/' ***********/
    //Extent Repots parameters
    public static final String EXTENT_REPORTS_NAME = "Gradle SPARK Report";
    public static final String EXTENT_REPORTS_TITLE = "Demo Gradle Report";
    //Password Encryption
    public static final String ALGORITHM = "AES";
    public static final String SECRET_KEY = "12345678ABCJ3458";
    // Browser run mode
    public static final String CHROME_RUN_HEADLESS_MODE = "No";
    public static final String FIREFOX = "firefox";
    // Other constants
    public static final String TEST_ENV = "qa";
}
