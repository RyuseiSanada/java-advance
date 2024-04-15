import java.util.*;

public class Main {
  public static void main(String[] args) {
    StrongBox<Integer> box = new StrongBox<Integer>(KeyType.BUTTON, 4649);
    Optional<Integer> item = null;
    for (int i=0; i<=100000; i++) {
      item = box.get();
    }
    if(item.isPresent()) {
      System.out.print(item);
    } else {
      System.out.print("試行回数が足りません");
    }

  }
}