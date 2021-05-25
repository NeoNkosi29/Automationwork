package genericfunctions;

import org.testng.annotations.*;

public class Excer1 {

	UtilityFunctions Utils = new UtilityFunctions();
	
	@Test
	public void Test() throws Exception
	{
	
		//open chrome
     Utils.SetupWebDriver("Chrome");
     
     //navigate to url
     Utils.NavigateToURL("http://demo.guru99.com/test/newtours/");
     
     //Waiting time
     Utils.WaitTime(2);
     
     String ExpectedTitle = "Welcome: Mercury Tours";
     String ActualTitle = Utils.getWebdriver().getTitle();
     
    boolean Compare;
    
    if(ExpectedTitle.equals(ActualTitle))
    {
    	Compare = true;
    }
    else
    {
    	Compare = false;
    }
     
     System.out.println(Compare);
     
     Utils.CloseBrowser();
     
	}
	//@Test
		public void Test_1() throws Exception
		{
			//Open Chrome browser
			Utils.SetupWebDriver("Chrome");
			
			//Wait
			Utils.WaitTime(2);
			
			//Navigate to URL
			Utils.NavigateToURL("https://demoqa.com/automation-practice-form");
			
			//Wait
			Utils.WaitTime(2);
			
			//Enter the First Name
			//utils.getWebdriver().findElement(By.id("firstName")).sendKeys("Rishen");
			Utils.EnterText("ID", "firstName", "Neo");
			
			//Enter the Last Name
			//utils.getWebdriver().findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Moodley");
			Utils.EnterText("xpath", "//input[@placeholder='Last Name']", "Nkosi");

			//Wait
			Utils.WaitTime(2);
			
			//Click Button
			//utils.getWebdriver().findElement(By.id("submit")).click();
			Utils.ClickObject("ID", "submit");
			
			//Close Chrome Browser		
			Utils.CloseBrowser();
			
		}
		
		 
		 
		//@Test
		public void Test_2() throws Exception
		{
			//Open Chrome browser
			Utils.SetupWebDriver("Chrome");
			
			//Wait
			Utils.WaitTime(2);
			
			//Navigate to URL
			Utils.NavigateToURL("https://demoqa.com/automation-practice-form");
			
			//Wait
			Utils.WaitTime(2);
		
			//Page down
			Utils.PageDown();
			
			//Wait
			Utils.WaitTime(2);
			
			//Click on Book Store Application
			//utils.getWebdriver().findElement(By.xpath("//*[text()='Book Store Application']")).click();
			Utils.ClickObject("XPATH", "//*[text()='Book Store Application']");

			//Wait
			Utils.WaitTime(2);	
			
			//Click on Book Store
			//utils.getWebdriver().findElement(By.xpath("//*[text()='Book Store']")).click();
			Utils.ClickObject("XPATH", "//*[text()='Book Store']");

			//Wait
			Utils.WaitTime(2);	
			
			//Click on the First book using Partial Link Text
			//utils.getWebdriver().findElement(By.partialLinkText("Git")).click();
			Utils.ClickObject("PARTIALLINKTEXT", "Git");

			//Wait
			Utils.WaitTime(2);	
			
			//Back to Book Store
			//utils.getWebdriver().findElement(By.id("addNewRecordButton")).click();
			Utils.ClickObject("ID", "addNewRecordButton");

			//Wait
			Utils.WaitTime(2);	
			
			//Click on another book using Link Text
			//utils.getWebdriver().findElement(By.linkText("Learning JavaScript Design Patterns")).click();
			Utils.ClickObject("LINKTEXT", "Learning JavaScript Design Patterns");

			//Wait
			Utils.WaitTime(2);	
			
			//Close Chrome Browser		
			Utils.CloseBrowser();
		}
		
		
}

