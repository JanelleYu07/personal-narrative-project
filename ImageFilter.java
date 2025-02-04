import org.code.theater.*;
import org.code.media.*;

/*
*  Represents an image that contains multiple filters
*/

public class ImageFilter extends ImagePlus {

  /*
  * Calls the superclass constructor to initialize the 2D array
  */

  public ImageFilter(String filename) {
    super(filename);
  }

  /* IMAGE FILTERS FROM LESSON 8 */

  
  /*
  * Shifts the color of each Pixel object by a fixed amount
  */
   public void colorShift(int value) {
     
    // Get 2D array of Pixel object
    Pixel[][] pixels = getPixelsFromImage();

    // Traverse the 2D array
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel p = pixels[row][col];

        // Get the values of each color
        int red = p.getRed();
        int green = p.getGreen();
        int blue = p.getBlue();

        // Add the value inputted in the TheaterRunner class to the new value
        red += value;
        green += value;
        blue += value;

        // If new color value is greater than 255, set color to 255
        if (red > 255) {
          red = 255;
        }
        if (green > 255) {
          green = 255;
        }
        if (blue > 255) {
          blue = 255;
        }

        // Set the new colors back into the pixel object
        p.setRed(red);
        p.setGreen(green);
        p.setBlue(blue);
      }
    }
  }

  /*
  * Inverts the colors in the image by setting the red, green, and blue color values of each Pixel object to the result of 255 minus their current values
  */
  public void makeNegative() {

    Pixel[][] pixels = getPixelsFromImage();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
      Pixel currentPixel = pixels[row][col];

        int red = 255 - currentPixel.getRed();
        int green = 255 - currentPixel.getGreen();
        int blue = 255 - currentPixel.getBlue();
        
        currentPixel.setColor(new Color(red, green, blue));
      }
    }
  }

  /*
  * Converts image to black or white by comparing grayscale value
  */
    public void threshold(int value) {

    Pixel[][] pixels = getPixelsFromImage();
    // Traverse the 2D array of Pixel
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel p = pixels[row][col];

        // Gets the red, green, and blue values of each Pixel
        int red = p.getRed();
        int green = p.getGreen();
        int blue = p.getBlue();

        // Calculats average of the red, green, and blue value of each Pixel
        int average = (red + green + blue) / 3;

        if (average < value) { // Sets pixels to black if average is less than threshold
          p.setRed(0);
          p.setGreen(0);
          p.setBlue(0);
        } else { // Sets pixels to white if average is larger than threshold
          p.setRed(255);
          p.setGreen(255);
          p.setBlue(255);
        }
      }
    }

  }

  /*
  ** Changes image to purple if value > 100, and green in value < 100
  */
  public void changeColor(int value) {
    Pixel[][] pixels = getPixelsFromImage();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel p = pixels[row][col]; 

          int red = p.getRed();   
          int green = p.getGreen();
          int blue = p.getBlue();

          if (value > 150) {
            red = 3 * red;        
            green = green;
            blue = 3 * blue;
            } else {
            red = red;
            green = 4 * green;    
            blue = blue;
            }

        p.setColor(new Color(red, green, blue));

      }
    }
    
  }
}