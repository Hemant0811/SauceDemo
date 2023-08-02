package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	static {

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resources/env.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException el) {
			// TODO Auto-generated catch block
			el.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setup() {

		String BrowserName = prop.getProperty("browser");

		if (BrowserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			// options.addArguments("-- remote-allow-origins=*");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		} else if (BrowserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			driver = new FirefoxDriver(options);
		} else if (BrowserName.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--incognito");
			driver = new EdgeDriver(options);
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@After
	public void teardown(Scenario s) throws IOException {
		if (s.isFailed()) {
			TakesScreenshot t = (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("Screenshort/" + s.getName() + ".png"));
		}
		driver.quit();
	}

	public void selectbyvisibleText(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByVisibleText(value);
	}

	public void selectbyIndex(WebElement ele, int value) {
		Select s = new Select(ele);
		s.selectByIndex(value);
	}

	public void selectbyValue(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}

	public void mouseHover(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
	}

	public WebElement waitForExpectedElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementTobeClickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}

	public void clickByExecuter(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

	}

	public void alertPopup() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	// public void takeScreenShot() throws IOException {
	// TakesScreenshot t = (TakesScreenshot) driver;
	// File src = t.getScreenshotAs(OutputType.FILE);
	// FileUtils.copyFile(src, new File("Screenshort/" + System.currentTimeMillis()
	// + "png"));

	// }
}
