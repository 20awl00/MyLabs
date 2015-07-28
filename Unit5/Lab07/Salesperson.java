	//Name______________________________ Date_____________
    public class Salesperson 
   {
   	//data fields
      private String myName;
      private int myCars, myTrucks;
   
   	//constructors
   
      public Salesperson(String name, int x, int y)
      {
         myName = name;
         myCars = x;
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
      public String getName()
      {
         return myName;
      }
      public void setName(String s)
      {
         myName = s;
      }
   
   	//other methods: toString
   
      public String toString(String s, int x, int y, int z)
      {
         return s + " " + x + " " + y + " " + z;
      }
   }