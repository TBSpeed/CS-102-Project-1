/*
TBSpeed
CS102
Assignment 1
*/
package TennisDatabase;

import java.util.*;
import java.io.*;
public class TennisDatabase implements TennisDatabaseInterface 
{
   private TennisPlayersContainer tpc;//create the class's Tennis player contaner referance
   private TennisMatchesContainer tmc;//create the class's Tennis matches contaner referance

   public TennisDatabase() 
   {
      tpc = new TennisPlayersContainer();//create new tennis player contaner
      tmc = new TennisMatchesContainer();//create new tennis matches container
   }
   public void printAllPlayers() 
   {
      tpc.printAllPlayers(tmc);//pass the print all players request
   }

   public void printMatchesOfPlayer(String playerId) 
   {
      tmc.printMatchesOfPlayer(playerId);//pass the print matches of player request
   }

   public void printAllMatches() 
   {
      tmc.printAllMatches();//pass the print all matches request
   }

   public void insertPlayer(String id, String firstName, String lastName, int year, String country) 
   {
      TennisPlayer p = new TennisPlayer(id, firstName, lastName, year, country);//create new player from given info
      tpc.insertPlayer(p);//request new player
   }

   public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score) 
   {
      TennisMatch m = new TennisMatch(idPlayer1, idPlayer2, year, month, day, tournament, score);//create new match with requested info
      tmc.insertMatch(m);//add match to lsit
      tpc.insertMatch(m);//add match to players
   }
}