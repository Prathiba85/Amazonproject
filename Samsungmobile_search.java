package Amazon_test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Samsungmobile_search {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		WebElement Search_textbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Search_textbox.sendKeys("samsung mobile");
		WebElement Search_click = driver.findElement(By.xpath("//input[@type='submit']"));
		Search_click.click();

		List<WebElement> mobilephones = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));

		System.out.println("Number of products are " + mobilephones.size());

		List<WebElement> all_price = driver
				.findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-whole']"));
		List<WebElement> all_symbol = driver
				.findElements(By.xpath("//div[@class='a-section']//span[@class='a-price-symbol']"));

		for (int i = 0; i < mobilephones.size(); i++) {

			System.out.println(
					(mobilephones.get(i)).getText() + " " + all_symbol.get(i).getText() + (all_price.get(i).getText()));

		}
		TakesScreenshot tsobj = (TakesScreenshot) driver;
		File fileobj =tsobj.getScreenshotAs(OutputType.FILE);
		//size of png is less, so it is advisable to use png 
		File screenshot = new File ("amazon_samsung.png");
		FileUtils.copyFile(fileobj, screenshot);


	}

}
