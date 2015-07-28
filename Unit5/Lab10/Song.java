//Name______________________________ Date_____________

public class Song implements Comparable<Song>
{
	//data fields
   private String myTitle;
   private int myMinutes, mySeconds;

	//constructors
   public Song(String toBeParsed)
   {
      String m = toBeParsed.substring(0, toBeParsed.indexOf(":"));
      String s = toBeParsed.substring(toBeParsed.indexOf(":")+1, toBeParsed.indexOf(" "));
      String t = toBeParsed.substring(toBeParsed.indexOf(" ")+1);
      myTitle = t;
      myMinutes = Integer.parseInt(m);
      mySeconds = Integer.parseInt(s);
   }
  
	//accessors and modifiers
   public int getMinutes()
   {
      return myMinutes;
   }
   public void setMinutes( int x)
   {
      myMinutes = x;
   }
   public int getSeconds()
   {
      return mySeconds;
   }
   public void set ( int x)
   {
      mySeconds = x;
   }
   public String getTitle()
   {
      return myTitle;
   }
   public void setTitle( String x)
   {
      myTitle = x;
   }
   public int getTotal()
   {
      return (myMinutes*60) + mySeconds;
   }
   
	
    
   //other methods:  compareTo(), equals(), toString()
   
   public int compareTo(Song arg)
   {
      if(myMinutes < arg.getMinutes())
         return -1;
      if(myMinutes > arg.getMinutes())
         return 1;
      if(mySeconds < arg.getSeconds())
         return -1;
      if(mySeconds > arg.getSeconds())
         return 1;
      return 0;
   }
   public boolean equals(Song arg)
   {
      return false;
   }
   public String toString()
   {
      return myTitle + " " + myMinutes + ":" + mySeconds;
   }
	
}