package ru.stqa.pft.addressbook.tests;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Артем on 28.03.2017.
 */
public class smth {
  static int count = 0;
  public static void main (String[] args) {
    String[] la = new String[10];
    la[0] = "one";
    String cc = la[0];
    System.out.println(cc);

    String b = "asdbcf hello world";
    String a = "helo";
    smth call = new smth();
   // call.match(a, b);
    System.out.println(count);

  }
  void match(String a){
    for (int index = 0; ((index = a.indexOf("o"))!= -1); index++) {
      System.out.println();

  }
  }
/*  void match(String a, String b) {
    for (int i = 0; i < a.length(); i++) {
      for(int j = 0; j < b.length(); j++) {
      }if(a.matches(b)) {count++;}
      }
}*/
}
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
