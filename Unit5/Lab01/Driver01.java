	//Name______________________________ Date_____________
  

import java.io.*;
public class Driver01
{
   public static void main(String[] args)
   {
      	//input
      double[] myArray = {2.0, 3.7, 9.9, 8.1, 8.5, 7.4, 1.0, 6.2};
      				      
      	//sort the array
      int maxIndex = 0;
      double temp;
      for(int trials = 0; trials < myArray.length; trials++)
      {
         double max = myArray[0];
         for(int index = 0; index < myArray.length - trials; index++)
         {
            if(myArray[index] > max)
            {
               maxIndex = index;
               max = myArray[index];
            }
         }
         temp = myArray[maxIndex];
         myArray[maxIndex] = myArray[myArray.length - trials - 1];
         myArray[myArray.length - trials - 1] = temp;
      }		  
      	//output
      System.out.print("The sorted array is: ");
      for(int i = 0; i < myArray.length; i++)
      {
         System.out.println(myArray[i] + " ");
      }
      	
   }
}