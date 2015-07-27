import java.io.*;      //the File class
import java.util.*;    //the Scanner class
public class Driver05
{
   public static void main(String[] args) throws Exception
   {
      Comparable[] array = input("data.txt");
      sort(array);
      output(array, "output.txt");
   }
   	
   public static Comparable[] input(String filename) throws Exception
   {	
      Scanner infile = new Scanner( new File(filename) );
      int numitems = infile.nextInt();
      Comparable[] array = new Distance[numitems];
      for(int k = 0; k < numitems; k++)
      {
         Distance a = new Distance();
         a.setPounds(infile.nextInt());
         a.setOunces(infile.nextInt());
         array[k] = a;
      }
      infile.close();
      return array;
   }
      
   public static void output(Object[]array, String filename) throws Exception
   {
      System.setOut(new PrintStream(new FileOutputStream(filename)));
      for(int k = 0; k < array.length; k++)
         System.out.println(array[k].toString());
   }
      
   public static void sort(Comparable[] array)
   {
      int maxPos;
      for(int k = 0; k < array.length; k++)
      {
         maxPos = findMax(array, array.length - k);
         swap(array, maxPos, array.length - k - 1);
      }
   }
   public static void swap(Comparable[] array, int a, int b)
   {
      Comparable temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   public static int findMax(Comparable[] array, int upper)
   {
      Comparable max = array[0];
      int maxIndex = 0;
      for(int index = 0; index < upper; index++)
      {
         if(array[index].compareTo(max) > 0)
         {
            maxIndex = index;
            max = array[index];
         }
      }
      return maxIndex;
   }
}