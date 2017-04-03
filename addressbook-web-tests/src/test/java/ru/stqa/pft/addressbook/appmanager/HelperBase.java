package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by Артем on 26.03.2017.
 */
public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
    wd.findElement(locator).click();
    if(text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }}}
    public void attach(By locator,File file) {
        if(file != null) {
                wd.findElement(locator).sendKeys(file.getAbsolutePath());
            }}


  protected boolean isElementPresent(By locator) {
      try {
          wd.findElement(locator);
          return true;
      }catch (NoSuchElementException e){
      return false;
  }}
}

