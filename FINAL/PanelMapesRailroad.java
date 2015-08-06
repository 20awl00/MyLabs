//Name______________________________ Date_____________
  

import java.io.*;      //the File class
import java.util.*;    //the Scanner class
import javax.swing.JOptionPane;
import java.util.Comparator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PanelMapesRailroad extends JPanel
{
   private JLabel title;
   private JButton next, quit;
   private DisplayMapesRailroad display;
   private int count;
   private JPanel sub;
   public PanelMapesRailroad()
   {
      count = 0;
      Bonus[] array = input("railroad2.txt");
      sort(array);
      setLayout(new BorderLayout());
      title = new JLabel("Mapes Railroad Employee Bonuses");
      add(title, BorderLayout.NORTH);
      display = new DisplayMapesRailroad();
      add(display, BorderLayout.CENTER);
      sub = new JPanel();
      add(sub, BorderLayout.SOUTH);
      sub.setLayout(new GridLayout(1, 2));
      next = new JButton("Next");
      next.addActionListener(new Listener1(array));
      sub.add(next, BorderLayout.SOUTH);
      quit = new JButton("Quit");
      quit.addActionListener(new Listener2());
      sub.add(quit, BorderLayout.SOUTH);
   }
 
   public static Bonus[] input(String filename)
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
      Bonus[] array = new Bonus[numitems];
      for(int k = 0; k < numitems; k++)
      {
         String nameL = infile.next();
         String nameF = infile.next();
         double salary = infile.nextDouble();
         int years = infile.nextInt();
         if(years < 5)
            array[k] = new EmployeeLessThanFive(nameF, nameL, years, salary);
         if(years >= 5 && years <= 10)
            array[k] = new EmployeeFiveToTen(nameF, nameL, years, salary);
         if(years > 10)
            array[k] = new EmployeeMoreThanTen(nameF, nameL, years, salary);
      }
      infile.close();
      return array;
   }
   public static void sort(Bonus[] array)
   {
      int minPos;
      for(int k = 0; k < array.length; k++)
      {
         minPos = findMin(array, array.length - k);
         swap(array, minPos, array.length - k - 1);
      }
      for(int k = 0; k < array.length; k++)
      {
         System.out.println(array[k].getLastName());
      }
   }
   public static int findMin(Bonus[] array, int upper)
   {
      int minIndex = 0;
      for(int index = 0; index < upper; index++)
      {
         if(array[index].compareTo(array[minIndex])< 0)
         {
            minIndex = index;
         }
         
      }
      return minIndex;
   }
   public static void swap(Bonus[] array, int a, int b)
   {
      Bonus temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   private class Listener1 implements ActionListener
   {
      private Bonus[] array;
      public Listener1(Bonus[] a)
      {
         array = a;
      }
      public void actionPerformed(ActionEvent e)
      {
         if(count == array.length)
            System.exit(0);
         else
            System.out.println(""+array[count].toString());
         display.update(array[count].toString());
         count++;        
      }
   }
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
}