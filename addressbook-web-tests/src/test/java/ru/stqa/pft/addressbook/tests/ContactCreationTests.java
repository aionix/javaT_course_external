package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

/**
 * Created by Sergey on 28.03.2017.
 */
public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreationNullGroup(){
        app.goTo().goToHomePage();
        app.getContactHelper().initNewContact();
        app.getContactHelper().fillContactForm(new ContactData("testFirst", "testLast", null), true);
        app.getContactHelper().submitContactCreation();
        app.goTo().goToHomePage();
    }

    @Test//(enabled = false)
    public void testContactCreationGroupWithPhoto(){
        app.goTo().goToHomePage();
        app.getContactHelper().initNewContact();
        System.out.println(new File(".").getAbsoluteFile());
        File photo = new File("src/test/resources/pic.jpg");
        app.getContactHelper()
                .fillContactFormPhoto(new ContactData("createWithPhoto", "lastname", "aa1")
                .withPhoto(photo), true);
        app.getContactHelper().submitContactCreation();
        app.goTo().goToHomePage();
    }



}
