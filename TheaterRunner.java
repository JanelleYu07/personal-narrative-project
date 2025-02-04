import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // 2D Array
    String[][] array1 = {
      {"thing1", "thing2"},
      {"thing3", "thing4"}
    };

    ImageFilter[][] array2 = {
      { new ImageFilter("japan.jpeg"), new ImageFilter("paris.jpg") },
      { new ImageFilter("canada.jpeg"), new ImageFilter("korea.jpg") },
    };

    // MyStory object
    MyStory scene = new MyStory();
    
    // Call drawScene
    scene.drawScene();
    
    // Play scene in Theater
    Theater.playScenes(scene);
    
  }
}