package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    protected FileInputStream fis;
    protected Properties prop = new Properties();

    public Properties loadConfigProperties() throws IOException {
        fis = new FileInputStream(Constants.PROPERTIES_FILE_PATH);
        prop.load(fis);
        return prop;
    }
}
