import java.lang.reflect.*;
import java.util.stream.*;
import java.util.List;
import java.util.Arrays;

public class Launcher {
  public static void main(String[] args) {
    // コマンドライン引数から2つの情報を受け取る
      // 起動するクラスのFQCN
      // 起動方法を示す文字 E, I
    String fqcn = args[0];
    String sw = args[1];
      
    // 現在のメモリ使用量の表示
    showMemory();

    try {
      //Classの情報を取得
      Class<?> cinfo = Class.forName(fqcn);
      // FQCNが持つ全てのメソッド名を表示
      showMethodsList(cinfo);
    
      // 指定された方法によって次のように起動
        // E：RrocessBuilder
        // I：リフレクションでMainを呼び出す
      switch(sw) {
        case "E" -> launchExternal(cinfo);
        case "I" -> launchInternal(cinfo);
        default -> throw new IllegalArgumentException("起動方法が不正です");
      } 
    } catch(Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        System.exit(1);
    }
    // 現在のメモリ使用量の表示
    showMemory();
    // 終了する際には起動に成功したら0、失敗したら1 
    System.exit(0);
  }
  
  public static void showMethodsList(Class<?> cinfo) {
    System.out.println("メソッド一覧");
    Method[] methods = cinfo.getDeclaredMethods();
    Arrays.asList(methods).stream().forEach(x -> System.out.println(x.getName()));
  }

  public static void launchExternal(Class<?> cinfo) throws Exception {
    ProcessBuilder pb = new ProcessBuilder(
      "java", cinfo.getName() //第一引数の第二引数のコマンドを実行（場合による）
    );
    Process proc = pb.start();
    proc.waitFor();
  }

  public static void launchInternal(Class<?> cinfo) throws Exception {
    Method m = cinfo.getMethod("main", String[].class);
    String[] args = {};
    m.invoke(null, (Object)args);
  }

  public static void showMemory() {
    long free = Runtime.getRuntime().freeMemory();
    long total = Runtime.getRuntime().totalMemory();
    long usege = (total - free) / 1024 / 1024;
    System.out.println("現在の使用量"+usege + "MB");
  }
}