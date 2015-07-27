	//Name______________________________ Date_____________
    public class Salesperson 
   {
   	//data fields
      private String myName;
      private int myCars, myTrucks;
   
   	//constructors
   
      public Salesperson(int x, int y)
      {
         myCares = x;
         myTrucks = y;
      }
   
   	//accessors and modifiers
   
      public int getCars()
      {
         return myCars;
      }
      public int getTrucks()
      {
         return myTrucks;
      }
      public void setCars(int x)
      {
         myCars = x;
      }
      public void setTrucks(int y)
      {
         myTrucks = y;
      }
   
   
   	//other methods: toString
   
      public String toString(String s, int x, int y, int z)
      {
         return s + " " + x + " " + y + " " + z;
      }
   }