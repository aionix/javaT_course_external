package ru.stqa.pft.addressbook.tests;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Артем on 28.03.2017.
 */
public class smth {
  static int count = 0;
  public static void main (String[] args) {

    String b = "asdbcf hello world";
    String a = "helo";
    smth call = new smth();
  //  call.match(a);
    SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd");
    System.out.println(dateFormatLocal.getCalendar().getCalendarType());
    LocalTime time = LocalTime.now();
    String modif = time.getHour()+":"+time.getMinute()+"."+time.getSecond();
    System.out.println(modif);
   // System.out.println("group_name,time: "+time.getHour()+":"+time.getMinute()+"."+time.getSecond());

  }
/*  void match(String a){
    for (int index = 0; ((index = a.indexOf('o'))!= -1); index = +1) {
      System.out.println(index);

  }*/
  }

  /*public  String init() throws IOException {

    properties = new Properties();
    String target = System.getProperty("target", "local");
    // System.out.println(new File(".").getAbsolutePath());
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    return properties.getProperty("web.adminPassword");

  }*/
/*  void match(String a, String b) {
    for (int i = 0; i < a.length(); i++) {
      for(int j = 0; j < b.length(); j++) {
      }if(a.matches(b)) {count++;}
      }
}*/

/*  String letterBody = (String) bodyPart.getContent();
  //находим ссылку и вырезаем
  Pattern patty = Pattern.compile(regDetailed);
  Matcher matcher = patty.matcher(letterBody);
  //System.out.println(letterBody);
  int startStr = 0;
  int endStr = 0;
                    while (matcher.find()) {
                            startStr = matcher.start();
                            endStr = matcher.end();
                            theUrl = letterBody.substring(startStr, endStr);*/
