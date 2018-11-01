/*
TBSpeed
CS102
Assignment 1
*/
package TennisDatabase;

import TennisDatabase.TennisDatabaseRuntimeException;

public class TennisMatchesList implements TennisMatchesListInterface {

   private TennisMatchNode head;//the starting point of the linked list
   private int numMatches;//the number of nodes

   public TennisMatchesList() 
   {
      head = null;//start null
      numMatches = 0;//with 0 nodes
   }

   public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException 
   {//adds a match to the lsit
      TennisMatchNode prevNode = null;//preveous node pointer
      TennisMatchNode currNode = head;//starting point for calculations
      while ((currNode != null) && (m.compareTo(currNode.getMatch()) < 0)) 
      {
         prevNode = currNode;
         currNode = currNode.getNext();
      }
      TennisMatchNode newNode = new TennisMatchNode();
      if(currNode == head) 
      {
         newNode.setNext(head);
         head = newNode;
      }
      else 
      {
         newNode.setNext(currNode);
         prevNode.setNext(newNode);
      }
      numMatches++;
   }

   public void printMatches() throws TennisDatabaseRuntimeException
   {//prints all matches
      if (head == null)//if no nodes
         throw new TennisDatabaseRuntimeException("No Tennis Matches Available");
      else
      {//prints all matches
         TennisMatchNode curr = head;
         while (curr.next != null)
         {
            curr.getMatch().print();
            curr = curr.next;
         }
      }
   }
}