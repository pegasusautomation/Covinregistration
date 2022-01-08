package covinlogin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CovinLoginVerification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://PreProd//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://app.cowin.gov.in/login");		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		// Enter covin vaccinator user name and password
		driver.findElement(By.name("ion-input-0")).sendKeys("9535956373");
		driver.findElement(By.name("ion-input-1")).sendKeys("BSCE@123");
		
		// Click on submit button
		driver.findElement(By.xpath("//ion-button[@type = 'submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
		driver.findElement(By.className("inner-emblem")).isDisplayed();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
		
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ion-menu-button[contains(@class, 'md button')]")));
		new WebDriverWait(driver, Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//ion-menu-button[contains(@class, 'md button')]"))).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
		new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ion-label[text() = 'Report']")));
		new WebDriverWait(driver, Duration.ofMillis(2000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//ion-label[text() = 'Report']"))).click();
		
		
		List<WebElement> reportRowCount = driver.findElements((By.xpath("//table[contains(@class,'surveyor-report-table')]//tbody/tr")));
		for (int row = 1; row < reportRowCount.size(); row++)
		{
//			List<WebElement> reportColCount = driver.findElements((By.xpath("((//tr[contains(@role, 'row') and contains(@class, 'mat-row cdk-row')])["+"row"+"])/td")));
//			for (int col; col < reportColCount.size(); col++)
//			{
			System.out.println("//table[contains(@class,'surveyor-report-table')]//tbody/tr["+row+"]/td[5]");
				WebElement recepientValue = driver.findElement((By.xpath("//table[contains(@class,'surveyor-report-table')]//tbody/tr["+row+"]/td[5]")));
				System.out.println("The text for row no : " + row +  " : " + recepientValue.getText());
				int recepient = Integer.parseInt(recepientValue.getText());
				if(recepient == 29)
				{
					System.out.println("Success");
					driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50000));
					driver.findElement((By.xpath("//table[contains(@class,'surveyor-report-table')]//tbody/tr["+row+"]/td[5]"))).click();
					break;
				}
//			}
		}
		// Select on going session
//		driver.findElement(By.xpath("//tr[@class = 'mat-row cdk-row']//div/p[text() = ' On Going'])[1]")).click();
//		driver.findElement(By.xpath("//input[@formcontrolname = 'searchKey']")).sendKeys("7829894529");
//		driver.findElement(By.xpath("//span[text() = 'Filter By']")).click();
//		driver.findElement(By.xpath("//mat-option//span[text() = 'Mobile']")).click();
//		driver.findElement(By.xpath("//ion-button[contains(@class, 'searchBeneficiery')]")).isDisplayed();
//		driver.findElement(By.xpath("//ion-button[contains(@class, 'searchBeneficiery')]")).click();
		
		
		 driver.close();
		 driver.quit();
		}
}
