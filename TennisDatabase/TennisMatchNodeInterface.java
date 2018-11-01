/*
TBSpeed
CS102
Assignment 1
*/
package TennisDatabase;

// Interface (package-private) providing the specifications for the TennisPlayerNode class.
interface TennisMatchNodeInterface {
   
   // Accessors (getters).
   public TennisMatch getMatch();
   public TennisMatchNode getPrev();
   public TennisMatchNode getNext();
   
   // Modifiers (setters).
   public void setPrev( TennisMatchNode p );
   public void setNext( TennisMatchNode n );
}