import java.io.*;

public class Employee implements Serializable {
  String name;
  int age;
  public Employee(String name, int age) {
    this.age = age;
    this.name = name;
  }
}