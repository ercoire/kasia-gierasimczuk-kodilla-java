package com.kodilla.testing.shape;

public class Triangle implements Shape {

   private double a;
   private double h;

   public Triangle(double a, double h) {
      this.a = a;
      this.h = h;
   }

   @Override
   public String getShapeName() {
      return "triangle";
   }

   @Override
   public double getArea() {
      double area;
      area = a * h / 2;
      return area;
   }
}
