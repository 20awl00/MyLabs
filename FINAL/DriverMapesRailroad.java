import javax.swing.JFrame;
public class DriverMapesRailroad
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame ("Mapes Railroad");
      frame.setSize(600, 900);
      frame.setLocation(800, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new PanelMapesRailroad());
      frame.setVisible(true);
   }
}
