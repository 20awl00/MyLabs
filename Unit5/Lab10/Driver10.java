  //Name______________________________ Date_____________
  
import java.io.*;       		 //the File class
import java.util.*;     		 //the Scanner class
import javax.swing.JOptionPane;
public class Driver10
{
   public static void main(String[] args)
   {
      Song[] songList = input();
      int totalTime = calcTime(songList);
      int longestSong = searchLongestSong(songList);
      display(songList, totalTime, longestSong);
      System.exit(0);
   }
   	
   public static Song[] input() 
   {
      Scanner infile = null;
      try
      {
         String filename = JOptionPane.showInputDialog("Enter filename");
         
         infile = new Scanner( new File(filename));
      }
      catch(FileNotFoundException e)
      {
         System.out.println("File not found exception");
         System.exit(0);
      }
      Song[] songList = new Song[Integer.parseInt(infile.nextLine())];
      for(int i = 0; i < songList.length; i++)
      {
         songList[i] = new Song(infile.nextLine());  
      }
      return songList;
   }
   
   public static int calcTime(Song[] songs)
   {
      int totalT = 0;
      for(int i = 0; i < songs.length; i++)
      {
         totalT += songs[i].getTotal();
      }
      return totalT;
   }
      
   public static int searchLongestSong(Comparable[] songs)
   {
      int max = 0;
      for(int index = 0; index < songs.length; index++)
      {
         if(songs[index].compareTo(songs[max]) > 0)
         {
            max = index;
         }
      }
      return max;
   
   }
      
   public static void display(Song[] array, int total, int longestSong)
   {
      int mins = total / 60;
      int secs = total % 60;
      
      System.out.println("Total Time: " + mins + "' " + secs + "\"");
      System.out.println("Longest Song: " + array[longestSong].toString());
   }
}