import org.code.theater.*;
import org.code.media.*;
import java.util.Random;

public class MyStory extends Scene {

  /*
  ** Calls all the parts of your animation, in order
  */ 
  public void drawScene() {
    
    drawTravelScene();
    chooseJapanCity();
    chooseFranceCity();
    chooseCanadaCity();
    chooseKoreaCity();
    chooseRandomCurrency();
  }
  
  /*
  ** 2D array of cities in Japan, London, Canada, and Korea
  */
  String[][] cities = {
    {"Tokyo", "Osaka", "Kyoto", "Nagoya", "Hiroshima", "Shibuya", "Shinagawa"}, // Cities in Japan
    {"Paris", "Marseille", "Strasbourg", "Bordeaux", "Lyon", "Nantes", "Dijon"}, // Cities in France
    {"Vancouver", "Toronota", "Montreal", "Ottawa", "Calgary", "Quebec", "Windsor"}, // Cities in Canada
    {"Seoul", "Busan", "Incheon", "Daegu", "Chungju", "Ulsan", "Daejeon"} // Cities in Korea
  };

  /*
  ** 2D array of currency exchange (0.25, 0.50, 1, 10, 100)
  */
  double[][] currency = {
    {34.79, 77.58, 155.17, 1551.69, 15516.95}, // USD to yen
    {0.24, 0.49, 0.97, 9.71, 97.08}, // USD to euro
    {0.36, 0.72, 1.45, 14.47, 144.74}, // USD to CAD
    {365.16, 730.31, 1460.63, 14606.27, 146062.74} // USD to won
  };
  
  public void drawTravelScene() {
    // 1. Clear the scene / draw background
    // 2. Set any style (text size, font, font style, fill color)
    // 3. Draw text and images, play sounds
    // 4. Pause before transitioning
    playSound("airplane.wav");
    clear("teal");
    setTextHeight(30);
    setTextColor("pink");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("Places to Travel", 50, 40);
    pause(1.5);
    
    
    ImageFilter japan = new ImageFilter("japan.jpeg");
    drawImage(japan, 20, 75, 170);
    pause(1);
    ImageFilter paris = new ImageFilter("paris.jpg");
    drawImage(paris, 200, 65, 170);
    pause(1);
    ImageFilter canada = new ImageFilter("canada.jpeg");
    drawImage(canada, 20, 220, 170);
    pause(1);
    ImageFilter korea = new ImageFilter("korea.jpg");
    drawImage(korea, 200, 230, 170);
    pause(1);
    
    japan.colorShift(150);
    drawImage(japan, 20, 75, 170);
    pause(1);
    paris.makeNegative();
    drawImage(paris, 200, 65, 170);
    pause(1);
    canada.threshold(130);
    drawImage(canada, 20, 220, 170);
    pause(1);
    korea.changeColor(160);  
    drawImage(korea, 200, 230, 170);
    pause(1.5);
  }

  /*
  ** Chooses a random city from the France array and prints it out
  */
  public void chooseJapanCity() {
    Random rand = new Random();
    String jCity = cities[0][rand.nextInt(cities[0].length)];
    
    clear("maroon");
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("Random City in Japan", 25, 70);
    pause(1);
    if (jCity.length() < 6) {
      setTextColor("pink");      
    } else {
      setTextColor("beige");      
    }
    drawText(jCity.toUpperCase(), 150, 130);
    pause(1);
    
    ImageFilter japan = new ImageFilter("japan.jpeg");
    drawImage(japan, 70, 170, 250);
    pause(1);    
    japan.colorShift(150);
    drawImage(japan, 70, 170, 250);
    pause(1);

  }

  /*
  ** Chooses a random city from the France array and prints it out
  */
    public void chooseFranceCity() {
      Random rand = new Random();
      String fCity = cities[1][rand.nextInt(cities[0].length)];
      
      clear("gray");
      setTextHeight(30);
      setTextColor("white");
      setTextStyle(Font.MONO, FontStyle.BOLD);
      drawText("Random City in France", 15, 70);
      pause(1);
      if (fCity.length() < 6) {
        setTextColor("purple");     
      } else {
        setTextColor("violet");      
      }
      drawText(fCity.toUpperCase(), 130, 120);
      pause(1);
      
      ImageFilter paris = new ImageFilter("paris.jpg");
      drawImage(paris, 75, 170, 250);
      pause(1);
      paris.makeNegative();
      drawImage(paris, 75, 170, 250);
      pause(1);
  }

  /*
  ** Chooses a random city from the Canada array and prints it out
  */
    public void chooseCanadaCity() {
      Random rand = new Random();
      String cCity = cities[2][rand.nextInt(cities[0].length)];
      
      clear("chocolate");
      setTextHeight(30);
      setTextColor("white");
      setTextStyle(Font.MONO, FontStyle.BOLD);
      drawText("Random City in Canada", 15, 70);
      pause(1);
      if (cCity.length() < 7) {    
        setTextColor("tan");
      } else {
        setTextColor("fuchsia");      
      }
      drawText(cCity.toUpperCase(), 140, 120);
      pause(1);
      
      ImageFilter canada = new ImageFilter("canada.jpeg");
      drawImage(canada, 75, 170, 250);
      pause(1); 
      canada.threshold(130);
      drawImage(canada, 75, 170, 250);
      pause(1);
  }

  /*
  ** Chooses a random city from the Korea array and prints it out
  */
    public void chooseKoreaCity() {
      Random rand = new Random();
      String kCity = cities[3][rand.nextInt(cities[0].length)];
      
      clear("indigo");
      setTextHeight(30);
      setTextColor("ivory");
      setTextStyle(Font.MONO, FontStyle.BOLD);
      drawText("Random City in Korea", 15, 70);
      pause(1);
      if (kCity.length() < 6) {
        setTextColor("silver");     
      } else {
        setTextColor("white");      
      }
      drawText(kCity.toUpperCase(), 150, 120);
      pause(1);
      
      ImageFilter korea = new ImageFilter("korea.jpg");
      drawImage(korea, 75, 170, 250);
      pause(1); 
      korea.changeColor(160);  
      drawImage(korea, 75, 170, 250);
      pause(1);
    }

  /*
  ** Chooses a random currency exchange
  */
  public void chooseRandomCurrency() {
    playSound("money.wav");
    clear("white");  
    
    Random rand = new Random(); 
    int row = rand.nextInt(currency.length);
    double[] exchangeRates = currency[row];
    
    String currencyType = "";
    if (row == 0) currencyType = "USD to Yen";
    else if (row == 1) currencyType = "USD to Euro";
    else if (row == 2) currencyType = "USD to CAD";
    else if (row == 3) currencyType = "USD to Won";
    
    setTextHeight(30);
    setTextColor("green");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    
    drawText("Currency Exchange:", 50, 40);
    drawText(currencyType, 100, 80);
    pause(1);

    setTextColor("olive");
    setTextHeight(25);
    int yPosition = 150;  
    for (int i = 0; i < exchangeRates.length; i++) {
        String exchange = "";
        if (i == 0) exchange = "0.25";
        else if (i == 1) exchange = "0.50";
        else if (i == 2) exchange = "1";
        else if (i == 3) exchange = "10";
        else if (i == 4) exchange = "100";
        drawText("Exchange " + exchange + ": " + exchangeRates[i], 10, yPosition);
        yPosition += 40;  

    }
  }

}