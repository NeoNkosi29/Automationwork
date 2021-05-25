package genericfunctions;

//TestNG
import org.testng.annotations.*;

//Excel
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class AssessmentOne {
	public int iRow;
	public Sheet sheet;
	public String sRun;
	public String timeStamp;
	
	UtilityFunctions Utils = new UtilityFunctions();
	FunctionLibrary funcLib = new FunctionLibrary();
	DataFunctions data = new DataFunctions();
	Reporting repo = new Reporting();
	
	@BeforeMethod
	public void beforeMethod() throws Exception
	{
		//Setup WebDriver and Initialize Extent Reports
		Utils.Setup("chrome");
		
		//Wait
		Utils.WaitTime(2);
	}

	@Test()
	public void main() throws Exception {
		// TODO Auto-generated method stub
		
		//Get Sheet
		sheet = data.readExcel("\\TestData\\Assessment1.xlsx","Sheet1");
		
		//Get Number of Rows from Excel
		iRow = DataFunctions.rowCount(sheet);
		
	
		for(int x=1; x<iRow; x++)
		{
			//Check Run Status
			sRun = DataFunctions.getExcelCellData("Run", x, sheet);
			
			if(sRun.toUpperCase().equals("YES"))
			{
				System.out.println("**** Starting Iteration: "+ x+" ****");
				
				//Creates the name of the Extent Report
				repo.setExtentTest(repo.getExtent().createTest("First Report - "+x));
				
				//Navigate to URL
				funcLib.NavigateToURL(sheet, x);
				
				//Enter search item
			    Utils.EnterText("name","s", DataFunctions.getExcelCellData("SearchItem", x, sheet));
			    
			     //click on the search widget
			     Utils.ClickObject("xpath", "//*[@id=\"search_widget\"]/form/button");
			     
			   //select Sort by
			     Utils.SelectDropDownVisibleText("cssSelector", "btn-unstyle select-title", DataFunctions.getExcelCellData("SortBy", x, sheet)); 
			     
			   //Wait
			     Utils.WaitTime(2);
			     
			   //select first item
				 Utils.getWebdriver().findElement(By.xpath("//*[@id=\"js-product-list\"]/div/div/div/div[2]/article/div/div[2]/h3/a")).click();
				 
				
				//Scroll
				 Utils.PageDown();
				 
				 //Enter Quantity
				 Utils.ClickObject("id","quantity_wanted");
			     Utils.EnterText("id","quantity_wanted", DataFunctions.getExcelCellData("Quantity", x, sheet));
				//((WebElement) Utils).findElement(By.xpath("//*[@id='quantity_wanted']")).sendKeys(Keys.chord(Keys.CONTROL, "a"),DataFunctions.getExcelCellData("Quantity", x, sheet));
				
				
				//Wait
			     Utils.WaitTime(5);
			   
			     //Add to Cart
			   Utils.ClickObject("xpath","//div[2]/button");
		
			   //Wait
			    Utils.WaitTime(5);
			  //Wait
			    Utils.WaitTime(5);
			    
			    //Click on add to cart
			    Utils.ClickObject("xpath","//div[2]/button");
			    
			    
			    //Click on the availability pop up
			   Utils.ClickObject("id","product-availability");
			    
				//Wait
			    Utils.WaitTime(2);
			    
			    
			    //click on continue add to cart
			    Utils.ClickObject("xpath"," //*[@id=\"product_confirmation_modal\"]/div[2]/button[1]/span/b");
			    
			  //Wait
			    Utils.WaitTime(2);
			    
			    
			    //write item amount to excel
				WebElement sItemPrice = Utils.getWebdriver().findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p"));
			     DataFunctions.writeExcel("ItemPrice", x, sheet,"R"+ sItemPrice);
			     
			     //write cart amount to excel
			     WebElement sCartAmount = Utils.getWebdriver().findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]"));
			     DataFunctions.writeExcel("CartAmount", x, sheet,"R"+ sCartAmount);
			      
			    //Wait
			     Utils.WaitTime(2);
				    
				    //click on continue shopping 
				 Utils.ClickObject("xpath","//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/button");
				
			    
				System.out.println("**** Ending Iteration: "+ x+" ****");
				
				//Get Current Timestamp
		        timeStamp = DataFunctions.getTimeStamp();
		  
				DataFunctions.writeExcel("Status", x, sheet, "Passed_"+timeStamp);
			}
		}
	}
	
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		//Wait
		Utils.WaitTime(5);
		
		//Close Browser and WebDriver,
		Utils.CloseBrowser();
		
		//Close and Save Extent Report
		repo.getExtent().flush();
	}

}
