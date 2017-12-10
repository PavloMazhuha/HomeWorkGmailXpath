package Utils;

import java.io.*;
import java.util.Properties;

public class FileUtil {
    public static Properties readProperties(File propertyFile) {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream(propertyFile)){
            prop.load(inputStream);
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
