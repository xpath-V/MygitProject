package data;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {

	public static Properties fileReaderProperties() {
		Properties prop = new Properties ();
		File profile = new File(System.getProperty("user.dir")+ "\\src\\main\\java\\data\\data.properties");
		
		try {
			FileInputStream fis =new FileInputStream(profile);
			prop.load(fis);
		} catch (Throwable e) {
			// 	TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return prop;
		
	}
}
