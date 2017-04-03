package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Sergey on 28.03.2017.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initNewContact(){
        click(By.xpath("*//li/a[text()='add new']"));
    }
    public void submitContactCreation(){
        click(By.cssSelector("input:nth-of-type(1)[name='submit']"));
    }
    public void initContactModification(){
        click(By.cssSelector("[href*='id=3']>img[alt='Edit']"));
    }
    public void submitContactModification() {
        click(By.cssSelector("form>[name='update']:nth-of-type(1)"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        if (creation == true )  //&& contactData.getGroup()!= null
        {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else Assert.assertFalse(isElementPresent(By.name("new_group"))); {
        }
    }
    public void fillContactFormPhoto(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation == true && contactData.getGroup()!= null )
        {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }else Assert.assertFalse(isElementPresent(By.name("new_group"))); {
        }
    }

}
