import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class ChromeDownloadTest {

    private WebDriver webDriver;
    private DownloadPage downloadPage;
    private String URL = "http://the-internet.herokuapp.com/download";
    private String DOWNLOADED_FILE_PATH = "src/test/DownloadedFiles/";

    @BeforeEach
    void setup() {
        Browser browser = Browser.getInstance();
        webDriver = browser.getWebDriver();
        webDriver.get(URL);
        downloadPage = new DownloadPage(webDriver);
    }

    @Test
    void downloadFileTest() {
        downloadPage.downloadFile();
        File file = new File(DOWNLOADED_FILE_PATH);
        File[] downloadedFiles = file.listFiles();
        final String fileName = downloadedFiles[0].getName();
        Assertions.assertTrue(downloadPage.isFileDownloaded(DOWNLOADED_FILE_PATH,fileName));
    }

    @AfterEach
    void cleanup() {
        webDriver.close();
    }
}
