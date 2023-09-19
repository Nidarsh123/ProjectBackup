package Generic_Utilities;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Java_Utility {
	/**
	 * This method is used to avoid duplicates
	 * @return
	 * @author Dell
	 */

	public int getRandomNum() {
		
		Random r = new Random();
		int ranNum = r.nextInt(1000);
		return ranNum;
	}
}
