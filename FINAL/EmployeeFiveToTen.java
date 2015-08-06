public class EmployeeFiveToTen implements Bonus
{
   private double myBonus, mySalary;
   private int myYears;
   private String myFirstname, myLastname;
   public EmployeeFiveToTen(String nameF, String nameL, int years, double salary)
   {
      myBonus = .0575 * salary;
      mySalary = salary;
      myYears = years;
      myFirstname = nameF;
      myLastname = nameL;
   }
   public double getSalary()
   {
      return mySalary;
   }
   public String getFirstName()
   {
      return myFirstname;
   }
   public String getLastName()
   {
      return myLastname;
   }
   public int compareTo(Bonus b)
   {
      return getLastName().compareTo(b.getLastName());
   }
   public String toString()
   {
      return "" + myLastname + " " + myFirstname + " " + mySalary + " " + myYears + " " + myBonus;
   }
   public double getBonus()
   {
      return myBonus;
   }
   public int getYears()
   {
      return myYears;
   }
}