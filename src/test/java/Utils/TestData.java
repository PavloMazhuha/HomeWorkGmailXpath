package Utils;

import java.io.File;
import java.util.Properties;

public class TestData {
    private static File testDataFile = new File("src/test/resources/account.properties");
    private static Properties testData = FileUtil.readProperties(testDataFile);

    public static final String LOGIN =    testData.getProperty("login");
    public static final String PASSWORD = testData.getProperty("password");
}
