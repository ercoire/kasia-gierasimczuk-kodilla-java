package com.kodilla.testing.shape;

public class Circle implements Shape {

   private double r;

   public Circle(double r) {
      this.r = r;
   }

   @Override
   public String getShapeName() {
      return "circle";
   }

   @Override
   public double getArea() {
      double area = 3.14 * this.r * this.r;
      return area;
   }
}
