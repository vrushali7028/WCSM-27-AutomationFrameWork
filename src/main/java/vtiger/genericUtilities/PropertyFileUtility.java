package vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author Vrushali P
 */
public class PropertyFileUtility {
/**
 * This method will read data from property file
 * @param key
 * @return
 * @throws IOException
 */
	public String readDataFromPropertyFile(String key) throws IOException {
		// TODO Auto-generated method stub
        FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
        Properties pObj = new Properties();
        pObj.load(fis);
        String value = pObj.getProperty(key);
        return value;
	}

}
