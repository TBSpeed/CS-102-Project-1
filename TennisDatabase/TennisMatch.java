/*
TBSpeed
CS102
Assignment 1
*/
package TennisDatabase;

import java.util.*;
import java.io.*; 

public class TennisMatch implements TennisMatchInterface 
{
   String player1Id;//class's player 1 id
   String player2Id;//class's player 2 id
   int dateYear;//classes year
   int dateMonth;//classes month      
   int dateDay;//classes day
   String tournament;//classes tournament
   String score;//classes score
   
   public TennisMatch(String inPlayer1Id, String inPlayer2Id, int inDateYear, int inDateMonth, int inDateDay, String inTournament, String inScore) 
   {//sets all class vars for this instance of tennis match
      player1Id = inPlayer1Id;
      player2Id = inPlayer2Id;
      dateYear = inDateYear;
      dateMonth = inDateMonth;
      dateDay = inDateDay;
      tournament = inTournament;
      score = inScore;
   }

   public String getPlayer1Id() //return requested information
   {
      return this.player1Id;
   }

   public String getPlayer2Id()//return requested information 
   {
      return this.player2Id;
   }

   public int getDateYear() //return requested information
   {
      return this.dateYear;
   }

   public int getDateMonth() //return requested information
   {
      return this.dateMonth;
   }

   public int getDateDay()//return requested information
   {
      return this.dateDay;
   }

   public String getTournament() //return requested information
   {
      return this.tournament;
   }

   public String getScore() //return requested information
   {
      return this.score;
   }
   
   public int getWinner() //return requested information
   {
      return recGetWinner(score);
   }
   
   public int recGetWinner(String score)//calculates the winner of a match in the form of net score
   {
      if (score.length() == 3)
      {
         return Character.getNumericValue(score.charAt(0)) - Character.getNumericValue(score.charAt(2));
      }
      else
      {
       return (Character.getNumericValue(score.charAt(0)) - Character.getNumericValue(score.charAt(2))) + recGetWinner(score.substring(4));
      }
   }

   public int compareTo(TennisMatch tm) //overrides compareTo for tennis matches
   {//returns 1 if the first match was sooner, -1 if the second match was sooner, or 0 if the mathces occured on the same date.
      if (this.dateYear > tm.getDateYear()) 
      {
         return 1;
      } 
      else if (this.dateYear < tm.getDateYear()) 
      {
         return -1;
      } 
      else 
      {
         if (this.dateMonth > tm.getDateMonth()) 
         {
            return 1;
         } 
         else if (this.dateMonth < tm.getDateMonth()) 
         {
            return -1;
         } 
         else 
         {
            if (this.dateDay > tm.getDateDay()) 
            {
               return 1;
            } 
            else if (this.dateDay < tm.getDateDay()) 
            {
               return -1;
            } 
            else 
            {
               return 0;
            }
         }
      }
   }

   public void print() //prints match
   {
      System.out.println(dateYear + "/" + dateMonth + "/" + dateDay + ", " + player1Id + "-"+ player2Id + ", " + tournament + "," + score);
   }
   public String toString() //converts match toString
   {
      return (dateYear + "/" + dateMonth + "/" + dateDay + ", " + player1Id + "-"+ player2Id + ", " + tournament + "," + score);
   }
}