	//Name______________________________ Date_____________
   import javax.swing.*;
   public class EMail
   {
      private String myUserName;
      private String myHostName;
      private String myExtension;
      public EMail(String address)
      {
         myUserName = address.substring(0, address.indexOf("@"));
         myHostName = address.substring(address.indexOf("@"), address.indexOf("."));
         myExtension = address.substring(address.indexOf("."));
      }
      public String getUserName()
      {
         return myUserName;
      }
      public String getHostName()
      {
         return myHostName;
      }
      public String getExtension()
      {
         return myExtension;
      }
      public String toString()
      {
         String s = myUserName+myHostName+myExtension;
         return s;
      }
   }