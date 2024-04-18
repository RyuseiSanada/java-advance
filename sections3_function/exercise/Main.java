import java.util.function.*;

public class Main{
  public static void main(String[] args) {
    FuncList funclist = new FuncList();

    Func1 f1 = FuncList::isOdd;
    Func2 f2 = funclist::passCheck;

    System.out.println(f1.call(15));
    System.out.println(f2.call(66,"sanada"));
  }
}

class FuncList {
  public static boolean isOdd(int x) {return (x %  2 == 1);}
  public String passCheck(int point, String name) {
    return String.format("%sさんは%s", name, point>65 ?"合格" : "不合格");
  }
}

interface Func1 {
  boolean call(int x);
}

interface Func2 {
  String call(int point, String name);
}

