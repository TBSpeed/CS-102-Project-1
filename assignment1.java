/*
TBSpeed
CS102
Assignment 1
*/
import java.util.*;
import java.io.*;
import TennisDatabase.TennisDatabase;
import TennisDatabase.TennisDatabaseException;
import TennisDatabase.TennisDatabaseRuntimeException;

public class assignment1 
{

   private static File inputFile; // set the input file
   static TennisDatabase tdb; //Create a Tennis database referance
   public static void main(String[] args) throws FileNotFoundException
   {
   boolean reload = true; //used for handeleing wether or not to reload the database
   while (reload)
   {
      tdb = new TennisDatabase();//Create a new Tennis database
      loadFilePlayers("input.txt");//Load all players from file
      loadFileMatches("input.txt");//load all matches from file
      reload = startTennisManager();//run the Database manager and prepare to reload if needed
      }
      System.out.print("Exiting System");//prints closeing status before close
   }

   public static boolean startTennisManager() 
   {
      int option;//Var for holding user option selection
      Scanner userIn = new Scanner(System.in);//user input
      while (true) //this will go untill the method returns
      {
         System.out.println("\nSelect an option by entering the option's number:\n1 -  Print All Players\n2 -  Print All Matches\n3 -  Print All Matches For A Player\n4 -  Add a Player\n5 -  Add a Match\n\n7 -  Exit\n8 -  Reload Database");
         option = userIn.nextInt();//What if  a String is entered?
         switch (option) 
         {
            case 1:
               tdb.printAllPlayers();//prints all players
               break;
            case 2:
               tdb.printAllMatches();//prints all matches
               break;
            case 3:
               System.out.println("Please enter the player ID to print");//askes for player ID
               tdb.printMatchesOfPlayer(userIn.next());//prints matches of player ID
               break;
            case 4:
               System.out.println("In this order and on seperate lines, Please enter the: player id, first name, last name, year, and country");
               tdb.insertPlayer(userIn.next(), userIn.next(), userIn.next(), userIn.nextInt(), userIn.next());//makes new player
               break;
            case 5:
               System.out.println("In this order and on seperate lines, Please enter the: id of player 1, id of player 2, year, month, day, tournament, and score");
               tdb.insertMatch(userIn.next(), userIn.next(), userIn.nextInt(), userIn.nextInt(), userIn.nextInt(), userIn.next(), userIn.next());//makes new match
               break;
            case 7:
               return false;//exits the database, without reloading the database
            case 8:
               return true;//exits the database, but reloads the database
            default://catches bad input
               System.out.println("Please choose an option that was listed...");
               break;
         }
      }
   
   }
   public static void loadFilePlayers(String fileName) throws FileNotFoundException 
   {
      File inputFile = new File(fileName);//file in File
      Scanner readFile = new Scanner(inputFile);//fle in reader
      String line; // Defining a line in the input file
      String[] data; // An array of the line when parsed
      while (readFile.hasNext()) { // If there is a line that hasn't been scanned
      
         line = readFile.nextLine(); // Scan the line
         data = line.split("/"); // Parse the line
         switch (data[0].charAt(0)) 
         {
            case 'P':
               tdb.insertPlayer(data[1], data[2], data[3], Integer.parseInt(data[4]), data[5]); // Add Player
               break;
         }
      }
   }
   public static void loadFileMatches(String fileName) throws FileNotFoundException 
   {
      File inputFile = new File(fileName);//file in File
      Scanner readFile = new Scanner(inputFile);//File in Reader
      String line; // Defining a line in the input file
      String[] data; // An array of the line when parsed
      while (readFile.hasNext()) { // If there is a line that hasn't been scanned
      
         line = readFile.nextLine(); // Scan the line
         data = line.split("/"); // Parse the line
         switch (data[0].charAt(0)) 
         {            
            case 'M':
               tdb.insertMatch(data[1], data[2], Integer.parseInt(data[3].substring(0,4)), Integer.parseInt(data[3].substring(4,6)), Integer.parseInt(data[3].substring(6,8)), data[4], data[5]); // Add Match
               break;
         }
      }
   }
}