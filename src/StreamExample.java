import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamExample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
// click on column
		driver.findElement(By.xpath("//table/thead/tr/th[1]")).click();
		
// capture all webelements into list
		List<WebElement> element = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
// capture text of all webelements into new(original) list
		List<String> data = element.stream().map(s->s.getText()).collect(Collectors.toList());
		
// sort on the original list of step 3 -> sorted list
		List<String> sorteddata = data.stream().sorted().collect(Collectors.toList());
		
// compare original list vs sorted list
		Assert.assertTrue(data.equals(sorteddata));
		
// scan the name column with getText ->Rice->print the price of the Rice
		List<String> price;

		do
		{
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		price = rows.stream().filter(s -> s.getText().contains("Rice"))
		.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));
			if(price.size()<1)
			{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(price.size()<1);

		}

		private static String getPriceVeggie(WebElement s) {
		
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}


