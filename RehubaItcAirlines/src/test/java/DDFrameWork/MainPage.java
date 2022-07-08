package DDFrameWork;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() {
		String path1="D:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		driver=new ChromeDriver();
	}
	@Test
	public void mainpage() throws Exception {

		driver.get("file:///C:/Mini%20project-Rehuba%20Itc%20Airlines/mainpage.html");
		driver.findElement(By.linkText("ABOUT US")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("click1")).click();

		driver.findElement(By.linkText("BOOKING")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("click2")).click();

		driver.findElement(By.linkText("CONTACT")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("click")).click();

		driver.findElement(By.linkText("LOGOUT")).click();
		Thread.sleep(3000);
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
