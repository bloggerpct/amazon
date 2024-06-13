package performance;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonPerformance 
{


	WebDriver driver=new ChromeDriver();
	
	
	@Test(enabled=false)
	public void verifyTitle()
	{
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");		
	}
	
	@Test(enabled=false)
	public void verifyDropdown()
	{
		driver.get("https://www.amazon.in/");
		WebElement dropdown= driver.findElement(By.id("searchDropdownBox"));
		Select select=new Select(dropdown);
	List<WebElement> allOptions=	select.getOptions();
	
	for(WebElement option:allOptions)
	{
	
		System.out.println(option.getText());
	}
		
	}
	
	
	@Test(enabled=false)
	public void verifydropdownSelection()
	{
		
		driver.get("https://www.amazon.in/");
		WebElement dropdown= driver.findElement(By.id("searchDropdownBox"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("Books");
		
	}
	
	@Test(enabled=false)
	public void languagehover()
	{
		
		driver.get("https://www.amazon.in/");
		WebElement lang= driver.findElement(By.id("icp-nav-flyout"));
		Actions ac= new Actions(driver);
		ac.moveToElement(lang).build().perform();
		
	}
	
	@Test(enabled=false)
	public void profilehover()
	{
		
		driver.get("https://www.amazon.in/");
		WebElement lang= driver.findElement(By.id("nav-link-accountList"));
		Actions ac= new Actions(driver);
		ac.moveToElement(lang).build().perform();
		
	}
	
	@Test(enabled=false)
	public void countLinks()
	{
		
		driver.get("https://www.amazon.in/");
		List <WebElement> taglist=	driver.findElements(By.tagName("a"));
		System.out.println(taglist.size());
		
	}
	@Test(enabled=false)
	public void PrintLinks()
	{
		driver.get("https://www.amazon.in/");
		List <WebElement> taglist=	driver.findElements(By.tagName("a"));
		for(int i=0;i<taglist.size();i++)		
		{	System.out.println(taglist.get(i).getText());
		}
		
	}
	
	@Test(enabled=false)
	public void ClickLinks()
	{
		driver.get("https://www.amazon.in/");
		List <WebElement> taglist=	driver.findElements(By.tagName("a"));
		
		for(int i=0;i<taglist.size();i++)	
		{	if(taglist.get(i).getText().contains("Audio Books"))
			{	System.out.println(taglist.get(i).getText());
				taglist.get(i).click();
				break;
			}
		}
		
	}
	
	@Test(enabled=false)
	public void search()
	{

		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	}
	
	@Test(enabled=true)
	public void Dynamicsearch() throws InterruptedException
	{

		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mob");
		Thread.sleep(4000);
		List <WebElement> result=driver.findElements(By.className("s-heavy"));
		
		
		for(int i=0;i<result.size();i++)
		{
			System.out.println(result.get(i).getText());
			
			if(result.get(i).getText().contains("ile under 7000"))
			{
				result.get(i).click();
				break;
				
			}
			

		}
		
	}
}
