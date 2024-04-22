import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Employee tanaka = new Employee("田中", 41);
    Department somu = new Department("総務部", tanaka);

    try(
      FileOutputStream fos = new FileOutputStream("company.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
    ){
      oos.writeObject(somu);
      oos.flush();
    } catch(IOException e){
      System.out.printf("失敗");
    }
  }
}