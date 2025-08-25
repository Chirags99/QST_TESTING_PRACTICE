package utilities;
 
import java.io.File;

import java.io.IOException;

import java.util.List;
 
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
 
import base.BaseTest;
 
public class ExtentReport implements ITestListener

{

	public ExtentSparkReporter sparkReporter;  // UI of the report

	public ExtentReports extent;  //populate common info on the report

	public ExtentTest test; // creating test case entries in the report and update status of the test methods
 
	public void onStart(ITestContext context) {

		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/Result/ExtentReport.html");//specify location of the report

		sparkReporter.config().setDocumentTitle("TestNG Report"); // TiTle of report

		sparkReporter.config().setReportName("FNP-Automtion By-Aniket"); // name of the report

		sparkReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();

		extent.attachReporter(sparkReporter);

		List<String> includedGroups =context.getCurrentXmlTest().getIncludedGroups();

		if(!includedGroups.isEmpty()) {

		extent.setSystemInfo("Groups", includedGroups.toString());

		}

	}
 
 
	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName()); // create a new enty in the report

		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s

		test.assignCategory(result.getMethod().getGroups()); // to display groups in report

		File scrFile = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);

		//The below method will save the screenshot 

		File screenShotName = new File(System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png");

		try {

			FileUtils.copyFile(scrFile, screenShotName);

		} catch (IOException e) {

			e.printStackTrace();

		}

		test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png");

	}
 
	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());

		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());

		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 

	}
 
	public void onTestSkipped(ITestResult result) {
 
		test = extent.createTest(result.getName());

		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());

	}
 
	

	public void onFinish(ITestContext context) {

		extent.flush();

	}


}

 