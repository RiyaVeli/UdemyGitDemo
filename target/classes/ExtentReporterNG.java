package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	public static ExtentReports getReportObject() {
		//with the help of ExtentReports, ExtentSparkReporter classes 
				String path=System.getProperty("user.dir")+"\\reports\\extentReport.html";
				ExtentSparkReporter report = new ExtentSparkReporter(path);
				report.config().setReportName("Web Automation Results");
				report.config().setDocumentTitle("Test Results");
				
				extent = new ExtentReports();
				extent.attachReporter(report);
				extent.setSystemInfo("Tester", "Riya Veli");
				return extent;
	}
}
