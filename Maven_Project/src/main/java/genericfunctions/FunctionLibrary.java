package genericfunctions;
import org.apache.poi.ss.usermodel.*;

public class FunctionLibrary {
	
	boolean bStepCheck;
	String sStatus;
	
	public static String sURL;
	public static String sUsername;
	public static String sPassword;
	public static int iIteration;
	public static Sheet sheetGlobal;
	
	UtilityFunctions Utils = new UtilityFunctions();
	Reporting repo = new Reporting();
	
	public void NavigateToURL(Sheet sheet, int i) throws Exception
	{
		//Set iIteration to i
		iIteration = i;
		
		//Set sheetGlobal to sheet
		sheetGlobal = sheet;
		
		sURL = DataFunctions.getExcelCellData("URL", i, sheet);
		
		//Navigate to the URL
		Utils.NavigateToURL(sURL);
		
		//Validate Navigation to URL
		repo.ReportStep("name", "userName", "Navigate to URL");
	}
	
	public void Login(Sheet sheet, int i) throws Exception
	{
		sUsername = DataFunctions.getExcelCellData("Username", i, sheet);
		sPassword = DataFunctions.getExcelCellData("Password", i, sheet);
		
		// Capture User name
		Utils.EnterText("name", "userName", sUsername);
		
		// Capture the Password
		Utils.EnterText("name", "password", sPassword);
		
		// Click the Submit Button
		Utils.ClickObject("name","submit");
		
		//Validate Login
		repo.ReportStep("linktext", "SIGN-OFF", "Login in to DemoTours");
	}
	
	public void ClickFlightLink() throws Exception
	{
		Utils.ClickObject("linktext","Flights");
		
		//Validate Login
		repo.ReportStep("xpath", "//input[@value='roundtrip']", "Click Flight Link");
	}
	
	public void SelectFlight(Sheet sheet, int i) throws Exception
	{
		//Select Flight Type
		Utils.ClickObject("xpath","//input[@value='roundtrip']");
		
		//Select from the 'Passengers' DropDown
		Utils.SelectDropDownVisibleText("name", "passCount", DataFunctions.getExcelCellData("Passengers", i, sheet));
		
		//Select from the 'DepartingFrom' DropDown
		Utils.SelectDropDownVisibleText("name", "fromPort", DataFunctions.getExcelCellData("DepartingFrom", i, sheet));
		
		//Select from the 'DepartingMonth' DropDown
		Utils.SelectDropDownVisibleText("name", "fromMonth", DataFunctions.getExcelCellData("DepartingMonth", i, sheet));
		
		//Select from the 'DepartingDay' DropDown
		Utils.SelectDropDownVisibleText("name", "fromDay", DataFunctions.getExcelCellData("DepartingDay", i, sheet));
		
		//Page Down
		Utils.PageDown();
		
		//Select from the 'ArrivingTo' DropDown
		Utils.SelectDropDownVisibleText("name", "toPort", DataFunctions.getExcelCellData("ArrivingTo", i, sheet));
		
		//Select from the 'ArrivalMonth' DropDown
		Utils.SelectDropDownVisibleText("name", "toMonth", DataFunctions.getExcelCellData("ArrivalMonth", i, sheet));
		
		//Select from the 'ArrivalDay' DropDown
		Utils.SelectDropDownVisibleText("name", "toDay", DataFunctions.getExcelCellData("ArrivalDay", i, sheet));
		
		//Select Service Class
		Utils.ClickObject("xpath", "//input[@value='"+ DataFunctions.getExcelCellData("ServiceClass", i, sheet) +"']");
		
		//Select from the 'Airline' DropDown
		Utils.SelectDropDownVisibleText("name", "airline", DataFunctions.getExcelCellData("Airline", i, sheet));
		
		//Click Continue Button
		Utils.ClickObject("name", "findFlights");
		
		
		//Validate Login
		repo.ReportStep("xpath", "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/a/im", "Select Flight Type");
	}
}
