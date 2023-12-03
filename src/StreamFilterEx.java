import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamFilterEx {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
//		Check the filter functionality in web page
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veg=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> veglist = veg.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		
//		Now compare veg and veglist to check the filter functionality if both are equal
		Assert.assertEquals(veg.size(), veglist.size());
	}

}
