package com.kodilla.testing.shape;

public class Square implements Shape{

   private double side;

   public Square(double side) {
      this.side = side;
   }

   @Override
   public String getShapeName() {
      return "square";
   }

   @Override
   public double getArea() {
      double area = this.side * this.side;
      return area;
   }
}
