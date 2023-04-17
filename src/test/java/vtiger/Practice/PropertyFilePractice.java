package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import vtiger.genericUtilities.IconstantsUtility;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        //Step 1 = Load the file in java readable format using file input stream
		 FileInputStream fis = new FileInputStream(IconstantsUtility.propertyfilePath);
		
		//Step 2 = create an object of properties from java.util
		Properties pObj = new Properties();
		
		//Step 3 = Load file input stream into properties
		pObj.load(fis);
		
		//Step 4 = using the keys read the value
		String BROWSER = pObj.getProperty("browser");
		System.out.println(BROWSER);
	}

}
