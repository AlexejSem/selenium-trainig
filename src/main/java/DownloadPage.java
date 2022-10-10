import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class DownloadPage {

    private WebDriver webDriver;
    private By someFile = By.cssSelector("div#content>div>a[href]");

    public DownloadPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void downloadFile() {
        webDriver.findElement(someFile).click();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();
        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                dirContent.deleteOnExit();
                return true;
            }
        }
        return false;
    }
}
