package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Sergey on 11.04.2017.
 */
public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void startMailServer(){
   //     app.mail().start();
    }
    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
   //     app.mail().stop();
    }

    @Test
    public void testRegistration(){
        app.registration().start("user1", "user1@localhost.localdomain");
    }
}
