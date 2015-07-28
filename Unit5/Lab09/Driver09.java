	//Name______________________________ Date_____________
  
import java.io.*;             //the File class
import java.util.*;   		   //the Scanner class
import javax.swing.*;         //the JOptionPane class
import java.util.Arrays;
public class Driver09
{
   public static void main(String[] args) throws Exception
   {
      String[] array = input("data.txt");
      for(int k = 0; k < array.length; k++)
         array[k] = convert(array[k]);
      Arrays.sort(array);              //why don't you have to implement sort()?
      output(array, "output.txt");
   }
   	
   public static String[] input(String filename)
   {
      Scanner infile = null;
      try{
         infile = new Scanner(new File(filename));
      }
      catch(FileNotFoundException e)
      {
         JOptionPane.showMessageDialog(null,"The file could not be found.");
         System.exit(0);
      }
      int numitems = infile.nextInt();
      String[] array = new String[numitems];
      for(int k = 0; k < numitems; k++)
      {
         array[k] = infile.next();
      }
      infile.close();
      return array;
   }
   	
   public static String convert(String website)
   {
      String packageName = "";
      int pos;
      website = website.substring(4);
      int dots = 0;
      int temp = 0;
      
      for(int x = 0; x < website.length(); x++)
         if(website.substring(x, x+1).equals("."))
            dots++;
      while(website.contains("."))
      {
         String s = website.substring(website.lastIndexOf("."));
         packageName = packageName + (s.substring(s.indexOf(".")+1)+".");
         website = website.substring(0, website.lastIndexOf("."));
      }
      String r = website;
      packageName = packageName + r;
      
      return packageName;
   }
   	
   public static void output(Object[] array, String filename)
   {
      PrintStream outfile = null;
      try{
         outfile = new PrintStream(new FileOutputStream(filename));
      }
      catch(FileNotFoundException e)
      {
         JOptionPane.showMessageDialog(null,"The file could not be created.");
      } 
      for(int k = 0; k < array.length; k++)
         outfile.println(array[k]);
   }
}