   //
   // Torbert, 24 July 2013
	//
   import java.awt.Color;
   import java.awt.image.BufferedImage;
	//
   public class PixelOperations
   {
      public Color[][] getArray(BufferedImage img)
      {
         Color[][] arr;
      	//
         int numcols = img.getWidth();
         int numrows = img.getHeight();
      	//
         arr = new Color[numrows][numcols];
      	//
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               int rgb = img.getRGB(k,j);
            	//
               arr[j][k] = new Color(rgb);
            }
         }
      	//
         return arr;
      }
      public void setImage(BufferedImage img, Color[][] arr)
      {
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               Color tmp = arr[j][k];
               //
               int rgb = tmp.getRGB();
               //
               img.setRGB(k,j,rgb);
            }
         }
      }
      //
   	/**********************************************************************/
   	//
   	// pixel operations
   	// 
      public void zeroBlue(Color[][] arr)
      {
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               Color tmp = arr[j][k];
               arr[j][k] = new Color( tmp.getRed(), tmp.getGreen(), 0 );
            }
         }
      }
   	//--------> your new methods go here   <--------------
   	public void negate(Color[][] arr)
      {
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               Color tmp = arr[j][k];
               arr[j][k] = new Color( 255-tmp.getRed(), 255-tmp.getGreen(), 255-tmp.getBlue() );
            }
         }
      }
      public void gray(Color[][] arr)
      {
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               Color tmp = arr[j][k];
               arr[j][k] = new Color( ((tmp.getRed()+tmp.getGreen()+tmp.getBlue())/3), ((tmp.getRed()+tmp.getGreen()+tmp.getBlue())/3) , ((tmp.getRed()+tmp.getGreen()+tmp.getBlue())/3)  );
            }
         }
      }
      public void sepia(Color[][] arr)
      {
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               Color tmp = arr[j][k];
               int red = (int)((tmp.getRed()*.393)+(tmp.getGreen()*.769)+(tmp.getBlue()*.189));
               int green = (int)((tmp.getRed()*.349)+(tmp.getGreen()*.686)+(tmp.getBlue()*.168));
               int blue = (int)((tmp.getRed()*.272)+(tmp.getGreen()*.534)+(tmp.getBlue()*.131));
               if(red < 0)
                  red = 0;
               if(red > 255)
                  red = 255;
               if(green < 0)
                  green = 0;
               if(green > 255)
                  green = 255;
               if(blue < 0)
                  blue = 0;
               if(blue > 255)
                  blue = 255;
               arr[j][k] = new Color( red, green, blue);
            }
         }
      }
      public void blur(Color[][] arr)
      {
         for(int j = 1; j < arr.length - 1; j++)
         {
            for(int k = 1; k < arr[0].length - 1; k++)
            {
               Color tmp = arr[j][k];
               int maRed = tmp.getRed();
               int maBlue = tmp.getBlue();
               int maGreen = tmp.getGreen();
               int topRed = arr[j - 1][k].getRed();
               int leftRed = arr[j][k - 1].getRed();
               int rightRed = arr[j][k + 1].getRed();
               int botRed = arr[j + 1][k].getRed();
               int topBlue = arr[j - 1][k].getBlue();
               int leftBlue = arr[j][k - 1].getBlue();
               int rightBlue = arr[j][k + 1].getBlue();
               int botBlue = arr[j + 1][k].getBlue();
               int topGreen = arr[j - 1][k].getGreen();
               int leftGreen = arr[j][k - 1].getGreen();
               int rightGreen = arr[j][k + 1].getGreen();
               int botGreen = arr[j + 1][k].getGreen();
               int red = ((topRed+rightRed+leftRed+botRed+maRed)/5);
               int green = ((topGreen+rightGreen+leftGreen+botGreen+maGreen)/5);
               int blue = ((topBlue+botBlue+leftBlue+rightBlue+maBlue)/5);
               if(red < 0)
                  red = 0;
               if(red > 255)
                  red = 255;
               if(green < 0)
                  green = 0;
               if(green > 255)
                  green = 255;
               if(blue < 0)
                  blue = 0;
               if(blue > 255)
                  blue = 255;
               arr[j][k] = new Color( red, green, blue );
            }
         }
      }
   	public void mirrorLR(Color[][] arr)
      {
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length/2; k++)
            {
               Color tmp = arr[j][k];
               int red = arr[j][k].getRed();
               int green = arr[j][k].getGreen();
               int blue = arr[j][k].getBlue();
               arr[j][arr[0].length - k - 1] = new Color( red, green, blue );
            }
         }
      }
      public void mirrorUD(Color[][] arr)
      {
         for(int j = 0; j < arr.length/2; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               Color tmp = arr[j][k];
               int red = arr[j][k].getRed();
               int green = arr[j][k].getGreen();
               int blue = arr[j][k].getBlue();
               arr[arr.length - j - 1][k] = new Color( red, green, blue );
            }
         }
      }
      public void flipLR(Color[][] arr)
      {
         for(int j = 0; j < arr.length; j++)
         {
            for(int k = 0; k < arr[0].length/2; k++)
            {
               Color tmp = arr[j][k];
               int red = arr[j][k].getRed();
               int green = arr[j][k].getGreen();
               int blue = arr[j][k].getBlue();
               int red2 = arr[j][arr[0].length - k - 1].getRed();
               int green2 = arr[j][arr[0].length - k - 1].getGreen();
               int blue2 = arr[j][arr[0].length - k - 1].getBlue();
               arr[j][arr[0].length - k - 1] = new Color( red, green, blue );
               arr[j][k] = new Color( red2, green2, blue2);
            }
         }
      }
      public void flipUD(Color[][] arr)
      {
         for(int j = 0; j < arr.length/2; j++)
         {
            for(int k = 0; k < arr[0].length; k++)
            {
               Color tmp = arr[j][k];
               int red = arr[j][k].getRed();
               int green = arr[j][k].getGreen();
               int blue = arr[j][k].getBlue();
               int red2 = arr[arr.length - j - 1][k].getRed();
               int green2 = arr[arr.length - j - 1][k].getGreen();
               int blue2 = arr[arr.length - j - 1][k].getBlue();
               arr[arr.length - j - 1][k] = new Color( red, green, blue );
               arr[j][k] = new Color( red2, green2, blue2);
            }
         }
      }
      public void pixelate(Color[][] arr)
      {
         for(int j = 1; j < arr.length - 1; j+= 2)
         {
            for(int k = 1; k < arr[0].length - 1; k+=2)
            {
               Color tmp = arr[j][k];
               int maRed = tmp.getRed();
               int maBlue = tmp.getBlue();
               int maGreen = tmp.getGreen();
               arr[j - 1][k] = new Color(maRed, maGreen, maBlue);
               arr[j][k - 1] = new Color(maRed, maGreen, maBlue);
               arr[j][k + 1] = new Color(maRed, maGreen, maBlue);
               arr[j + 1][k] = new Color(maRed, maGreen, maBlue);
               arr[j - 1][k - 1] = new Color(maRed, maGreen, maBlue);
               arr[j + 1][k + 1] = new Color(maRed, maGreen, maBlue);
               arr[j + 1][k - 1] = new Color(maRed, maGreen, maBlue);
               arr[j - 1][k + 1] = new Color(maRed, maGreen, maBlue);
            }
         }
      }
   	
     
   }
   //
	// end of file
	//