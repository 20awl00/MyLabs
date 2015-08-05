import javax.swing.*;
import java.awt.*;
public class DisplaySampleYard extends JPanel
{
   private JTextField last, first, size, cost, total;
   private JLabel l, f, s, c, t;
   private double totalT;
   public DisplaySampleYard()
   {
      totalT = 0;
      setLayout(new GridLayout(5, 2));
      l = new JLabel("Last Name: ");
      add(l);
      last = new JTextField();
      add(last);
      f = new JLabel("First Name: ");
      add(f);
      first = new JTextField();
      add(first);
      s = new JLabel("Lawn Size: ");
      add(s);
      size = new JTextField();
      add(size);
      c = new JLabel("Total Cost: ");
      add(c);
      cost = new JTextField();
      add(cost);
      t = new JLabel("Running Total: ");
      add(t);
      total = new JTextField();
      add(total);
   }
   public void update(String data)
   {
      String[] array = data.split(" ");
   //      for(int i = 1; i <=array.length; i++)
   //       {
   //          switch(i){
   //             case 1:
      last.setText(array[0]);
    //            break;
   //             case 2:
      first.setText(array[1]);
   //              break;
   //             case 3:
      size.setText(array[2]);
   //                break;
   //             case 4:
      cost.setText(array[3]);
   //               break;
   //             case 5:
      totalT += Double.parseDouble(cost.getText());
      System.out.println(""+totalT);
      total.setText(""+totalT);
   }
}
