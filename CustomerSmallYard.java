public class CustomerSmallYard implements Yard
{
   private double myCost;
   private int mySize;
   private String myFirstname, myLastname;
   public CustomerSmallYard(String nameF, String nameL, int size)
   {
      myCost = size*0.005;
      mySize = size;
      myFirstname = nameF;
      myLastname = nameL;
   }
   public double getCost()
   {
      return myCost;
   }
   public String getFirstName()
   {
      return myFirstname;
   }
   public String getLastName()
   {
      return myLastname;
   }
   public int compareTo(Yard y)
   {
   if(getSize() > y.getSize())
      return 1;
   if(getSize() < y.getSize())
      return -1;
   return 0;
   }
   public String toString()
   {
      return "" + myLastname + " " + myFirstname + " " + mySize + " " + myCost;
   }
   public int getSize()
   {
      return mySize;
   }
}