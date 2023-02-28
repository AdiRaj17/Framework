package com.amazon.Common;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public static final String TEST_PACKAGE_PREFIX = "com.amazon.";
	protected String application = "";
	protected boolean initialized = false;
	protected String className = null;
	protected String methodName = null;
	protected String testName = null;
	//protected SeleniumWrapper selenium = null;
	protected WebDriver driver = null;
	protected WebDriver iedriver = null;
	protected WebDriver chromedriver = null;
	protected Map<String, String> uiSessionData = new HashMap<String, String>();
	protected JSONObject jsonConfig = null;
	protected String jsonFilePath = null;
	protected boolean useEngine = false;
	protected String packageStr = null;
	protected ExtentReports report;
	protected static ExtentTest logger;
		
	
	protected BaseClass() {
	}
	
	@BeforeSuite
	public void reports()
	{
		// Create Object of ExtentHtmlReporter and provide the path where you want to generate the report 
        // I used (.) in path where represent the current working directory
         ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/AmazonDashboard"+ Helper.getCurrentDateTime()+".html");
        		
        // Create object of ExtentReports class- This is main class which will create report
        report = new ExtentReports();
    
        //Attach the reporter which we created in Step 1
        report.attachReporter(reporter);
	}
	
	/**
	 * Using a bit of reflection this method will initialize the derived class. 
	 * It's recommended that this is invoked within the test case because the 
	 * test names and the function method will match.
	 * 
	 * @param testClassObject
	 *            From the calling TestNG class, pass in
	 *            <code>initialize(new Object(){}.getClass())</code>
	 * @return
	 * @throws Exception
	 */
	protected <T1 extends Object> void initialize(Class<T1> testClassObject) throws Exception {

		if (initialized) {
			return;
		}
		initialized = true;
		if (className == null) {

			// Can also use getSimpleName
			className = testClassObject.getName();
			if (className.contains("$")) {
				// for anonymous classes are solved with name-mangling schemes - in this case it's $.
				className = className.substring(0, className.lastIndexOf("$"));
			}
		}
		if (testName == null) {
			if (testClassObject.getEnclosingMethod() == null) {
				throw new Exception("Failed to find a valid Enclosed Method " + "for class object - use new Object(){}.getClass()");
			}
			methodName = testClassObject.getEnclosingMethod().getName();
			testName = methodName + "_T" + String.valueOf(Thread.currentThread().getId());
		}
		//Changes to accomodate JSON link-up
		if (packageStr == null) {	
			packageStr = testClassObject.getPackage().getName();
			if (packageStr.startsWith(TEST_PACKAGE_PREFIX)) {
				packageStr = packageStr.substring(TEST_PACKAGE_PREFIX.length());
				packageStr = packageStr.replace('.', '_');
			}
		}

		//TODO: Remove Experiments
//		initializeExperimentalBrowser();
		/*initializeSelenium();
		initializeLogger();
		initializeSessionData();*/
		initilizeJson();


	}
	
/**
 * @author adiraj
 * @throws Exception
 */
protected void initilizeJson() throws Exception {		
	jsonFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\json\\" + packageStr.toLowerCase() + ".json";

	String[] split = className.split("\\.");
	String name = split[split.length - 1];
	String jsonObject = name;
    System.out.println("Test Data file: " + packageStr + ".json");
	//logger.info("Test Data file: " + packageStr + ".json");
	try {
		Gson gson = new Gson();
		JsonObject obj = gson.fromJson(new FileReader(jsonFilePath), JsonObject.class);
		jsonConfig = new JSONObject(obj.getAsJsonObject(jsonObject).toString());
		/*jsonConfig = new JSONObject(JSONParser.readJSONfile(jsonFilePath));
		jsonConfig = jsonConfig.getJSONObject(jsonObject);*/
	}
	catch (Exception e)
	{
		//logger.info("Test Data file not found \n"+"Exception Initializing Json file"+e.getMessage());
		System.out.println("Test Data file not found \n"+"Exception Initializing Json file"+e.getMessage());
	}
}

@AfterMethod
public void tearDownMethod(ITestResult results) throws IOException
{
	if(results.getStatus()==ITestResult.FAILURE)
	{
	logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
	//Helper.captureScreenshots(driver);
	}else if(results.getStatus()==ITestResult.SUCCESS) {
	logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());                           
	}
	report.flush();
}

@AfterClass
public void quitBrowser() {
BrowserAppLaunch.quitBrowser(driver);
}
}
