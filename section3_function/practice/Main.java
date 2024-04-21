import java.util.function.*;

public class Main {

  public static void main(String[] args) {
    Function<String, Integer> func = 
      s -> s.length();

    int a = func.apply("Java");
    System.out.printf("文字列は「Java」は%d文字です", a);
  }

}