package core.selenium;

import i2celectronica.common.ReadAppProperties;
import org.openqa.selenium.WebDriver;

/**
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public final class WebDriverManager {
    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;

    /**
     * this method is used for initializes the variables.
     */
    private WebDriverManager() {
        initializes();

    }

    /**
     * This method is used for instantiate the WebDriverManager class.
     *
     * @return a webDriverManager.
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    /**
     * This method is used for initializes the variables.
     */
    private void initializes() {
        this.webDriver = WebDriverFactory.getWebDriver(WebDriverConfig.getInstance().getBrowser());
        this.webDriver.get(ReadAppProperties.getInstance().getUrlLogin());
        this.webDriver.manage().window().maximize();
    }

    /**
     * This method is used for get a WebDriver.
     *
     * @return a WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
