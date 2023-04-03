package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

   private List<Shape> shapeList = new ArrayList<>();

   public Shape addFigure(Shape shape) {
      shapeList.add(shape);
      return shape;
   }

   public void removeFigure(Shape shape) {
      if (shapeList.size() > 0) {
         shapeList.remove(shape);
      }
   }

   public Shape getFigure(int index) {
      if (shapeList.size() > index) {
         return shapeList.get(index);
      } else {
         return null;
      }
   }

   public String showFigures() {
      String name = "";
      for (Shape shape : shapeList) {
         name += shape.getShapeName();
      }
      return name;
   }
}
