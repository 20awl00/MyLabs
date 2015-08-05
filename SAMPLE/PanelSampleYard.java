//Name______________________________ Date_____________
  

import java.io.*;      //the File class
import java.util.*;    //the Scanner class
import javax.swing.JOptionPane;
import java.util.Comparator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PanelSampleYard extends JPanel
{
   private JLabel title;
   private JButton next, quit;
   private DisplaySampleYard display;
   private int count;
   public PanelSampleYard()
   {
      count = 0;
      Yard[] array = input("greenGrow.txt");
      sort(array);
      setLayout(new BorderLayout());
      title = new JLabel("Green and Grow Mowing Company");
      add(title, BorderLayout.NORTH);
      display = new DisplaySampleYard();
      add(display, BorderLayout.CENTER);
      next = new JButton("Next");
      next.addActionListener(new Listener1(array));
      add(next, BorderLayout.SOUTH);
      quit = new JButton("Quit");
      quit.addActionListener(new Listener2());
   }
 
   public static Yard[] input(String filename)
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
      Yard[] array = new Yard[numitems];
      for(int k = 0; k < numitems; k++)
      {
         String nameL = infile.next();
         String nameF = infile.next();
         int size = infile.nextInt();
         if(size <= 10000)
            array[k] = new CustomerSmallYard(nameF, nameL, size);
         if(size <= 20000 && size > 10000)
            array[k] = new CustomerMediumYard(nameF, nameL, size);
         if(size <= 30000 && size > 20000)
            array[k] = new CustomerLargeYard(nameF, nameL, size);
      }
      infile.close();
      return array;
   }
   public static void sort(Yard[] array)
   {
      int minPos;
      for(int k = 0; k < array.length; k++)
      {
         minPos = findMin(array, array.length - k);
         swap(array, minPos, array.length - k - 1);
      }
   }
   public static int findMin(Yard[] array, int upper)
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
   public static void swap(Yard[] array, int a, int b)
   {
      Yard temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   private class Listener1 implements ActionListener
   {
      private Yard[] array;
      public Listener1(Yard[] a)
      {
         array = a;
      }
      public void actionPerformed(ActionEvent e)
      {
         if(count == 5)
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