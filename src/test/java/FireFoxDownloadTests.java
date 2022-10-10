import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.time.Duration;

public class FireFoxDownloadTests {

    private WebDriver webDriver;
    private DownloadPage downloadPage;
    private String URL = "http://the-internet.herokuapp.com/download";
    private String DOWNLOADED_FILE_PATH = "C:\\Trainig\\qa-automation\\selenium-training\\src\\test\\DownloadedFiles";

    @BeforeEach
    void setup() {
        WebDriverManager.getInstance(FirefoxDriver.class).setup();
    }

    @Test
    void firefoxDownloadTest() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", DOWNLOADED_FILE_PATH);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        webDriver = new FirefoxDriver(options);
        webDriver.get(URL);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        downloadPage = new DownloadPage(webDriver);
        downloadPage.downloadFile();
        File file = new File(DOWNLOADED_FILE_PATH);
        File[] downloadedFiles = file.listFiles();
        final String fileName = downloadedFiles[0].getName();
        Assertions.assertTrue(downloadPage.isFileDownloaded(DOWNLOADED_FILE_PATH, fileName));
    }

    @Test
    void firefoxAutoDownloadTest() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", DOWNLOADED_FILE_PATH);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf;text/plain;application/text;image/jpeg;application/zip;application/x-zip");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        webDriver = new FirefoxDriver(options);
        webDriver.get(URL);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        downloadPage = new DownloadPage(webDriver);
        downloadPage.downloadFile();
        File file = new File(DOWNLOADED_FILE_PATH);
        File[] downloadedFiles = file.listFiles();
        final String fileName = downloadedFiles[0].getName();
        Assertions.assertTrue(downloadPage.isFileDownloaded(DOWNLOADED_FILE_PATH, fileName));
    }

    @AfterEach
    void cleanup() {
        webDriver.close();
    }

}
