/*
TBSpeed
CS102
Assignment 1
*/
package TennisDatabase;

public class TennisPlayersContainer implements TennisPlayersContainerInterface 
{
   TennisPlayerNode head;//classes node head ref
   int numPlayers;//number of players
   
   public void TennisPlayerContainer() 
   {//sets vars for this instance of tennisPLayersContainer
      head = null;
      numPlayers = 0;
   }

   public void insertPlayer(TennisPlayer p) throws TennisDatabaseRuntimeException 
   {//inserts a new node with player p, sorted by ID
      TennisPlayerNode newNode = new TennisPlayerNode(p);
      if (numPlayers == 0) 
      {
         head = newNode;
         head.setPrev(head);
         head.setNext(head);
         numPlayers++;
      } 
      else 
      {
         TennisPlayerNode currNode = head;
         int indexCurrNode = 0;//holds the index of the current node, used to keep from circleing the list forever
         while ((indexCurrNode <= numPlayers) && (p.compareTo(currNode.getPlayer()) > 0)) 
         {
            currNode = currNode.getNext();
            indexCurrNode++;
         }
         if (p.compareTo(currNode.getPlayer()) != 0)
         {
            newNode.setNext(currNode.getNext());
            newNode.setPrev(currNode);
            currNode.setNext(newNode);
            newNode.getNext().setPrev(newNode);
            numPlayers++;
         }
      }
   }
   public TennisPlayer getTennisPlayer(String id) throws NullPointerException
   {//returns a tennis player referance
      TennisPlayerNode currNode = head;
      for (int i = 0; i <= numPlayers; i++) 
      {//for all nodes
         if (currNode.getPlayer().getId().equals(id)) 
         {//if currnodes's player's id matches id
            return currNode.getPlayer();//return this player
         } 
         else 
         {//else next node
            currNode = currNode.getNext();
         }
      }
      return null;
   }
   public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException 
   {//inserts a match into the players matches array
      String id1 = m.getPlayer1Id();//id of player 1
      String id2 = m.getPlayer2Id();//id of player 2
      TennisPlayerNode currNode = head;//starting point
      for (int i = 0; i <= numPlayers + 1; i++) 
      {//for all nodes
         if (currNode.getPlayer().getId().equals(id1)) 
         {//if currnodes's player's id matches id1
            currNode.insertMatch(m);//insert match
         } 
         currNode = currNode.getNext();//next node
      }
      currNode = head;
      for (int i = 0; i <= numPlayers + 1; i++) 
      {//for all nodes
         if (currNode.getPlayer().getId().equals(id2)) 
         {//if currnodes's player's id matches id2
            currNode.insertMatch(m);//insert match
         } 
         currNode = currNode.getNext();//next node
      }
   
   }
   public void printAllPlayers(TennisMatchesContainer tmc) throws TennisDatabaseRuntimeException 
   {//print all players
      TennisPlayerNode currNode = head;//starting point
      for (int i = 0; i < numPlayers; i++) 
      {//for all nodes
         System.out.println(currNode.getPlayer() + ", " + tmc.getPlayerScore(currNode.getPlayer().getId()) + " (Net Score)");//print player
         currNode = currNode.getNext();//next node
      }
   
   }
   public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException 
   {//print matches of player
      TennisPlayerNode currNode = head;//starting point
      boolean wasPrinted = false;//if something was printed, used for error detection
      for (int i = 0; i <= numPlayers + 1; i++) 
      {//for all nodes
         if (currNode.getPlayer().getId().equals(playerId)) 
         {//if currnodes's player's id matches id
            currNode.printMatches();//print matches
            wasPrinted = true;//set was printed
         } 
         currNode = currNode.getNext();//next node
      }
      if (!wasPrinted)//if nothing was printed
         System.out.println("Error 404: Player not found");//print error
   }
}