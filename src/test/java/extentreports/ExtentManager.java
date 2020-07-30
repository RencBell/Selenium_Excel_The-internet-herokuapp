package extentreports;

import com.relevantcodes.extentreports.ExtentReports;

//OB: extentreports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

    public static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            String workingDir = System.getProperty("user.dir");
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html", true);
            }
            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                extent = new ExtentReports(workingDir + "/ExtentReports/ExtentReportResults.html", true);
            }
        }
        return extent;
    }
}