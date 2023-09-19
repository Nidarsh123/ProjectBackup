package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * This method used for Launching Application
 * @parameter key
 * @return
 * @throws Throwable
 * @author Dell
 *
 */
public class File_Utility {

	/*we can use key value(url,username,password) so we use String key*/
	public String getKeyAndValue(String key) throws Throwable {
		//launching the application and fetching qtiger data using AdvSelCommData.properties
				FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelCommData.properties");
				Properties pro = new Properties();
				pro.load(fis);
				String Value = pro.getProperty(key);
				return Value;
	}

}
