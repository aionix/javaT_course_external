package ru.stqa.pft.sandbox;

public class Tests {

  public static void main(String[] args) {
    String sm = "New york";
    System.out.println("hi asdas " + sm);
    Square r = new Square();
    r.a = 2;
    r.b = 5;
    r.a = 3;
    r.b = 6;
System.out.println("Square " +"a "+ r.a+" "+"b "+r.b +" = " + area(r) );
//    double l = 2.9;
//    double ll = l*l;
//    System.out.println(ll);

  }
  public static int area(Square r){
    return r.a * r.b;
  }

}