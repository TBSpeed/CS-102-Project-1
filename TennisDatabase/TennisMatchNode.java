/*
TBSpeed
CS102
Assignment 1
*/
package TennisDatabase;
import java.util.*;
import java.io.*;
public class TennisMatchNode implements TennisMatchNodeInterface 
{
   TennisMatchNode prev;//preveous referance
   TennisMatchNode next;//next referance
   TennisMatch match;//this nodes's match
   public TennisMatch getMatch() //returns match
   {
      return this.match;
   }
   public void setMatch(TennisMatch inMatch) //sets match
   {
      this.match = inMatch;
   }
   public TennisMatchNode getPrev() //gets prev node
   {
      return this.prev;
   }

   public TennisMatchNode getNext() //gets next node
   {
      return this.next;
   }

   public void setPrev(TennisMatchNode p) //sets prev node
   {
      this.prev = p;
   }

   public void setNext(TennisMatchNode n) //nsets next node
   {
      this.prev = n;
   }
}