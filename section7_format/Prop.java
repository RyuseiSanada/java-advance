import java.io.*;
import java.util.*;

public class Prop {
  public static void main(String[] args) {
    
    try(FileReader fr = new FileReader("pref.properties");)
    {
    Properties p = new Properties();

    p.load(fr);
    System.out.println(p.getProperty("aichi.capital"));
    }
    catch (IOException e) {
      System.out.println("エラー");
    }
  }
}