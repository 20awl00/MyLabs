import java.io.*;
import java.util.*;
public class Driver00
{
   public static void main(String[] args) throws Exception
   {
      Scanner infile = new Scanner(new File("data.txt"));
      int numitems = infile.nextInt();
      double[] array = new double[numitems];
      for(int i = 0; i < numitems; i++)
      {
         array[i] = infile.nextDouble();
      }
      infile.close();
      int minPos, maxPos;
      minPos = findMin(array);
      maxPos = findMax(array);
      System.out.println("Minimum value: " + array[minPos]);
      System.out.println("Maximum value: " + array[maxPos]);
   }
   private static int findMin(double[] apple)
   {
      double min = apple[0];
      int mindex = 0;
      for(int i = 0; i < apple.length; i++)
      {
         if(apple[i] < min)
         {
            mindex = i;
         }
      }
      return mindex;
   }
   private static int findMax(double[] banana)
   {
      double max = banana[0];
      int maxdex = 0;
      for(int i = 0; i < banana.length; i++)
      {
         if(banana[i] > max)
         {
            maxdex = i;
         }
      }
      return maxdex;
   }
}