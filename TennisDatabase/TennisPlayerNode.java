package TennisDatabase;

import java.util.*;
import java.io.*;
import TennisDatabase.TennisDatabaseRuntimeException;

/*
TBSpeed
CS102
Assignment 1
*/
public class TennisPlayerNode implements TennisPlayerNodeInterface 
{
   TennisPlayerNode prev;//prev node ref
   TennisPlayerNode next;//next node ref
   TennisPlayer player;//tennis player ref
   TennisMatch[] playersMatches;//tennis matches array
   private int sizeLogical;//keeps track of the logical size of the matches array
   private int sizePhysical;//keeps track of the physical size of the  matches array
   
   public TennisPlayerNode(TennisPlayer p) 
   {//sets vars for this instance of tennisPlayerNode
      player = p;
      next = null;
      prev = null;
      sizeLogical = 0;
      sizePhysical = 2;
      playersMatches = new TennisMatch[sizePhysical];//creates array of matches
   }
   public TennisPlayer getPlayer() //returns requested information
   {
      return this.player;
   }
   public void setPlayer(TennisPlayer inPlayer) //sets player
   {
      this.player = inPlayer;
   }
   public TennisPlayerNode getPrev() //returns requested information
   {
      return this.prev;
   }

   public TennisPlayerNode getNext() //returns requested information
   {
      return this.next;
   }

   public void setPrev(TennisPlayerNode p) //sets preveous node ref
   {
      this.prev = p;
   }

   public void setNext(TennisPlayerNode n) //sets next nore ref
   {
      this.next = n;
   }

   public void insertMatch(TennisMatch m) //inserts a match to this players match array
   {
      // If array is full, resize.
      if( sizeLogical == sizePhysical ) {
         TennisMatch[] tmn = new TennisMatch[playersMatches.length + 1]; // New bigger array.
         // Trasfer data from old smaller array to new bigger array.
         for( int index = 0; index < playersMatches.length; index++)
         {
            tmn[index] = playersMatches[index];  
         }
         playersMatches = tmn;
         sizePhysical++;
      }
      // If we are here, the array is for sure not full!
      // Find point of insertion.
      int index;
      for(index = 0; ( index < sizeLogical ) && ( m.compareTo(playersMatches[index]) < 0 ); index++) {}
      int pointOfInsertion = index;
      // Check if insertion point is at end.
      if( pointOfInsertion == sizeLogical ) {
         playersMatches[sizeLogical] = m;
         sizeLogical++;
      }
      else {
         // Insertion in the middle (or at front), right shift required.
         for(int i = sizeLogical-1; i >= pointOfInsertion; i--) {
            playersMatches[i+1] = playersMatches[i];
         }
         playersMatches[pointOfInsertion] = m;//pus m in the hole left at pointOfInsertion
         sizeLogical++;
      }
   }

   public void printMatches()
   {//prints all matches in this players match array
      for (int index = 0; index < playersMatches.length; index++)
      {
         System.out.println(playersMatches[index].toString());
      }
   }
}