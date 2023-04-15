package com.kodilla.stream.invoice.simple;

public class SimpleProduct {

   private final String productName;
   private final double productPrice;

   public SimpleProduct(String productName, double productPrice) {
      this.productName = productName;
      this.productPrice = productPrice;
   }

   public String getProductName() {
      return productName;
   }

   public double getProductPrice() {
      return productPrice;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof SimpleProduct)) return false;
      SimpleProduct that = (SimpleProduct) o;
      return productName.equals(that.productName);
   }


}
