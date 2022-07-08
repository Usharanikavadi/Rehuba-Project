package DDFrameWork;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() throws Exception {
		String path1="D:\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path1);
		driver=new ChromeDriver();
		driver.get("file:///C:/Mini%20project-Rehuba%20Itc%20Airlines/loginpage.html");
	} 
	@Test(dataProvider="getData")
	public void test(String username,String password) {
		driver.findElement(By.className("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();

	}
	@DataProvider
	public String[][] getData() throws Exception {
		File src=new File("C:\\Users\\itctesting10\\Documents\\Excel Data\\TableData.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int Rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getLastCellNum();

		String[][] data=new String[Rows-1][cols];
		for(int i=0;i<Rows-1;i++)
		{
			for(int j=0;j<cols;j++)
			{
				DataFormatter df=new DataFormatter();
				data[i][j]=	df.formatCellValue(sheet.getRow(i+1).getCell(j));

			}
			System.out.println();
		}
		wb.close();
		fis.close();
		return data;
		}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
