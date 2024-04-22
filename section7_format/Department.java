import java.io.*;

public class Department implements Serializable{
  String name;
  Employee leader;
  public Department(String name, Employee leader) {
    this.name = name;
    this.leader = leader;
  }
}