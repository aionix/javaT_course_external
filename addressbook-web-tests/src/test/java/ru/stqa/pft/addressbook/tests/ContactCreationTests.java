package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Sergey on 28.03.2017.
 */
public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreationNullGroup(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initNewContact();
        app.getContactHelper().fillContactForm(new ContactData("testFirst", "testLast", null), true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }
    @Test
    public void testContactCreationGroup(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initNewContact();
        app.getContactHelper().fillContactForm(new ContactData("testFirst2", "testLast2", "group_name5"), true);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
    }


}
