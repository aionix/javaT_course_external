package ru.stqa.pft.addressbook.tests.contactsTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.tests.TestBase;

import java.io.File;

/**
 * Created by Sergey on 28.03.2017.
 */
public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreationNullGroup(){
        app.goTo().goToHomePage();
        app.getContactHelper().initNewContact();
        app.getContactHelper().fillContactForm(new ContactData("testFirst", "testLastName", null), true);
        app.getContactHelper().submitContactCreation();
        app.goTo().goToHomePage();
    }

    @Test(enabled = false)
    public void testContactCreationGroupWithPhoto(){
        app.goTo().goToHomePage();
        app.getContactHelper().initNewContact();
        System.out.println(new File(".").getAbsoluteFile());
        File photo = new File("src/test/resources/pic.jpg");
        app.getContactHelper()
                .fillContactFormPhoto(new ContactData("createWithPhoto7771", "lastname")
                .withPhoto(photo), true);
        app.getContactHelper().submitContactCreation();
        app.goTo().goToHomePage();
    }



}
