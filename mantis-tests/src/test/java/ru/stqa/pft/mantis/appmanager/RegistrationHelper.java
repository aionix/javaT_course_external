package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by Sergey on 11.04.2017.
 */
public class RegistrationHelper {
    private final ApplicationManager app;
    private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        this.app = app;
        wd = app.getDriver();

    }

    public void start(String name, String email) {
        wd.get(app.getProperty(app.getProperty("web.baseURL")+"/login.php"));
    }
}
