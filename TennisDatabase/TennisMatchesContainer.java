/*
TBSpeed
CS102
Assignment 1
*/
package TennisDatabase;

import TennisDatabase.TennisDatabaseRuntimeException;

public class TennisMatchesContainer implements TennisMatchesContainerInterface 
{

   private TennisMatch[] tma;//clases tennis match array
   private int sizeLogical;//keeps track of the logical size of the array
   private int sizePhysical;//keeps track of the physical size of the array

   public TennisMatchesContainer() 
   {
      sizePhysical = 2;//starting physical size
      sizeLogical = 0;//starting logical size
      tma = new TennisMatch[sizePhysical];//creates array
   }

   public void insertMatch(TennisMatch m) 
   {
      // If array is full, resize.
      if( sizeLogical == sizePhysical ) {
         TennisMatch[] tmn = new TennisMatch[tma.length + 1]; // New bigger array.
         // Trasfer data from old smaller array to new bigger array.
         for( int index = 0; index < tma.length; index++)
         {
            tmn[index] = tma[index];  
         }
         tma = tmn;
         sizePhysical++;
      }
      // If we are here, the array is for sure not full!
      // Find point of insertion.
      int index;
      for(index = 0; ( index < sizeLogical ) && ( m.compareTo(tma[index]) < 0 ); index++) {}
      int pointOfInsertion = index;
      // Check if insertion point is at end.
      if( pointOfInsertion == sizeLogical ) {
         tma[sizeLogical] = m;
         sizeLogical++;
      }
      else {
         // Insertion in the middle (or at front), right shift required.
         for(int i = sizeLogical-1; i >= pointOfInsertion; i--) {
            tma[i+1] = tma[i];
         }
         tma[pointOfInsertion] = m;//pus m in the hole left at pointOfInsertion
         sizeLogical++;
      }
   }

   public void printAllMatches() throws TennisDatabaseRuntimeException 
   {
      if (tma.length == 0) //if no matches
      {
         throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
      } 
      else 
      {
         for (int i = 0; i < sizeLogical; i++) //for all matches
         {
            tma[i].print();//print
         }
      }
   }
   public void printMatchesOfPlayer(String id) throws TennisDatabaseRuntimeException 
   {
      if (tma.length == 0) //if no matches
      {
         throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
      } 
      else 
      {
         for (int i = 0; i < sizeLogical; i++) //for all matches
         {
            if (tma[i].getPlayer1Id().equals(id))
               tma[i].print();//print if player id1 is id
            if (tma[i].getPlayer2Id().equals(id))
               tma[i].print();//print if player id2 is id
         }
      }
   }
   public int getPlayerScore(String id) throws TennisDatabaseRuntimeException 
   {
      int pong = 0;//return variable
      if (tma.length == 0) //if no matches
      {
         throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
      } 
      else 
      {
         int matchCount = 0;
         for (int i = 0; i < sizeLogical; i++) //for all matches
         {
            if (tma[i].getPlayer1Id().equals(id))
               matchCount++;//count if player id2 is id
            if (tma[i].getPlayer2Id().equals(id))
               matchCount++;//count if player id2 is id
         }
         TennisMatch[] playersMatches = new TennisMatch[matchCount];//make array of sise equal to the number of matches a player has
         matchCount = 0;//reset match count
         for (int i = 0; i < sizeLogical; i++) 
         {
            if (tma[i].getPlayer1Id().equals(id))//for all matches
            {
               playersMatches[matchCount] = tma[i];//store in playersMatches if id matches id1
               matchCount++;
            }
            if (tma[i].getPlayer2Id().equals(id))
            {
               playersMatches[matchCount] = tma[i];//store in playersMatches if id matches id2
               matchCount++;
            }
         }
         for (int i = 0; i < playersMatches.length; i++) 
         {
            pong = pong + playersMatches[i].getWinner();//count net score
         }
      }
      return pong;//return net score
   }
}