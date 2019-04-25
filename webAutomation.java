package bl.framework.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webAutomation {
	
	static  RemoteWebDriver driver;
	
	
	public void login() throws InterruptedException
	
	{
		
		System.setProperty("webdriver.chrome.driver" ,"./drivers/chromedriver.exe");
		
		 driver =  new ChromeDriver();
		
		 driver.get("https://demo.openmrs.org/openmrs/login.htm");
		
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		 
		 driver.findElementById("username").sendKeys("Admin");
		 
		 driver.findElementById("password").sendKeys("Admin123");
		 
		 Actions ac  = new Actions(driver);
		 
		 
		 List<WebElement> LiTag = driver.findElementsByTagName("li");
		 
		 for(WebElement LVAR:LiTag)
		 
		 {
			 
			 if(LVAR.getText().equals("Inpatient Ward"))
					 
					 {
				 LVAR.click();
				 
				 if (LVAR.isSelected())
					 
				 {
					 System.out.println("inpatient is selected");
				 }
					 }
			 
			
		 }
		 
		 
		WebElement loginButton = driver.findElement(By.id("loginButton"));
		 
		ac.click(loginButton).pause(2000) .build().perform();
		
		
		List<WebElement> linkEle = driver.findElementsByXPath("//a[contains(@href,'/openmrs//appointmentschedulingui/home.page')]/../a");
		
		
		for( WebElement linkVar:linkEle)
		
		{
			
			if(linkVar.getAttribute("href").contains("appointmentschedulingui"))
				
			{
				linkVar.click();
break;

					 }
				
			}
		
		
		driver.findElementByCssSelector("a[href='/openmrs/appointmentschedulingui/manageAppointmentTypes.page']").click();
		

		System.out.println(driver.findElementByXPath("//table[@id='appointmentTypesTable']/thead/tr/th/div").getText()); 
		
		Dimension size = driver.findElementByXPath("//table[@id='appointmentTypesTable']/tbody/tr").getSize();
		System.out.println("size is"+size);
		
		int rowcount = driver.findElementsByXPath("//table[@id='appointmentTypesTable']/tbody/tr").size();
		System.out.println("row no is"+rowcount);
		
		
		int tagsize = driver.findElementsByTagName("tr").size();
		
		System.out.println("tag name size us"+tagsize);
		
//		List<WebElement> Pagelinks = driver.findElementsByXPath("//div[contains(@class,'dataTables_paginate')]/span/a");
		
		WebElement NextButton = driver.findElementByXPath("//a[text()='Next']");
		
//		retry tr = new retry();
		
		int i =1;
		do
		{
			
		int colsize = driver.findElementsByTagName("//tbody/tr/td[1]").size();
		System.out.println("colsize"+colsize);
		List<WebElement> tabledata = driver.findElementsByXPath("//tbody/tr/td[1]");
		
		int j=1;
		
		for (WebElement tabVar:tabledata)
		{
			
			if ( tabVar.getText().contains("Urology"))
			{
				
			System.out.println("urology duration is "+driver.findElementByXPath("//tbody/tr["+j+"]/td[2]").getText());
			
	break  ;
	
			}
			
			j++;
			
			
			
		}
		
//		Thread.sleep(250);
//		
//WebDriverWait wait = new WebDriverWait(driver,20000);
////		
//wait.until(ExpectedConditions.elementToBeClickable(Pagelinks.get(i)));
		
		
		//tr.retryClickReuse(Pagelinks.get(i));
		
NextButton.click();
		
		
		
		i++;
		
		}		
	
		while(i<=3);	 
		 
		 
	}
	
	

}
