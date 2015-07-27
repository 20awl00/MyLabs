public class Distance implements Comparable<Distance>
{
   private int myPounds, myOunces;
   public Distance()
   {
      myPounds = myOunces = 0;
   }
   public Distance(int x, int y)
   {
      myPounds = x;
      myOunces = y;
   }
   public int getPounds()
   {
      return myPounds;
   }
   public int getOunces()
   {
      return myOunces;
   }
   public void setPounds(int x)
   {
      myPounds = x;
   }
   public void setOunces(int y)
   {
      myOunces = y;
   }
   public int compareTo(Distance w)
   {
      int myTotal = myPounds * 12 + myOunces;
      int wTotal = w.getPounds() * 12 + w.getOunces();
      return myTotal - wTotal;
   }
   public boolean equals(Distance arg)
   {
      return compareTo(arg) == 0;
   }
   public String toString()
   {
      return myPounds + " ft. " + myOunces + " in. ";
   }
}