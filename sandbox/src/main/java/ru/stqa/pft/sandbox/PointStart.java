package ru.stqa.pft.sandbox;

/**
 * Created by Артем on 26.03.2017.
 */
public class PointStart {
  public static void main(String[] args){
    Point p1 = new Point(1.0, 5.0);
    Point p2 = new Point(1.0, 1.0);

    System.out.println(Point.distance(p1, p2));


  }
}
