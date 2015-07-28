//Name______________________________ Date_____________
  

import java.io.*;      //the File class
import java.util.*;    //the Scanner class
import javax.swing.JOptionPane;
import java.util.Comparator;
public class Driver07
{
   public static void main(String[] args)
   {
      Salesperson[] array = input("data.txt");
      menu(array);
      System.exit(0);
   }
 
   public static Salesperson[] input(String filename)
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
      Salesperson[] array = new Salesperson[numitems];
      for(int k = 0; k < numitems; k++)
      {
         String name = infile.next();
         int c = infile.nextInt();
         int t = infile.nextInt();
         array[k] = new Salesperson(name, c, t);
      }
      infile.close();
      return array;
   }
	
   public static void menu(Salesperson[]array)
   {
      int choice = 0;
      while(choice != 7)
      {
         String message = "";
         message = message + "\n1. List Alphabetically.";
         message = message + "\n2. List by Cars Sold.";
         message = message + "\n3. List by Trucks Sold.";
         message = message + "\n4. List by Total Sales.";
         message = message + "\n5. Add Sales.";
         message = message + "\n6. Save data to file.";
         message = message + "\n7. Quit.";
         choice = Integer.parseInt(JOptionPane.showInputDialog(message));
         switch(choice)
         {
            case 1: display(array, new ByName());
               break;
            case 2: display(array, new ByCars());
               break;
            case 3: display(array, new ByTrucks());
               break;
            case 4: display(array, new ByTotalSales());
               break;
            case 5: add(array);
               break;
            case 6: save(array);
               break;
            case 7: 
               for(int k = 0; k < 25; k++) 
                  System.out.println();
               System.out.println("Bye-bye!");
               break;
            default: System.out.println("Not a valid selection.");
               break;
         }
         System.out.println();
      }
   }
 
   public static void save(Salesperson[] array)
   {
      PrintStream outfile = null;
      try{
         outfile = new PrintStream(new FileOutputStream("data.txt"));
      }
      catch(FileNotFoundException e)
      {
         JOptionPane.showMessageDialog(null,"The file could not be created.");
      }
       	outfile.println("" + array.length);
         for(int i = 0; i < array.length; i++)
         {
            outfile.println("" + array[i].getName());
            outfile.println("" + array[i].getCars());
            outfile.println("" + array[i].getTrucks());
         }
      outfile.close();
      System.out.println("Saved.");
   }
   public static void add(Salesperson[] array)
   {	
      String s = JOptionPane.showInputDialog("What salesperson?");
      String r = JOptionPane.showInputDialog("Cars or Trucks?");
      String a = "Cars";
      String b = "Trucks";
      if(r.equals(a))
      {
         int c = Integer.parseInt(JOptionPane.showInputDialog("How many cars?"));
         int i = search(array, s);
         array[i].setName(s);
         array[i].setCars(array[i].getCars()+c);
         save(array);
      }
      if(r.equals(b))
      {
         int t = Integer.parseInt(JOptionPane.showInputDialog("How many trucks?"));
         int i = search(array, s);
         array[i].setTrucks(array[i].getTrucks()+t);
         save(array);
      }
      System.out.println("Sales added.");
   }
   public static int search(Salesperson[] array, String name)
   {
      for(int i = 0; i < array.length; i++)
      {
         String s = array[i].getName();
         String r = name;
         if(s.equals(r))
            return i;
      }
      return -1;
   }
   public static void display(Salesperson[] array, Comparator c)
   {
      sort(array, c);
      System.out.println("Name\tCars\tTrucks\tTotal");
      System.out.println("----------------------------");
      for(int i = 0; i < array.length; i++)
      {
         System.out.println(array[i].getName() + "\t" + array[i].getCars() + "\t" + array[i].getTrucks() + "\t" + (array[i].getCars()+array[i].getTrucks()));
      }
   }
   public static void sort(Object[] array, Comparator c)
   {
      int minPos;
      for(int k = 0; k < array.length; k++)
      {
         minPos = findMin(array, array.length - k, c);
         swap(array, minPos, array.length - k - 1);
      }
   }
   public static int findMin(Object[] array, int upper, Comparator c)
   {
      int minIndex = 0;
      for(int index = 0; index < upper; index++)
      {
         if(c.compare(array[index], array[minIndex])< 0)
         {
            minIndex = index;
         }
         
      }
      return minIndex;
   }
   public static void swap(Object[] array, int a, int b)
   {
      Object temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
}