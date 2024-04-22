import java.nio.file.*;

public class Another {
  public static void main(String[] args) {
    try {
      Files.copy(Paths.get(args[0]), Paths.get(args[1]));
    }
    catch(java.io.IOException e){
      System.out.println(e);
    }
  }
}