import javax.swing.JFrame;
public class DriverSampleYard
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame ("SampleYard");
      frame.setSize(600, 900);
      frame.setLocation(800, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new PanelSampleYard());
      frame.setVisible(true);
   }
}
