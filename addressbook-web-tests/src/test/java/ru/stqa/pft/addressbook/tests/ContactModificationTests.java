package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Sergey on 28.03.2017.
 */
public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("firstModif", "lastModif", "bla"), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }


}
