package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "C:\\Users\\omkar\\eclipse-workspace\\FlowerAura\\test-output\\Screenshot\\"
                + testName + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);

        try {
           // dest.getParentFile().mkdirs(); // create folder if it doesn't exist
            Files.copy(src.toPath(), dest.toPath());
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
