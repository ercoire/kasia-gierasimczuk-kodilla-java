package com.kodilla.testing.library;

public class LibraryUser {
   private String firstName;
   private String lastName;
   private String peselID;

   public LibraryUser() {
      this.firstName = firstName;
      this.lastName = lastName;
      this.peselID = peselID;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getPeselID() {
      return peselID;
   }

   public void setPeselID(String peselID) {
      this.peselID = peselID;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      LibraryUser that = (LibraryUser) o;

      if (!firstName.equals(that.firstName)) return false;
      if (!lastName.equals(that.lastName)) return false;
      return peselID.equals(that.peselID);
   }

   @Override
   public int hashCode() {
      int result = firstName.hashCode();
      result = 31 * result + lastName.hashCode();
      result = 31 * result + peselID.hashCode();
      return result;
   }


}
