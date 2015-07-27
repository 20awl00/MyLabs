public class Driver03
{
   public static void main(String[] args)
   {
      int[] array = {100, 101, 102, 103, 104, 105, 106, 107, 108, 109};
      print(array);
      scramble(array);
      print(array);
      sort(array);
      print(array);
   }
   public static int[] sort(int[] array)
   {
      int maxPos;
      for(int k = 0; k < array.length; k++)
      {
         maxPos = findMax(array, array.length - k - 1);
         swap(array, maxPos, array.length - k - 1);
      }
      return array;
   }
   public static int findMax(int[] array, int upper)
   {
      double max = array[0];
      int maxIndex = 0;
      for(int index = 0; index <= upper; index++)
      {
         if(array[index] > max)
         {
            maxIndex = index;
            max = array[index];
         }
      }
      return maxIndex;
   }
   public static void swap(int[] array, int a, int b)
   {
      int temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
   public static int[] scramble(int[] array)
   {
      int y = 0;
      int temp = 0;
      for(int i = 0;  i < array.length; i++)
      {
         y = (int)(Math.random()*9);
         temp = array[i];
         array[i] = array[y];
         array[y] = temp;
      }
      return array;
   }
   public static void print(int[] array)
   {
      for(int i = 0; i < array.length; i++)
         System.out.print(array[i] + ", ");
      System.out.println();
   }
}