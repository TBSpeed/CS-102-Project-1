/*
TBSpeed
CS102
Assignment 1
*/
package TennisDatabase;

public class TennisPlayer implements TennisPlayerInterface 
{
   public String id;//class id
   public String firstName;//class firstName
   public String lastName;//class lastName
   public int year;//class year
   public String country;//class country
   
   public TennisPlayer(String idIn, String firstIn, String lastIn, int yearIn, String contIn) 
   {//sets the class variables for this instance of tennis player
      id = idIn;
      firstName = firstIn;
      lastName = lastIn;
      year = yearIn;
      country = contIn;
   }

   public String getId() //gets requested information
   {
      return this.id;
   }

   public String getFirstName() //gets requested information
   {
      return this.firstName;
   }

   public String getLastName() //gets requested information
   {
      return this.lastName;
   }

   public int getBirthYear() //gets requested information
   {
      return this.year;
   }

   public String getCountry() //gets requested information
   {
      return this.country;
   }
   public int compareTo(TennisPlayer tp) 
   {//overrides compareTo for tennis player. returns 1 if first is greater than the second, -1 if inverse, or 0 if equal
      if ((this.id.compareTo(tp.getId())) > 0)
         return 1;
      if ((this.id.compareTo(tp.getId())) == 0)
         return 0;
      if ((this.id.compareTo(tp.getId())) < 0)
         return -1;
      return -5;//returns -5 if errored
   }
   public void print() 
   {//prints player
      System.out.println(toString());
   }

   public String toString() 
   {//converts player to String
      String pong = this.id + ": " + this.firstName + ", " + this.lastName + ", " + this.year + ", " + this.country;
      return pong;
   }
}