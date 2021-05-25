package genericfunctions;

import org.testng.annotations.*;

public class Excercise3 {
	
UtilityFunctions Utils = new UtilityFunctions();
	
	@Test
	public void Test() throws Exception
	{
		
		//open chrome
	     Utils.SetupWebDriver("Chrome");
	     
	     //navigate to url
	     Utils.NavigateToURL("http://demo.automationtesting.in/Register.html");
	     
	     //Waiting time
	     Utils.WaitTime(2);
	     
	     //enter name
	     Utils.EnterText("xpath","//input[@placeholder='First Name']","Neo");
	     
	     //enter last name
	     Utils.EnterText("xpath","//input[@placeholder='Last Name']","Nkosi");
	     
	     //enter address
	     Utils.EnterText("xpath","//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea","324 Fourways");
	     
	     //enter email address
	     Utils.EnterText("xpath","//input[@type='email']","Nkosi@gmail.com");
	     
	     //enter phone number
	     Utils.EnterText("xpath","//input[@type='tel']","0728847760");
	     
	    //Select Gender
		//utils.ClickObject("xpath", "//input[@type='radio' and @value='Male']");
	     Utils.MultiSelect("Radio", "FeMale");
			
		//Select Hobbies
		//utils.ClickObject("xpath", "//input[@type='checkbox' and @value='Movies']");
	     Utils.MultiSelect("checkbox", "Movies");
			
		//Select Language/s
	     Utils.ClickObject("xpath", "//*[@id=\"msdd\"]");
	     Utils.WaitTime(1);
	     Utils.ClickObject("xpath", "//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a");
			
		//Select Skills
	     Utils.SelectDropDownVisibleText("id", "Skills", "Java");
			
		//Select Country
	     Utils.SelectDropDownVisibleText("id", "countries", "South Africa");
			
		//Select D.O.B Year
	     Utils.SelectDropDownVisibleText("id", "yearbox", "1999");
			
		//Select D.O.B Month
	     Utils.SelectDropDownVisibleText("xpath", "//*[@placeholder='Month']", "April");
	     
	   //Select D.O.B Day
	     Utils.SelectDropDownVisibleText("id", "daybox", "1");
			
		//Enter Password
	     Utils.EnterText("id", "firstpassword", "Neo123");
			
		//Confirm Password
	     Utils.EnterText("id", "secondpassword", "Neo123");
			
		//Upload Document - *Not required Bonus*
	    // Utils.FileUpload("‪C:\\Users\\rmoodley\\workspace\\maven-project\\screenshots\\ExtentLogFail20210304_174722.png");
			
	     
	   //Waiting time
	     Utils.WaitTime(2);
	     
	     System.out.println("Hi Neo");
	     
	     Utils.CloseBrowser();
	}

}
