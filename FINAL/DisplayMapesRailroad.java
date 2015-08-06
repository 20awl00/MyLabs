import javax.swing.*;
import java.awt.*;
public class DisplayMapesRailroad extends JPanel
{
   private JTextField last, first, salary, years, bonus, total;
   private JLabel l, f, s, y, b, t;
   private double totalT;
   public DisplayMapesRailroad()
   {
      totalT = 0;
      setLayout(new GridLayout(6, 2));
      l = new JLabel("Last Name: ");
      add(l);
      last = new JTextField();
      add(last);
      f = new JLabel("First Name: ");
      add(f);
      first = new JTextField();
      add(first);
      s = new JLabel("Salary: ");
      add(s);
      salary = new JTextField();
      add(salary);
      y = new JLabel("Years: ");
      add(y);
      years = new JTextField();
      add(years);
      b = new JLabel("Bonus: ");
      add(b);
      bonus = new JTextField();
      add(bonus);
      t = new JLabel("Total Bonus: ");
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
      salary.setText(array[2]);
   //                break;
   //             case 4:
      years.setText(array[3]);
   //               break;
   //             case 5:
      bonus.setText(array[4]);
      totalT += Double.parseDouble(bonus.getText());
      System.out.println(""+totalT);
      total.setText(""+totalT);
   }
}
