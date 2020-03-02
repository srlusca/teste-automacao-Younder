package utils;

import java.sql.Timestamp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;

public class Evidencias extends WebdriverManager {

    public static String dataHoraParaArquivo() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
    }

    public static void evidencies(WebDriver webDriver, String arquivo) {
        File screenshots = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshots, new File(arquivo));
        } catch (Exception e) {
            System.out.println("Houveram problemas ao copiar o arquivo para a pasta: " + e.getMessage());
        }
    }
}
