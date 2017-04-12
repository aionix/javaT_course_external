package ru.stqa.pft.mantis.appmanager;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;


public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseURL")+"/signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), username);
        click(By.cssSelector(".button[value='Signup']"));
    }
}
