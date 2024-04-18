import java.util.function.*;
import java.util.stream.*;
import java.util.*;

public class Main{
  public static void main(String[] args) {
    FuncList funclist = new FuncList();

    Func1 f1 = x -> x % 2 == 1;
    Func2 f2 = (point, name) -> String.format("%sさんは%s", name, point>65 ?"合格" : "不合格");

    System.out.println(f1.call(15));
    System.out.println(f2.call(66,"sanada"));

    List<String> list = new ArrayList<>(Arrays.asList("さなだ", "くるみ", "きもてぃか", "へあっ！！"));
    list = list.stream()
            .map(x -> x.length() <= 4 ? x + "さん" : x )
            .collect(Collectors.toList());
    System.out.println(list);
  }
}

// class FuncList {
//   public static boolean isOdd(int x) {return (x %  2 == 1);}
//   public String passCheck(int point, String name) {
//     return String.format("%sさんは%s", name, point>65 ?"合格" : "不合格");
//   }
// }

@FunctionalInterface
interface Func1 {
  boolean call(int x);
}

@FunctionalInterface
interface Func2 {
  String call(int point, String name);
}

