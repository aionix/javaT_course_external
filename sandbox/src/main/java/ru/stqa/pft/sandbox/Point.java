package ru.stqa.pft.sandbox;

/**
 * Created by Артем on 26.03.2017.
 */
public class Point {
  double x=0;
  double y=0;

  public Point(double a, double b) {
    x = a;
    y = b;
  }
  public Point(){}

  public static double distance(Point p1, Point p2){
    return Math.sqrt( Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2) );
  }

}
