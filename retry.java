package bl.framework.testcases;

import org.openqa.selenium.WebElement;

public class retry {

	public boolean retryClickReuse( WebElement  webele )
	
	{
		
		boolean result = false;
		
		
		int attempts =0;
		
		
		while(attempts<=3)
		{
			
			webele.click();
			attempts++;
			
			result = true ;
			break;
			
		}
		
		
		
		
		return false;

		
		
		
	}
	
}
