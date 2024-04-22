//file.copyを使用しない
import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Main {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("引数の数は2にしてください");
      return;
    }
    
    // 標準入力から、コピー元とコピー先を指定する
    String inFile = args[0];
    String outFile = args[1];
    // ストリームを生成する
    try(
    FileInputStream fis = new FileInputStream(inFile);
    FileOutputStream fos = new FileOutputStream(outFile);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    GZIPOutputStream gzos = new GZIPOutputStream(bos);
    ) {
      // readした文字を一文字ずつ書き込む
      int i = fis.read();
      while(i != -1) {
        gzos.write(i);
        i = fis.read();
      }
      //最後にflushを忘れずに
      gzos.flush();
    }
    catch(IOException e) {
      System.out.print("エラー");
    }
  }
}