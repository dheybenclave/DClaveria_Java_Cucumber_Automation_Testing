package hooks;

import java.util.Properties;

import static com.utils.BaseClass.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.api.RestAssuredDELETE;
import com.api.RestAssuredExtension;
import com.api.RestAssuredGET;
import com.api.RestAssuredPATCH;
import com.api.RestAssuredPOST;
import com.pages.drivers.DriversFactory;
import com.utils.*;
import io.cucumber.java.*;

public class apphooks {
	// Add Tag to execute specifically Eg: "@Before("@Smoke")"
	// It will run this in tags @Smoke only

	private DriversFactory driverFactory;
	public WebDriver webDriver;
	private ConfigReader configReader;
	Properties properties;

	public static Logger logger = Logger.getLogger(BaseClass.class);

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		properties = configReader.init();
	}

	@Before(order = 1)
	public void openBrowser() {
		logger.debug("Set up Browser");

		String browser = properties.getProperty("browser");

		driverFactory = new DriversFactory();
		webDriver = driverFactory.init_driver(browser, properties);

	}

	@Before(order = 2)
	public void setUpRESTAPI() {
		restAssured = new RestAssuredExtension();
		restAssuredGET = new RestAssuredGET();
		restAssuredPOST = new RestAssuredPOST();
		restAssuredDELETE = new RestAssuredDELETE();
		restAssuredPATCH = new RestAssuredPATCH();
	}

	@After(order = 0) // first call if @After
	public void closeBrowser() {
		logger.debug("Close Browser");
		webDriver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario sc) {
		if (sc.isFailed()) {

			String screenShotsName = sc.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);

			sc.attach(sourcePath, "image/png", screenShotsName);
		}
	}
}
