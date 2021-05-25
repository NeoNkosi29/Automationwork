package genericfunctions;

import org.testng.annotations.*;
public class execrise4 {

	UtilityFunctions Utils = new UtilityFunctions();
	@Test
	public void Test() throws Exception
	{
		
		//open chrome
	     Utils.SetupWebDriver("Chrome");
	     
	     //navigate to url
	     Utils.NavigateToURL("http://demo.guru99.com/test/newtours/register.php");
	     
	   //Wait
	     Utils.WaitTime(2);
			
			//Enter First Name
			Utils.EnterText("xpath", "//*[contains(text(),'First')]/following::input[1]", "Neo");
			
			//Enter Last Name
			Utils.EnterText("xpath", "//*[contains(text(),'Last')]/following::input[1]", "Nkosi");
			
			//Enter Phone Number
			Utils.EnterText("xpath", "//*[contains(text(),'Phone')]/following::input[1]", "0723425678");
			
			//Enter Email Address
			Utils.EnterText("xpath", "//*[contains(text(),'Email')]/following::input[1]", "test@test.com");
			
			//Scroll
			Utils.PageDown();
			
			//Enter Address
			Utils.EnterText("xpath", "//*[contains(text(),'Address')]/following::input[1]", "943 fourways");
			
			//Enter City
			Utils.EnterText("xpath", "//*[contains(text(),'City')]/following::input[1]", "Johannesburg");
			
			//Enter State/Province
			Utils.EnterText("xpath", "//*[contains(text(),'State/Province')]/following::input[1]", "Gauteng");
			
			//Enter Postal Code
			Utils.EnterText("xpath", "//*[contains(text(),'Postal')]/following::input[1]", "2121");
			
			//Scroll
			Utils.PageDown();
			
			//Enter Postal Code
			Utils.SelectDropDownVisibleText("xpath", "//*[contains(text(),'Country')]/following::select[1]", "SOUTH AFRICA");
			
			//Enter User Name
			Utils.EnterText("xpath", "//*[contains(text(),'User')]/following::input[1]", "Dineo");
			
			//Enter Password
			Utils.EnterText("xpath", "//*[contains(text(),'Password')]/following::input[1]", "1@2345");
			
			//Enter Confirm Password
			Utils.EnterText("xpath", "//*[contains(text(),'Confirm')]/following::input[1]", "1@234");
			
			//Click Submit Button
			Utils.ClickObject("xpath", "//*[@type='submit']");
			
			//Wait
			Utils.WaitTime(2);
			
			//Get User Name Message
			System.out.println(Utils.GetText("xpath", "//*[contains(text(),'Note: Your user name is')]"));
			
			//Click Submit Button
			Utils.ClickObject("xpath", "//*[contains(text(),'SIGN-OFF')]");
			
			//Checking if 'SIGN-ON' is available
			Utils.waitForElement("xpath", "//*[contains(text(),'SIGN-ON')]");
			
	     
	   //Waiting time
	     Utils.WaitTime(2);
	     
        //System.out.println("Hi Neo");
	     
	     Utils.CloseBrowser();
	}
}
